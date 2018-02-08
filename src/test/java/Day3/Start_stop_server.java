package Day3;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Start_stop_server {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Start server
		
		String Start_server="D:\\Appium\\node.exe D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		Process process = Runtime.getRuntime().exec(Start_server);
		
		if(process != null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT started the Server");
		}
		
		Thread.sleep(12000);
		
		//***************************************************************************
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");		
		
		//app details
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		
		//Appium Server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(4000);
		
		//Click on Basic usage
		driver.findElementById("com.mobeta.android.demodslv:id/activity_title").click();
		Thread.sleep(4000);
		//***************************************************************
		
		//Stop server
		
		if(process !=null)
		{
			process.destroy();
			Thread.sleep(4000);
			
			System.out.println("Stopped the Appium server");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
	}

}
