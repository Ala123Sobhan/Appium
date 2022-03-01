package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore_Testcase_1 extends base{
	
	public static void main(String [] args) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ala");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text = 'Female' ]")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    driver.findElement(MobileBy.AndroidUIAutomator
		    		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
	    
	    driver.findElement(MobileBy.AndroidUIAutomator("text(\"Australia\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}

}
