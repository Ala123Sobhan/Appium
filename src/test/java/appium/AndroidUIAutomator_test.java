package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUIAutomator_test extends base{
	
	
	public static void main(String []args) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElementByAccessibilityId("value of content-desc for android").click();

		
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		int s = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"))
				.size();
		System.out.println(s);
		
		
	}

}
