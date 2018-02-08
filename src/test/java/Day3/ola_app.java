package Day3;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ola_app {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		

		//Launch app
				//class              ref_var    = Object
				DesiredCapabilities capabilities= new DesiredCapabilities();
						
				//device details
				capabilities.setCapability("deviceName","GT-I9300I");
				capabilities.setCapability("platformName","Android");
				capabilities.setCapability("platformVersion","4.4.4");		
				
				//app details
				capabilities.setCapability("appPackage","com.olacabs.customer");
				capabilities.setCapability("appActivity","com.olacabs.customer.ui.SplashActivity");
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				Thread.sleep(22000);
				
				//android it does not work
//				Alert alert = driver.switchTo().alert();
//				alert.accept();
				
				driver.findElementById("android:id/button1").click();
				

				//driver.findElementByXPath("//*[@index='0'][@text='Mini'][@resource-id='com.olacabs.customer:id/item_name']").click();
				
				List<WebElement> ele_imgcont = driver.findElementsById("com.olacabs.customer:id/item_icon");
				ele_imgcont.get(2).click();
//				
//				
//				
//				Thread.sleep(6000);
//				
//				driver.findElementById("com.olacabs.customer:id/button_ride_now").click();
//				Thread.sleep(8000);
//				
//				String Actual_Result = driver.findElementById("com.olacabs.customer:id/button_ride_confirm").getText();
//				System.out.println(Actual_Result);
//				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}

}
