package Day4_session2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReadWrite_practice {
	
	private static final int CELL_TYPE_STRING = 0;
	FileInputStream fis;
	HSSFWorkbook wb;
	
	public ExcelReadWrite_practice(String xlPath) throws IOException
	{
		fis= new FileInputStream(xlPath);
		
		//Workbook Object 
		
		wb =new HSSFWorkbook(fis);
	}
	
	public HSSFSheet Setsheet(String sheetname)
	{
		HSSFSheet sheet = wb.getSheet(sheetname);
		return sheet;
		
		
	}
	public int getrowcount(HSSFSheet Sheet)
	{
		int lastRowNum= Sheet.getLastRowNum();
		return lastRowNum;
		
		
	}
	public int getcolcount(HSSFSheet Sheet,int rwoIndex)
	{
		int lastcolNum= Sheet.getRow(rwoIndex).getLastCellNum();
		return lastcolNum;
		
	}
	
	public String Readvalue(HSSFSheet Sheet,int rowIndex,int Cellnum)
	{
		HSSFCell cell = Sheet.getRow(rowIndex).getCell(Cellnum);
		String celltext = null;
		if(cell==null)
		celltext="";
		else if (cell.getCellType()==cell.CELL_TYPE_STRING)
			celltext=cell.getStringCellValue();
		
		else if (cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			celltext=String.valueOf(cell.getNumericCellValue());
		
		else if (cell.getCellType()==cell.CELL_TYPE_BLANK)
			celltext="";
		
		return celltext;
			
		}
	public String Readvalue(HSSFSheet Sheet,int rowIndex, String colname)
	{
		
		int colindex = 0;
		for(int i=0;i<getcolcount(Sheet,0);i++){
			
			
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
				colindex=i;
		}
		return Readvalue(Sheet,rowIndex, colindex);
	}
	
	public void writecell(HSSFSheet Sheet,int rowIndex,int cellnum, String wvalue )
	{
		//writing the cell
		HSSFCell writecell = Sheet.getRow(rowIndex).getCell(cellnum);
		if(writecell==null)
		{
			writecell=Sheet.getRow(rowIndex).createCell(cellnum);
		}
		
		writecell.setCellValue(wvalue);
	}
	
	public void writecell(HSSFSheet Sheet,int rowIndex,String colname, String wvalue ){
		int colindex = 0;
		for(int i=0;i<getcolcount(Sheet,0);i++){
			
			
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(Sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colname))
				colindex=i;
		}
		

		writecell(Sheet,rowIndex,colindex, wvalue );
		
		
	}
	public void save_excel(String xlPath) throws IOException
	{
		fis.close();
		
		FileOutputStream fos= new FileOutputStream(xlPath);		
		wb.write(fos);
		fos.close();
		
	}
	
}

