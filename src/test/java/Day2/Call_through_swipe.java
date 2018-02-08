package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Call_through_swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//class              ref_var    = Object
				DesiredCapabilities capabilities= new DesiredCapabilities();
						
				//device details
				capabilities.setCapability("deviceName","GT-I9300I");
				capabilities.setCapability("platformName","Android");
				capabilities.setCapability("platformVersion","4.4.4");		
				
				//app details
				capabilities.setCapability("appPackage","com.android.contacts");
				capabilities.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				Thread.sleep(4000);
				
				driver.findElementByXPath("//*[@class='android.app.ActionBar$Tab'][@index='3']").click();
				
				Thread.sleep(4000);
				
				Dimension size = driver.manage().window().getSize();
				System.out.println(size);
				
				int Starty=(int)(size.height*0.80);
				int Endy=(int)(size.height*0.20);
				
				int Startx=(int)(size.width*0.50);
				
				WebElement ele_item = driver.findElementByClassName("android.widget.TextView");
				
				
				do
				{
							
					List<WebElement> ele_item2 = driver.findElementsByXPath("//*[@text='Office2'][@index='1']");
					int size2 = ele_item2.size();
					System.out.println(size2);
					
					if(size2>0)
					{
						//horizontal swipe
						System.out.println("Office2 is found");
						
						int Startx1=(int)(size.width*0.10);
						int Endx1=(int)(size.width*0.90);
						
						WebElement ele_item3 = driver.findElementByXPath("//*[@text='Office2'][@index='1']");
						
						int Starty1=ele_item3.getLocation().getY();
						
						driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
						
						break;
					}
				
					//vertical swipe
				driver.swipe(Startx, Starty, Startx, Endy, 1000);
				Thread.sleep(2000);
				
				}while(ele_item.isDisplayed()==true);
				
				Thread.sleep(2000);
				
				String Actual_Result = driver.findElementByXPath("//*[@index='3'][@text='Dialling'][@class='android.widget.TextView']").getText();
				System.out.println("Actual Result is "+Actual_Result);
				Thread.sleep(2000);
				
				if(Actual_Result.equals("Dialling"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

	}

}
