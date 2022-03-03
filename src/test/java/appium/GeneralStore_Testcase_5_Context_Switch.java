package appium;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ById;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class GeneralStore_Testcase_5_Context_Switch extends base{
	public static void main(String [] args) throws MalformedURLException, InterruptedException
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
		
	    driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	    driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    
	    Thread.sleep(3000);
	    
	    int c = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	    double sum = 0;
	    for(int i =0; i<c; i++)
	    {
	    	sum+= getAmount(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().trim());
	    }
	    
	    double total= getAmount(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().trim());
	    
	    System.out.println(sum);
	    Assert.assertEquals(total, sum);
	    
	    AndroidElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
	    TouchAction t = new TouchAction(driver);
	    t.tap(tapOptions().withElement(element(checkBox))).perform();
	    
	    AndroidElement tosBtn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	    t.longPress(longPressOptions().withElement(element(tosBtn)).withDuration(ofSeconds(2))).release().perform();
	    
	    driver.findElement(By.id("android:id/button1")).click();
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	    
	    Thread.sleep(8000);
	    
	    Set<String> contexts = driver.getContextHandles();
	    
	    for(String context : contexts)
	    {
	    	System.out.println(context);
	    }
	    driver.context("WEBVIEW_com.androidsample.generalstore");
	    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello");
	    driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        
        driver.context("NATIVE_APP");
	}
	
	public static double getAmount(String v)
	{
		v = v.substring(1);
		double amount = Double.parseDouble(v);
		return amount;
	}

}
