package Day6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class Dataprovider_template {
	
	@DataProvider(name="dp_Sum")
	public static Iterator<Object[]> getSummationdata() throws IOException
	{
		
		return commonmethodtofetchdata("Sheet1");		
		
		
	}
	
	
	public static Iterator<Object[]> commonmethodtofetchdata(String sheetname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Sum1.xls");
		
		HSSFSheet Sheet = xl.Setsheet(sheetname);
		
		int RowCount = xl.getrowcount(Sheet);
		int ColCount = xl.getcolcount(Sheet, 0);
		//Create the list of Object Array
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			Object[] x= new Object[1];
			Map<String,String> dMap=new HashMap<String,String>();
			
			for(int j=0;j<ColCount;j++)
			{
				
				String Skey = xl.Readvalue(Sheet, 0, j);
				String Value = xl.Readvalue(Sheet, i, j);
				
				dMap.put(Skey, Value);				
				
			}//inner loop to put it in Maps
			
			x[0]=dMap;
			arr_list.add(x);		
			
			
		}//outer loop for rows
		
		return arr_list.iterator();
		
		
		
		
	}
	
	
	
	
	
	
	

}
