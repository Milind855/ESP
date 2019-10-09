package esp.Model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class Schedule 
{
	static boolean DNDEnable=false;
//	static boolean DNCTOEnable=false;
	static WebElement element;
	
	static String filepath="C:\\Users\\milind.kulkarni\\Desktop\\Base-File-Test\\milind_91.txt";
	
	public static WebElement Tab2Select(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//li[text()='Schedule Jobs']"));
		return element;
		
	}
	
	public static WebElement DropdownSelect(WebDriver driver)
	{
		element=driver.findElement(By.id("scheduleType"));
		return element;
//		Select select = new Select(driver.findElement(By.id("scheduleType")));
//		select.selectByVisibleText("Schedule Job");
		
	}
	public static WebElement Selectoption2(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//option[text()='Base File Upload']"));
		return element;
		
	}
	public static void FileUpload(WebDriver driver) throws InterruptedException
	{

		 WebElement choosefile=driver.findElement(By.id("BaseFile"));
		 choosefile.sendKeys(filepath);
		 
		 Thread.sleep(1000);
		 driver.findElement(By.id("bfUpload")).click();
		 Thread.sleep(2000); 
		 driver.switchTo().alert().accept();
		 Thread.sleep(2000);
		 
		 driver.switchTo().alert().accept();
	}
	
	public static void SleectChannel(WebDriver driver)
	{
		new Select(driver.findElement(By.id("IBMP_MESSAGE_TYPE"))).selectByVisibleText("SMS");
		
	}
	
	public static void SleectApprover(WebDriver driver)
	{
		new Select(driver.findElement(By.id("selectApprover"))).selectByVisibleText("milind.kulkarni@onmobile.com");
	}
	
	public static void SleectTimeZone(WebDriver driver)
	{
		new Select(driver.findElement(By.id("selectTimezone"))).selectByVisibleText("Indian/Mauritius");
	}
	
	//JOb Details
	public static WebElement JObName(WebDriver driver)
	{
		element=driver.findElement(By.id("IBMP_CAMPAIGN_NAME"));
		return element;
	}
	
	public static WebElement SMSText(WebDriver driver)
	{
		element=driver.findElement(By.id("IBMP_SMS_CONTENT"));
		return element;
	}
	
	public static WebElement JObSenderNumber(WebDriver driver)
	{
		element=driver.findElement(By.id("IBMP_senderNo"));
		return element;
	}
	
	public static void JobPriority(WebDriver driver,String number)
	{
		new Select(driver.findElement(By.id("IBMP_priority"))).selectByVisibleText(number);
	}
	
	public static void StartDate(WebDriver driver,int date) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='IBMP_START_DATE']")).click();
		Thread.sleep(1000);
		
		String Date=date+1+"";
		//String StartDate=Date+"";
		boolean staleElement = true; 
		int count=0;
		while(staleElement){
		  try{
				List<WebElement> allDates=driver.findElements(By.xpath("//div[@class='datepicker_calendar']/table/tbody/tr/td"));
				
				int total_date=allDates.size();
				for (int i=0; i<total_date; i++){
					
					String s=allDates.get(i).getText();
					
				    if(s.equalsIgnoreCase("1"))
				    {  
				    	for (int j=i; j<total_date; j++)
				    	{
				    	String s1=allDates.get(j).getText();
						if(s1.equalsIgnoreCase(Date))
							{
							allDates.get(j).click();
							break;
							}
				    	}
				    	break;
				    }
				    else
				    {
				    	continue;
				    }
					
				}
		     staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}		
	}
	
	
	public static void EndDate(WebDriver driver,int date) throws InterruptedException
	{
		driver.findElement(By.id("IBMP_EXPIRY_DATE1")).click();
		Thread.sleep(2000);
		int count=0;
		String Date=date+2+"";
		//String StartDate=Date+"";
		boolean staleElement = true; 
		while(staleElement){
		  try{
				List<WebElement> allDates=driver.findElements(By.xpath("//div[@class='datepicker_calendar']/table/tbody/tr/td"));
				
				int total_date=allDates.size();
				for (int i=0; i<total_date; i++){
					
					String s=allDates.get(i).getText();
					
				    if(s.equalsIgnoreCase("1"))
				    {  
				    	for (int j=i; j<total_date; j++)
				    	{
				    	String s1=allDates.get(j).getText();
						if(s1.equalsIgnoreCase(Date))
							{
							allDates.get(j).click();
							break;
							}
				    	}
				    	break;
				    }
				    else
				    {
				    	continue;
				    }
					
				}
		     staleElement = false;
		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}		
	}
	
	public static void  DNCTOCheckSelector(WebDriver driver,String DNCTOEnable)
	{
		if(DNCTOEnable.equalsIgnoreCase("true"))
		{
		driver.findElement(By.id("IBMP_DNCTO")).click();
		}
		else
		{
		 driver.findElement(By.id("IBMP_DNCTO"));
		}
		
	}
	public static void  DNDCheckSelector(WebDriver driver,String DNDEnable)
	{
		if(DNDEnable.equalsIgnoreCase("true"))
		{
		driver.findElement(By.id("IBMP_DND")).click();
		}
		else
		{
		 driver.findElement(By.id("IBMP_DND"));
		}
		
	}
	public static WebElement SubmitJob(WebDriver driver)
	{
		element=driver.findElement(By.id("submitJob"));
		return element;
	}

}
