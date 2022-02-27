package appium;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scrolling_Action extends base{
	
	
	public static void main(String [] args) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	    driver.findElement(MobileBy.AndroidUIAutomator
	    		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"));"));
		
		
	}

}
