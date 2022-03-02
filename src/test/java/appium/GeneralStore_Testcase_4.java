package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore_Testcase_4 extends base {
	
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
	    		
	          
	}
	
	public static double getAmount(String v)
	{
		v = v.substring(1);
		double amount = Double.parseDouble(v);
		return amount;
	}
	          

}
