package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore_Testcase_2 extends base{
	
	public static void main(String [] args) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@text = 'Female' ]")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    driver.findElement(MobileBy.AndroidUIAutomator
		    		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
	    
	    driver.findElement(MobileBy.AndroidUIAutomator("text(\"Australia\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String toastErrMsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastErrMsg);
		Assert.assertEquals("Please enter your name", toastErrMsg.trim());
	}

}
