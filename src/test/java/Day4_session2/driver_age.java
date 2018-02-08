package Day4_session2;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class driver_age {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\AndroidAppiumAutomation\\MobileTestingWorld\\Day4\\Age.xls");
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		
		
		for(int i=1;i<=RowCount;i++)
		{
			
			String Age = xl.Readvalue(Sheet1, i, "Age");
			
			double Age_final=Double.parseDouble(Age);
			
			if(Age_final>=18)
			{
				xl.writecell(Sheet1, i, "Status", "Major");
			}
			else
			{
				xl.writecell(Sheet1, i, "Status", "Minor");
			}
			
			
			
		}
		
		
		xl.save_excel("D:\\AndroidAppiumAutomation\\MobileTestingWorld\\Day4\\Age.xls");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
