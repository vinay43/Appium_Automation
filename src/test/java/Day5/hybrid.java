package Day5;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.CountryRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class hybrid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZY222ZV2L6");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0");

		// app details
		capabilities.setCapability("appPackage", "com.myntra.android");
		capabilities.setCapability("appActivity", "com.myntra.android.retention.activities.D7OnBoardingActivity");

		// Appium server details
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

	

		// Native View 
		
		driver.findElementByXPath("//android.widget.TextView[@text='LOG IN']").click();
		driver.findElementByXPath("//android.widget.EditText[@index='0' and @resource-id='com.myntra.android:id/et_email_address']").sendKeys("vinay.sharmaa02@gmail.com");
		driver.findElementByXPath("//android.widget.EditText[@index='0' and @resource-id='com.myntra.android:id/et_loginregister_password']").sendKeys("@@vinay12345");
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@index='0']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.Button").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.view.ViewGroup[@index='5']").click();
		Thread.sleep(5000);
		driver.findElementById("com.myntra.android:id/tv_ok_button").click();

		
		//we are getting the webview in Aadd cart page so unable to locate "Remove" and "Move to Wishlist"
		
		// so here we want to swith in to the webview to locate remove and move to wishlis
		
		
		
		driver.findElementByClassName("confirm-delete-item").click();

	}
}
