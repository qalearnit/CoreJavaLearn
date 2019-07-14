package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelFile {
	
	public String[][] getFormData(String xlFileName, String sheetName) throws IOException
	{
		String[][] str = null;
		
			try
			{
			FileInputStream fs = new FileInputStream(xlFileName);
			XSSFWorkbook wb =new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);
			
			int rowCount=sh.getPhysicalNumberOfRows();
			//int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
			System.out.println("No. of rows is "+rowCount);			
			
			XSSFRow firstRow = sh.getRow(1);
			int colCount=firstRow.getPhysicalNumberOfCells();			
			System.out.println("No. of rows is "+colCount);	
//			XSSFRow row = sh.getRow(i+1);
			
			
			str = new String[rowCount-1][colCount];
			
			for (int i=1;i<rowCount;i++) 
			{
				XSSFRow row = sh.getRow(i);		
		        //Create a loop to print cell values in a row
		        for (int j=0;j<colCount;j++) 
		        {
		            //Print excel data in console
		        	str[i-1][j] = row.getCell(j).toString();		        	  	
		        }
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return str;	    
			
	}
	
@DataProvider(name="testData")
	
	public Object[][] textData() throws IOException
	{
		Object[][] arrayData = null; 
		ReadExcelFile xlRead = new ReadExcelFile();
		arrayData = xlRead.getFormData("C:\\Users\\Srikanth\\git\\Programs\\CoreJavaLearn\\Programs\\src\\test\\java\\excelFiles\\TestData.xlsx","TextDisplay");
		return arrayData;	
	}
	
}
