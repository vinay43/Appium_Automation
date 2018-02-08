package Day4_session3;

public class template_mort extends Base_Class {
	
	
	
	public String EMICalc(String Amount,String Tenure, String Interest ) throws InterruptedException
	{
		
		driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys(Amount);
		driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys(Tenure);
		driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys(Interest);
		
		Thread.sleep(2000);
		
		driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
		
		Thread.sleep(4000);
		
		String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
		//System.out.println("Output is "+Output);
		
		String Actual_Result = Output.replace("$", "");				
		//System.out.println("Actual Result is "+Actual_Result);
		
		return Actual_Result;
		
		
		
	}

}
