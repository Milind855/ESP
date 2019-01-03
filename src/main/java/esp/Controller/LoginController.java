package esp.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.bcel.verifier.exc.Utility;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.esp.Selenium.EspProject.App;
import com.practice.TakeScreenShot;

import esp.Model.Approve;
import esp.Model.CampaignStatus;
import esp.Model.Login;
import esp.Model.Schedule;

public class LoginController 
{
	static Date date =new Date();
	static int d=date.getDate();
	static WebDriver driver;
	static String SMSJObName="Hello"+Math.random();
	static Properties prop;
	
	
	public static void LoadProperties() throws FileNotFoundException, IOException 
	{
	    prop=new Properties();
		prop.load(new FileInputStream("C:\\Users\\milind.kulkarni\\eclipse-workspace\\EspProject\\src\\main\\java\\Config.properties"));
		
	}
	@BeforeSuite
	public static WebDriver BeforeTestRun() throws FileNotFoundException, IOException
	{
		LoginController.LoadProperties();
		String name=prop.getProperty("user");
		System.out.println(name);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("webdriver.chrome.driver"));
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		TakeScreenShot.takescreenshot(driver, prop.getProperty("Snapshotpath"));
		
		return driver;
	}
	
	@AfterMethod
	 public static void test(ITestResult rest) throws IOException
	   {
		   if(ITestResult.FAILURE==rest.getStatus())
		   {
			   TakeScreenShot.takescreenshot(driver, "D:\\\\Learning\\\\SeleniumscreenshotExp\\\\TakeScreenShot.jpg");
		   }
	   }

	
	
	
	@DataProvider
	public static Iterator<Object[]> getTestData() throws IOException{
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
	{  
		
	        File src= new File(prop.getProperty("Xlfile"));
	        FileInputStream frc= new FileInputStream(src);
	       // System.out.println("mohan");
	        XSSFWorkbook wb= new XSSFWorkbook(frc);
	        XSSFSheet sheet= wb.getSheetAt(0);
	        int size  =sheet.getLastRowNum();
	        //System.out.println("yadav");
	        for(int i=0; i<=size; i++)
	        {
				String username=sheet.getRow(i).getCell(0).getStringCellValue();
				String password=sheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println(username);
				System.out.println(password);
				Object ob[] = {username,password};
				myData.add(ob);
			}
			
			return myData.iterator();
		//return null;
		
	}
	}

	
	@Test(dataProvider="getTestData")
	public static void TestLogin(String username, String password) throws InterruptedException
	{
		Login.UserId(driver).sendKeys(username);
		Login.UserPass(driver).sendKeys(password);
		Login.LoginButton(driver).click();
		Thread.sleep(1000);
		
	}
	@Test(dependsOnMethods= {"TestLogin"})
	public static void TestSchedule() throws InterruptedException
	{
		//System.out.println("Schedule A JOb");
		//WebDriver driver=LoginController.BeforeTestRun();
		Schedule.Tab2Select(driver).click();
		Thread.sleep(1000);
		Schedule.DropdownSelect(driver).click();
		Thread.sleep(1000);
		Schedule.Selectoption2(driver).click();
		Thread.sleep(2000);
		Schedule.FileUpload(driver);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		Schedule.SleectChannel(driver);
		Thread.sleep(2000);
		Schedule.SleectApprover(driver);
		Thread.sleep(2000);
		Schedule.SleectTimeZone(driver);
		Thread.sleep(2000);
		
		Schedule.JObName(driver).sendKeys(SMSJObName);
		Thread.sleep(2000);
		Schedule.SMSText(driver).sendKeys(prop.getProperty("SMStext"));
		Thread.sleep(2000);
		Schedule.JObSenderNumber(driver).sendKeys(prop.getProperty("SMSSender"));
		Thread.sleep(2000);
		Schedule.JobPriority(driver,prop.getProperty("JobPriority"));
		Thread.sleep(2000);
		Schedule.StartDate(driver,d);
		Thread.sleep(2000);
		Schedule.EndDate(driver,d);
		Thread.sleep(2000);
		Schedule.DNDCheckSelector(driver, prop.getProperty("DNDCheck"));
		Thread.sleep(2000);
		Schedule.DNCTOCheckSelector(driver,"");
		Thread.sleep(2000);
		
		Schedule.SubmitJob(driver).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
     
	
	}
	
	@Test(dependsOnMethods= {"TestLogin","TestSchedule"})
	public static void ApproveJOb() throws InterruptedException
	{
		Thread.sleep(2000);
		Approve.Tab3Select(driver).click();
		Thread.sleep(2000);
		Approve.SelectState(driver);
		Thread.sleep(2000);
		Approve.getApproveJobs(driver);
		Thread.sleep(2000);
		Approve.SearchMyJob(driver).sendKeys(SMSJObName);
		Thread.sleep(2000);
		Approve.MyJobCheckBox(driver).click();
		Thread.sleep(2000);
		Approve.SelectJObState(driver);
		Thread.sleep(2000);
		Approve.SubmitAprroval(driver).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		//driver.close();
	}
	
	
	@Test(dependsOnMethods= {"TestLogin","TestSchedule","ApproveJOb"})
	public static void JobStatus() throws InterruptedException
	{
		Thread.sleep(2000);
		CampaignStatus.Tab4Select(driver).click();
		Thread.sleep(2000);
		CampaignStatus.SleectChannel(driver);
		Thread.sleep(2000);
		CampaignStatus.SubmitJob(driver).click();
		Thread.sleep(2000);
		driver.close();
		
	}
	
	
	
	
	
	
	

		}
