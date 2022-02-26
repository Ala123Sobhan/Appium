package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Test1 extends base{
	
	
	public static void main(String []args) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = capabilities();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        
//		//xpath, id, classname, andriodUIautomator
		driver.findElementByXPath("//android.widget.TextView[@text = 'Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text = '3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	    driver.findElementByXPath("//android.widget.EditText[@resource-id = 'android:id/edit']").sendKeys("Hello Andrioid");
	    
	    driver.findElementsByClassName("android.widget.Button").get(1).click();
	    
	    
	}

}
