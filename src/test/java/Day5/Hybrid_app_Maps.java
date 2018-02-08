package Day5;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hybrid_app_Maps {

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
		capabilities.setCapability("appPackage","com.emn8.mobilem8.nativeapp.bk");
		capabilities.setCapability("appActivity","com.emn8.mobilem8.nativeapp.bk.BKNativeMobileApp");
		
		//Appium Server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(4000);
		
		Set<String> contextHandles = driver.getContextHandles();
		int size = contextHandles.size();
		System.out.println(size);
		
		Map<String,String> dMap= new HashMap<String,String>();
		
		for(String contextname:contextHandles)
		{
			if(contextname.contains("NATIVE"))
			{
				dMap.put("native", contextname);
			}
			else if(contextname.contains("WEBVIEW"))
			{
				dMap.put("webview", contextname);
			}
				
		}
				
		
		//****************************************************
		//first page
		
		
		System.out.println("First Page");
		System.out.println("-------------");
		driver.context(dMap.get("native"));
		
		WebDriverWait wait= new WebDriverWait(driver, 50);
		WebElement ele_voucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@index='9'][@content-desc='VOUCHERS'][@class='android.view.View']")));
		
		System.out.println("Voucher is displayed  "+ele_voucher.isDisplayed());
		
		ele_voucher.click();
		
		//**************************************************************
		//Second page
		Thread.sleep(4000);
		System.out.println("Second Page");
		System.out.println("-------------");
		driver.context(dMap.get("native"));
		
		WebDriverWait wait2= new WebDriverWait(driver, 50);
		WebElement ele_redeem = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@index='17'][@content-desc='REDEEM'][@class='android.view.View']")));
		
		System.out.println("Redeem is displayed  "+ele_redeem.isDisplayed());
		
		ele_redeem.click();
		//**************************************************************
		//Third page
		
		Thread.sleep(4000);
		System.out.println("ThirdPage");
		System.out.println("-------------");
		
		driver.context(dMap.get("webview"));
		
		driver.findElementByName("email").sendKeys("nov@gmail.com");
		WebElement ele_pwd = driver.findElementByName("password");
		ele_pwd.click();
		
		Thread.sleep(4000);
		ele_pwd.sendKeys("1234");
		
		//********************************************************
		
		Thread.sleep(4000);
		System.out.println("ThirdPage");
		System.out.println("-------------");
		
		driver.context(dMap.get("native"));
		
		
		WebDriverWait wait3= new WebDriverWait(driver, 50);
		WebElement ele_Signin = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@index='33'][@content-desc='SIGN IN'][@class='android.view.View']")));
		
		System.out.println("Signin is displayed  "+ele_Signin.isDisplayed());
		
		

	}

}
