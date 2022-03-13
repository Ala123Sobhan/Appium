package appium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class StartAppiumServer_Simulator {
	
	public static IOSDriver<WebElement> driver;
	public static AppiumDriverLocalService service;
	static AppiumDriverLocalService s;

	public static AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	@BeforeMethod
	public void killAllNodes() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("ps -A | grep appium");
		s = startServer();
		s.start();
		Thread.sleep(8000);


	}

	public static IOSDriver<WebElement> capabilities(String deviceName, String platformVersion, String udid)
			throws IOException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

		startSimulator(udid);

		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability("udid", udid);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

		driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
		return driver;

	}

	private static void startSimulator(String udid) throws IOException {

		//open -a Simulator --args -CurrentDeviceUDID 0566AC33-9B91-2DR2-B5BB-C916D3BA8MD3
		//Runtime.getRuntime().exec("open -a Simulator.app");
		Runtime.getRuntime().exec("open -a Simulator --args -CurrentDeviceUDID "+udid);
	}

	private static void closeSimulator() throws IOException {

		Runtime.getRuntime().exec("killall iOS Simulator");

	}

	@Test(dataProvider = "data-provider")
	public static void startAppiumServer(String deviceName, String platformVersion, String udid)
			throws InterruptedException, IOException {
	
		driver = capabilities(deviceName, platformVersion, udid);

		driver.get("https://intake.hubblecontacts.com/get-lenses");

	}

	@AfterMethod
	public void teardown() throws IOException {
		driver.quit();
		closeSimulator();
		s.stop();
	}

	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "iPhone 12", "15.2", "E5FFFB23-B209-4DA9-86CA-7E484B09F0AE" },
				{ "iPad", "15.2", "9979C7B9-0455-421F-8379-26FD8EDB2475" } };
	}

}
