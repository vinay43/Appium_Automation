package Day1;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SMS_send {

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
				capabilities.setCapability("appPackage","com.android.mms");
				capabilities.setCapability("appActivity","com.android.mms.ui.ConversationComposer");
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				Thread.sleep(4000);
				String Exp_Result="9591569181";
				System.out.println("Expected Result is "+Exp_Result);
				
				
				driver.findElementByName("Compose Button").click();
				Thread.sleep(3000);
				
				driver.findElementById("com.android.mms:id/recipients_editor_to").sendKeys(Exp_Result);
				driver.findElementById("com.android.mms:id/edit_text_bottom").sendKeys("Hi Nov batch");
				driver.findElementById("com.android.mms:id/send_button").click();
				
				Thread.sleep(3000);
				
				driver.findElementById("android:id/up").click();
				Thread.sleep(3000);
				
				String Actual_Result = driver.findElementById("com.android.mms:id/from").getText();
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
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
