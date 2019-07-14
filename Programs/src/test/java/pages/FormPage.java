package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import excelUtils.ReadExcelFile;

public class FormPage {
	
	public WebDriver driver;
		
	//Single Input
	
	//public String textBox = "//input[@id='user-message']";
	
	ReadExcelFile xlFile = new ReadExcelFile();
		
	By textBox = By.xpath("//input[@id='user-message']");
	
	//public String submit = "//button[contains(text(),'Show Message')]";
	
	By submit = By.xpath("//button[contains(text(),'Show Message')]");
		
	//Multiple Input
	
	//public String valueA="//input[@id='sum1']";
	
	By valueA=By.xpath("//input[@id='sum1']");
	
	//public String valueB="//input[@id='sum2']";
	
	By valueB=By.xpath("//input[@id='sum2']");
	
	//public String submitTotal="//button[contains(text(),'Get Total')]";
	
	By submitTotal=By.xpath("//button[contains(text(),'Get Total')]");
	
	public FormPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setTextMessage(String textInfo)
	{
//		driver.findElement(textBox).sendKeys("Hello Srikanth");
		
		driver.findElement(textBox).sendKeys(textInfo);
	}
	
	public void clickSubmit()
	{
		driver.findElement(submit).click();
	}
	
	public void valOne(String val1)
	{
		driver.findElement(valueA).sendKeys(val1);
	}
	
	public void valTwo(String val2)
	{
		driver.findElement(valueB).sendKeys(val2);
	}
	
	public void clickGetTotal()
	{
		driver.findElement(submitTotal).click();
	}
	
	public void displayTextEntered(String textMsg)
	{
		this.setTextMessage(textMsg);
		
		this.clickSubmit();		
	}
	
	public void addTheNumbers(String a, String b)
	{
		this.valOne(a);
		
		this.valTwo(b);
		
		this.clickGetTotal();
	}
	
}
