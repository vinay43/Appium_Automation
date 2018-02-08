package Day6;

import java.util.Map;

import org.testng.annotations.Test;

public class driver_Sum {
	
	@Test(dataProvider="dp_Sum", dataProviderClass=Day6.Dataprovider_template.class)
	public void testsummationdata(Map<String,String> calc)
	{
		
   String Num1 = calc.get("Num1");
   String Num2 = calc.get("Num2");
   String Exp_Result = calc.get("Exp_Result");
		
	double Number1=Double.parseDouble(Num1);
	double Number2=Double.parseDouble(Num2);
	
	double Expected_Res=Double.parseDouble(Exp_Result);
		
	double Actual_Result=Number1+Number2;
	
	if(Actual_Result==Expected_Res)
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
	
	
		
		
		
		
		
	}
	
	
	
	

}
