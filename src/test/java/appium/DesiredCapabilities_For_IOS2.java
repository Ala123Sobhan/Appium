package appium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Unit test for simple App.
 */
public class DesiredCapabilities_For_IOS2 
{
    
	public static IOSDriver capabilities() throws MalformedURLException
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
		cap.setCapability("commandTimeouts", "12000");

		cap.setCapability(MobileCapabilityType.APP, "/Users/ala/Library/Developer/Xcode/DerivedData/longtap-agquxbhkvcmzfaemijfgkhiwyeua/Build/Products/Debug-iphonesimulator/longtap.app");
	
		IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
		return driver;
		
		
		
		
	}
    
}
