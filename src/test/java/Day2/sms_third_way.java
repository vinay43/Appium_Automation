package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class sms_third_way {

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
				
				
//				driver.findElementByName("Compose Button").click();
//				Thread.sleep(3000);
//				
//				driver.findElementById("com.android.mms:id/recipients_editor_to").sendKeys(Exp_Result);
//				driver.findElementById("com.android.mms:id/edit_text_bottom").sendKeys("Hi Nov batch");
//				driver.findElementById("com.android.mms:id/send_button").click();
//				
//				Thread.sleep(3000);
//				
//				driver.findElementById("android:id/up").click();
//				Thread.sleep(3000);
				
				 List<WebElement> ele_msgcont = driver.findElementsById("com.android.mms:id/from");
				 int size = ele_msgcont.size();
				 System.out.println(size);
				 
				 int flag=0;//mismatch
				 for(int i=0;i<size;i++)
				 {
					 //System.out.println(ele_msgcont.get(i).getText());
					 
					 if((ele_msgcont.get(i).getText()).equals(Exp_Result))
					 {
						 flag=1;//matching
						 break;
					 }
					 else
					 {
						 flag=0;//mismatching
					 }
					 
				 }
				 
				 
				 if(flag==1)
				 {
					 System.out.println("Pass");
				 }
				 else
				 {
					 System.out.println("Fail");
				 }
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				
				 
				 
				 

	}

}
