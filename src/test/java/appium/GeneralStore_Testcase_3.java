package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore_Testcase_3 extends base {
	
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
		
	    driver.findElement(MobileBy.AndroidUIAutomator
	   ("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))"));

	   int count= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

	   for(int i=0;i<count;i++)
	   {
		   String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

	         if(text.equalsIgnoreCase("PG 3"))

	        {

         	     driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
         	     break;

	        }
	        

	    }

	     driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	     Thread.sleep(3000);
	     String checkout_product = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

	     Assert.assertEquals("PG 3", checkout_product);

	          

	          

	          

	     

	     

}

}
