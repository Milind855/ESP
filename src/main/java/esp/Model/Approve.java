package esp.Model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Approve 
{
	static WebElement element;
	public static WebElement Tab3Select(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//li[text()='Approve Jobs']"));
		return element;
	}
   
	public static void SelectState(WebDriver driver)
	{
		new Select(driver.findElement(By.id("selectState"))).selectByVisibleText("SCHEDULED");
	}
	public static void getApproveJobs(WebDriver driver)
	{
		driver.findElement(By.id("getApproveJobs")).click();
		 
		// return element;
	}
	
	public static WebElement SearchMyJob(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@type='search' and @aria-controls='tableInTab25']"));
		return element;
	}
	
	public static WebElement MyJobCheckBox(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//table[@id='tableInTab25']/tbody/tr/td/input[@type='checkbox']"));
		return element;
	}
	
	public static void SelectJObState(WebDriver driver)
	{
		new Select(driver.findElement(By.id("selectapproval"))).selectByVisibleText("Approve");
	}
	
	public static WebElement SubmitAprroval(WebDriver driver)
	{
		element=driver.findElement(By.id("tabsubmit"));
		
		 return element;
	}
	
}
