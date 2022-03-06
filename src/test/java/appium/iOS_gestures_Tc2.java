package appium;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;

public class iOS_gestures_Tc2 extends DesiredCapabilities_For_IOS {
	
	public static void main(String [] args) throws MalformedURLException, InterruptedException
	{
		IOSDriver driver = capabilities();
		
		//use either id, xpath or name to locate ios elements
		
		//scroll, tap, longpress, slide
		
		//scroll down until element is visible
		HashMap<String , Object> scrollObj = new HashMap<>();
		scrollObj.put("direction", "down");
		scrollObj.put("name", "Web View");
		
		driver.executeScript("mobile:scroll", scrollObj );
        driver.findElementByAccessibilityId("Web View").click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
		driver.findElementByAccessibilityId("Green color component value").sendKeys("190");
		driver.findElementByAccessibilityId("Blue color component value").sendKeys("135");
		
		
		
	}

}
