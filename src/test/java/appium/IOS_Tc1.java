package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;

public class IOS_Tc1 extends DesiredCapabilities_For_IOS {
	
	
	public static void main(String [] args) throws MalformedURLException
	{
		IOSDriver driver = capabilities();
		
		//use either id, xpath or name to locate ios elements
		
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByAccessibilityId("Text Entry").click();
		driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("hello ios");
		System.out.println(driver.findElement(By.xpath("//XCUIElementTypeTextField")).getText());
		driver.findElementByAccessibilityId("OK").click();
		
		driver.findElementByAccessibilityId("Confirm / Cancel").click();
		String msg = driver.findElement(By.xpath("//*[contains(@name, 'message')]")).getText();
		System.out.println(msg);
		driver.findElementByAccessibilityId("Confirm").click();
		
	}

}
