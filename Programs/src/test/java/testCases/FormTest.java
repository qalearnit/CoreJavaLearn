package testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import allUtils.BaseClass;
import config.ConfigData;
import excelUtils.ReadExcelFile;
import pages.FormPage;

public class FormTest extends BaseClass
{
	FormPage fp;
	
	BaseClass base = new BaseClass();
	
	@BeforeClass
	public void startClass1()
	{
		eLog = report.startTest("SingleEntry");		
	}
	
	@Test(dataProvider="testData")
	public void formSingleEntry(String text) throws InterruptedException
	{
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
				
		fp = new FormPage(driver);
				
		fp.displayTextEntered(text);

		Thread.sleep(1500);		
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
