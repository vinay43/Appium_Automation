package Day5_session3;

import org.testng.annotations.Test;

public class driver_mortgage extends Base_Class {
	
	@Test
	public void EMICalc() throws InterruptedException
	{
		String Exp_Result="222.44";
		System.out.println("Expected Result is "+Exp_Result);
		
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
	}

}
