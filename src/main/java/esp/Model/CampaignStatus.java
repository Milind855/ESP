package esp.Model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CampaignStatus 
{
	static WebElement element;
	public static WebElement Tab4Select(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//li[text()='Campaign Status']"));
		return element;
		
	}
	public static void SleectChannel(WebDriver driver)
	{
		
		new Select(driver.findElement(By.id("Channel"))).selectByVisibleText("SMS");
		//li[text()='Campaign Status']
	}
   
	public static WebElement SubmitJob(WebDriver driver)
	{
		element=driver.findElement(By.id("showJobs"));
		return element;
	}
	
	
	public static WebElement CaptureStatus(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		element=driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1][@role='row' and @class='odd']/td[1]"));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//List<WebElement> status=new 
		
		return element;
	}
	
	
	public static WebElement SerachJob(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//label/input[@type='search'  and @aria-controls='example' ]"));
		return element;
	}
	
	public static void Logout(WebDriver driver)
	{
		
		new Select(driver.findElement(By.id("signOut"))).selectByVisibleText("Logout");
		//li[text()='Campaign Status']
		
		
	}
	
	public static void Selectpass(WebDriver driver)
	{
		
		new Select(driver.findElement(By.xpath("//form/select[@onchange='changeFunction(value);' ]"))).selectByVisibleText("Change Password");
		//li[text()='Campaign Status']
		
		
	}
}
