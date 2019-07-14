package allUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import excelUtils.ReadExcelFile;

public class BaseClass 
{

public ExtentReports report;
public ExtentTest eLog;
public WebDriver driver;

public ReadExcelFile xlRead = new ReadExcelFile();

public String reportPath="C:\\Users\\Srikanth\\git\\Programs\\CoreJavaLearn\\Programs\\src\\test\\java\\extentReports\\"; 

public String configFilePath="C:\\Users\\Srikanth\\git\\Programs\\CoreJavaLearn\\Programs\\src\\test\\java\\reportXML\\";

@BeforeSuite
public void startSuite()
{
	report = new ExtentReports(reportPath+"Report"+"_"+timestamp()+".html");
	
	report.loadConfig(new File(configFilePath+"extent-config.xml"));
}

@AfterSuite
public void afterSuite()
{
	System.out.println("After suite");
	//report.endTest(eLog);	
	
	report.flush();
	report.close();
}

@BeforeTest
public void launchBrowser() 
{	  
	  System.setProperty("webdriver.chrome.driver", "P:\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

  @AfterTest
  public void closeBrowser() {
	  System.out.println("this is close test");
	  
	 // driver.close();
  }
  
@BeforeMethod
	public void beforeTestMethod()
	{
		System.out.println("This is the before method");
	}
	
@AfterMethod
	public void afterTestMethod(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
		eLog.log(LogStatus.FAIL, "The test has Failed");
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
		eLog.log(LogStatus.PASS, "The test has Passed");
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
		eLog.log(LogStatus.SKIP, "The test has Skipped");
		}		
//	report.endTest(eLog);		
}

public static String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());						
	}
  
}
