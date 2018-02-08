package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Drag_drop_remmove {

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
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		
		//Appium Server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(4000);
		
		//driver.fexpath("//tagname[@attribute_name='attribute_value']")
		
		driver.findElementByXPath("//*[@text='CursorAdapter'][@class='android.widget.TextView'][@index='0']").click();
		Thread.sleep(3000);
		
		List<WebElement> ele_txtcont = driver.findElementsById("com.mobeta.android.demodslv:id/text");
		int size = ele_txtcont.size();
		System.out.println(size);
		
		
		List<WebElement> ele_remcont = driver.findElementsById("com.mobeta.android.demodslv:id/click_remove");
		int size2 = ele_remcont.size();
		System.out.println(size2);
		
		
		for(int i=0;i<size;i++)
		{
			if((ele_txtcont.get(i).getText()).equals("Michael Brecker"))
			{
				ele_remcont.get(i).click();
				break;
				
			}
			
		}
		
		//************************************************
		
		List<WebElement> ele_txtcont2 = driver.findElementsById("com.mobeta.android.demodslv:id/text");
		int size3 = ele_txtcont2.size();
		System.out.println(size3);
		
		int flag=0; //Micheal breaker is found
		
		for(WebElement element:ele_txtcont2)
		{
			
			if(!(element.getText()).equals("Michael Brecker"))
			{
				flag=1;//Micheal breaker is NOT found
			}
			else
			{
				flag=0;//Micheal breaker is found
				break;
			}
			
		}
		
		
		if(flag==1)
		{
			System.out.println("Pass");
		}
		else if(flag==0)
		{
			System.out.println("Fail");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
