package Day3;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart_app {

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
				capabilities.setCapability("appPackage","com.flipkart.android");
				capabilities.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
				
				//Appium Server details
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait-- Explicit wait
				
				WebDriverWait wait= new WebDriverWait(driver, 30);
				WebElement ele_Searchtxtbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox")));
				
				System.out.println("Search txtbox is displayed  "+ele_Searchtxtbox.isDisplayed());
				ele_Searchtxtbox.click();
				
				Thread.sleep(3000);
				driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").sendKeys("Reebok shoes" +"\n");
				
				Thread.sleep(12000);
				
				Dimension size = driver.manage().window().getSize();
				System.out.println(size);
				
				int Starty=(int)(size.height *0.90);
				int Endy=(int)(size.height *0.10);
				
				int Startx=(int)(size.width *0.50);
					
				WebElement ele_item = driver.findElementByClassName("android.widget.TextView");
				
				int count=0;
				do
				{
					
					List<WebElement> ele_item2 = driver.findElementsByXPath("//*[@index='2'][@text='Reebok DUO Running Shoes'][@class='android.widget.TextView']");
					int size2 = ele_item2.size();
					System.out.println(size2);
										
					
					if(size2>0)
					{
						count++;
						System.out.println("Count is "+count);
						if(count==2)
						{
							System.out.println("Duo ruming shoes found");
							driver.findElementByXPath("//*[@index='2'][@text='Reebok DUO Running Shoes'][@class='android.widget.TextView']").click();
							break;
						}
						
					}
					
					
					//Vertical swipe
					driver.swipe(Startx, Starty, Startx, Endy, 1000);
					Thread.sleep(2000);
					
				}while((ele_item.isDisplayed())==true);
				
				WebDriverWait wait2= new WebDriverWait(driver, 30);
				WebElement ele_Buy = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/product_buynow_1")));
		
				System.out.println("Buy now is displayed "+ele_Buy.isDisplayed());
				ele_Buy.click();
				
				Thread.sleep(5000);
				
				driver.findElementByXPath("//*[@index='0'][@text='7'][@class='android.widget.TextView']").click();
				Thread.sleep(2000);
				driver.findElementById("com.flipkart.android:id/continue_variant").click();
				
				Thread.sleep(15000);
				String Actual_Result = driver.findElementById("com.flipkart.android:id/title_action_bar").getText();
				System.out.println(Actual_Result);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
