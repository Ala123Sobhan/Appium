package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebView_automation_using_android extends chromeBase {
	
	
	public static void main(String [] args) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		driver.findElement(By.cssSelector("a[href *= 'products']")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		String course = driver.findElement(By.xpath("(//li[@class = 'list-group-item'])[3]/div/div/a")).getText();
		System.out.println(course);
		
		driver.findElement(By.xpath("(//li[@class = 'list-group-item'])[3]/div/div/a")).click();
	}

}
