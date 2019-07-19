package textNg_Concepts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import allUtils.BaseClass;

public class seEasyTests extends BaseClass{
	//groups='alerts & windows'	
	
  @Test(groups={"alerts & windows"})
  public void popUpWindowSingle() {
	  
	  eLog = report.startTest("Alerts & Modals Single Window");
	  
	  driver.get("https://www.seleniumeasy.com/test/");
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Alerts & Modals')]")).click();
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Window Popup Modal')]")).click();
	  
	  driver.findElement(By.xpath("//a[contains(text(),'  Follow On Twitter ')]")).click();
	  
	  String main = driver.getWindowHandle();
	  
	  Set<String> allWindows = driver.getWindowHandles();
	  Iterator<String> itr = allWindows.iterator();
	  
	  while(itr.hasNext())
	  {
		  String child = itr.next();
		  
		  if(!main.equalsIgnoreCase(child)) 
		  {
			  driver.switchTo().window(child);
			  driver.close();
		  }		  
	  }
	  
	  driver.switchTo().window(main);
	  
  }
  
  
  @Test(groups={"alerts & windows"})
  public void popUpWindowMultiple() {
	  eLog = report.startTest("Alerts & Modals Multiple Windows");
	  
	  driver.get("https://www.seleniumeasy.com/test/");
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Alerts & Modals')]")).click();
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Window Popup Modal')]")).click();
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]")).click();
	  
	  String main = driver.getWindowHandle();
	  
	  Set<String> allWindows = driver.getWindowHandles();
	  Iterator<String> itr = allWindows.iterator();
	  
	  while(itr.hasNext())
	  {
		  String child = itr.next();
		  
		  if(!main.equalsIgnoreCase(child)) 
		  {
			  driver.switchTo().window(child);
			  driver.close();
		  }		  
	  }
	  
	  driver.switchTo().window(main);
	  
  }
}
