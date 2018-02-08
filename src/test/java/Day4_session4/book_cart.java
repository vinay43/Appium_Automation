package Day4_session4;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class book_cart {

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
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		
		//Appium Server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//wait
		Thread.sleep(4000);
		
		
		driver.get("http://books.rediff.com/");
		Thread.sleep(4000);
		
		driver.findElementById("srchword").sendKeys("Modi");
		driver.findElementByXPath("//input[@type='submit'][@class='srchbtn_n']").click();
		
		Thread.sleep(5000);
		
		List<WebElement> ele_lnkcont = driver.findElementsByTagName("a");
		int size = ele_lnkcont.size();
		System.out.println(size);
		
		//check for the Gamechanger
		for(WebElement element:ele_lnkcont)
		{
			System.out.println(element.getText());
			if((element.getText()).contains("Gamechanger"))
			{
				element.click();
				break;
				
			}			
			
			
		}
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//input[@type='button'][@class='buynowbtn']").click();
		Thread.sleep(10000);
		
		String Actual_Result = driver.findElementByCssSelector("#currentcartdiv > div.cart_prd_row > div.prddetail > span:nth-child(1)").getText();
		System.out.println("Actual Result "+Actual_Result);
		
		if(Actual_Result.contains("Gamechanger"))
		{
				System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
