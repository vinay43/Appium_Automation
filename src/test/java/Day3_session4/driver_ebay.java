package Day3_session4;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class driver_ebay {

	public static void main(String[] args) throws IOException, InterruptedException {
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
				capabilities.setCapability("appPackage","com.ebay.mobile");
				capabilities.setCapability("appActivity","com.ebay.mobile.activities.MainActivity");
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				Thread.sleep(12000);
				
				String Exp_Result="67,833";
				System.out.println("Expected Result is "+Exp_Result);
				
				driver.findElementById("com.ebay.mobile:id/search_box").click();
				Thread.sleep(2000);
				driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("Shoes" +"\n");
				
				Thread.sleep(15000);
				
				String Output = driver.findElementById("com.ebay.mobile:id/textview_item_count").getText();
				System.out.println("Output is  "+Output);
				
				String Actual_Result = Output.replace(" results", "");				
				System.out.println("Actual Result is "+Actual_Result);
				Thread.sleep(2000);
				if(Actual_Result.equals(Exp_Result))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				
				Thread.sleep(2000);
				
				//************************************************
				
				//Stop server
				
				if(process !=null)
				{
					process.destroy();
					Thread.sleep(4000);
					
					System.out.println("Stopped the Appium server");
					
				}
				
		
		
		
		
		
		
		

	}

}
