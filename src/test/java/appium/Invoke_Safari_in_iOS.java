package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Invoke_Safari_in_iOS {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//		cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
//		cap.setCapability("commandTimeouts", "12000");

		
		
		//cap.setCapability(MobileCapabilityType.APP, "/Users/ala/Library/Developer/Xcode/DerivedData/longtap-agquxbhkvcmzfaemijfgkhiwyeua/Build/Products/Debug-iphonesimulator/longtap.app");
	
		AppiumDriver driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.get("https://saucelabs.com/test/guinea-pig");
		
		Thread.sleep(3000);

		WebElement div = driver.findElement(By.id("i_am_an_id"));
	
		System.out.print(div.getText());
		
		driver.findElement(By.id("comments")).sendKeys("HELLO WEB APP FROM IOS");

	}

}
