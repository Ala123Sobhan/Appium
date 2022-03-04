package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class chromeBase  {
	
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
	      DesiredCapabilities cap = new DesiredCapabilities();
	      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
	      cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	      cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	      cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		  cap.setCapability("chromedriverExecutable",    "C:/Users/ala12/AppData/Roaming/npm/node_modules/appium/node_modules/appium-chromedriver/chromedriver/win/chromedriver.exe");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}

}
