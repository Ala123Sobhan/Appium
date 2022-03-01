package appium;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	 public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	{
		//chrome -url
		//app .apk, device, 4723
		//androidDriver 
		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities cap= new DesiredCapabilities();
     	File appDir = new File("src/test/java/appium");
       	File app = new File(appDir, "General-Store.apk");

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
       // cap.setCapability("newCommandTimeout", "3600");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
	}
}
