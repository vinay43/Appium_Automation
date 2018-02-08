package Day5_session3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base_Class {
	public AppiumDriver driver;
	
	@BeforeTest
	@Parameters({"deviceID"})
	public void LaunchApp(String deviceID) throws InterruptedException, MalformedURLException
	{
		//Launch app
		//class              ref_var    = Object
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//app details
		capabilities.setCapability("appPackage","com.boondoggle.mortcalc");
		capabilities.setCapability("appActivity","com.boondoggle.mortcalc.MortCalc");
				
		if(deviceID.equals("d1"))
		{
		System.out.println("Executing in Device1");
		
		capabilities.setCapability("deviceName","f3eba6c");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.2");	
	//	capabilities.setCapability("fullreset", true);
		}
		
		else if(deviceID.equals("d2"))
		{
			System.out.println("Executing in Device2");
			
			capabilities.setCapability("deviceName","ZX1B34CH5K");
			capabilities.setCapability("platformName","Android");
			capabilities.setCapability("platformVersion","5.1");	
		//	capabilities.setCapability("fullreset", true);
			
		}
		
		//Appium Server details
		driver= new AndroidDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(4000);
	}
	

}
