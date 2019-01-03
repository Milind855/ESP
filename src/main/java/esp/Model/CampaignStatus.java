package esp.Model;

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
}
