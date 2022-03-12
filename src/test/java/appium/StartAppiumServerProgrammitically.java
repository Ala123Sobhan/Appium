package appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;



public class StartAppiumServerProgrammitically {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public static AppiumDriverLocalService startServer() {
		//
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
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}
	
	@BeforeTest
	public void killAllNodes() throws IOException {
		
		Runtime.getRuntime().exec("taskkill  /F  /IM node.exe");
		
	}
	
	@AfterTest
	public void killAllNodes2() throws IOException {
		
		Runtime.getRuntime().exec("taskkill  /F  /IM node.exe");
		
	}
	
	/**
	 * 
	 * C:\Users\ala12\AppData\Local\Android\Sdk\emulator
	 *
	 * 
	 * */
	
	
	 public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException
		{
			//chrome -url
			//app .apk, device, 4723
			//androidDriver 
			AndroidDriver<AndroidElement> driver;

			DesiredCapabilities cap= new DesiredCapabilities();
	     	File appDir = new File("src/test/java/appium");
	       	File app = new File(appDir, "General-Store.apk");

	        startEmulator();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	       // cap.setCapability("newCommandTimeout", "3600");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
			
	        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        return driver;
		}
	
	
	private static void startEmulator() throws IOException, InterruptedException {
		
		    //  C:\Users\ala12\eclipse-workspace\Appium\src\main\java\resources\startEmulator.bat
			Runtime.getRuntime().exec("cmd /c start startEmulator.bat");
			Thread.sleep(6000);
		

	}

	@Test
	public static void startAppiumServer() throws InterruptedException, IOException
	{
		AppiumDriverLocalService s = startServer();
		s.start();
		
		Thread.sleep(8000);
		
		driver= capabilities();
		
		//Thread.sleep(10000);
		
		s.stop();
	}
	
}
