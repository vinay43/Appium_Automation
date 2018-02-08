package Day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Drag_Drop {

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
		
		//Click on Basic usage
		//driver.findElementById("com.mobeta.android.demodslv:id/activity_title").click();
				
		WebElement ele_Basic = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
		//System.out.println(ele_Basic);
		ele_Basic.click();
		Thread.sleep(3000);		
		
		//Drag and Drop brad
		
		List<WebElement> ele_cont = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
		int size = ele_cont.size();
		System.out.println(size);
		
		TouchAction action= new TouchAction(driver);
		action.longPress(ele_cont.get(0)).moveTo(ele_cont.get(5)).release().perform();
		
		Thread.sleep(8000);	
		
		//Drag and Drop Micheal Brecker
		action.longPress(ele_cont.get(6)).moveTo(ele_cont.get(1)).release().perform();
		Thread.sleep(8000);	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
