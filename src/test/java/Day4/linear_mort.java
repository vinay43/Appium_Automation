package Day4;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class linear_mort {

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
				
		
		
		
		//Launch app
				//class              ref_var    = Object
				DesiredCapabilities capabilities= new DesiredCapabilities();
						
				//device details
				capabilities.setCapability("deviceName","GT-I9300I");
				capabilities.setCapability("platformName","Android");
				capabilities.setCapability("platformVersion","4.4.4");		
				
				//app details
				capabilities.setCapability("appPackage","com.boondoggle.mortcalc");
				capabilities.setCapability("appActivity","com.boondoggle.mortcalc.MortCalc");
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				Thread.sleep(4000);
				
				String Exp_Result="222.44";
				
				
				driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("10000");
				driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
				driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("12");
				
				Thread.sleep(2000);
				
				driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
				
				Thread.sleep(4000);
				
				String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
				System.out.println("Output is "+Output);
				
				String Actual_Result = Output.replace("$", "");				
				System.out.println("Actual Result is "+Actual_Result);
				
				if(Actual_Result.equals(Exp_Result))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
								
				
				
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
