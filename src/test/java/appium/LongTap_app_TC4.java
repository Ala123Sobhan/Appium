package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LongTap_app_TC4 extends DesiredCapabilities_For_IOS2 {

	
	public static void main(String [] args) throws MalformedURLException, InterruptedException
	{
		IOSDriver driver = capabilities();
		
		
		//long press
	  MobileElement e = (MobileElement)driver.findElementByName("Long tap");
	  
	  IOSTouchAction touch = new IOSTouchAction(driver);
	  
	  touch.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2))).release().perform();
	  
	  //tap
	  
	  MobileElement t = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSwitch[1]"));
	  
	  touch.tap(tapOptions().withElement(element(t))).perform();
	  
	}
}
