package appium;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOS_gestures_Tc3 extends DesiredCapabilities_For_IOS {
	
	public static void main(String [] args) throws MalformedURLException, InterruptedException
	{
		IOSDriver driver = capabilities();
		
		//use either id, xpath or name to locate ios elements
		
		//scroll, tap, longpress, slide
		
		//slide
		
		driver.findElementByAccessibilityId("Sliders").click();
		
		IOSElement slider = (IOSElement)driver.findElement(By.xpath("//XCUIElementTypeSlider"));
		
		slider.setValue("0%");
		System.out.println(slider.getAttribute("value"));
		slider.setValue("1%");
		System.out.println(slider.getAttribute("value"));
		
		
		
		
		
		
	}

}
