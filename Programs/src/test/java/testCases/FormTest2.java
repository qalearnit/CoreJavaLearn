package testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import allUtils.BaseClass;
import excelUtils.ReadExcelFile;
import pages.FormPage;

public class FormTest2 extends BaseClass
{	
	FormPage fp;
	
	BaseClass base = new BaseClass();
	
	public ReadExcelFile xlRead = new ReadExcelFile();
	
	@BeforeClass
	public void startMEClass()
	{
		eLog = report.startTest("MultipleEntry");
	}
	
	@Test(dataProvider="testData")
	public void formMultipleEntry(String val1,String val2) throws InterruptedException, IOException
	{
//		eLog=report.startTest("Login Test -- MultipleEntry");
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		fp = new FormPage(driver);
								
		fp.addTheNumbers(val1,val2);
		
		Thread.sleep(1500);
	}
		
	
	@AfterClass
	public void closeClass1()
	{
		//System.out.println("After class");
		
		//report.endTest(eLog);
		report.flush();
		driver.close();
		//System.out.println("Class completed");
	}
	
	@DataProvider(name="testData")
	public Object[][] textData() throws IOException
	{
		Object[][] arrayData = null; 
		arrayData = xlRead.getFormData("C:\\Users\\Srikanth\\git\\Programs\\CoreJavaLearn\\Programs\\src\\test\\java\\excelFiles\\TestData.xlsx","AddNumbers");;
		
		return arrayData;	
	}
	

}
