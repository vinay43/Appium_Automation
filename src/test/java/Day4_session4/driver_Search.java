package Day4_session4;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class driver_Search {

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
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				//wait
				Thread.sleep(4000);
				
				
				driver.get("http://google.co.in");
				
				driver.findElementByName("q").sendKeys("Sachin");
				driver.findElementById("tsbb").click();
				
				Thread.sleep(15000);
				
				
				String Actual_Result = driver.findElementByXPath("//span[contains(text(),'cricketer')]").getText();
				System.out.println("Actual Result "+Actual_Result);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

	}

}
