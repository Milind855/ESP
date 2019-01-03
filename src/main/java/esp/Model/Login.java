package esp.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class Login 
{
	static WebDriver driver;
	static WebElement element;
	Properties pro=new Properties();
	
	public static WebElement UserId(WebDriver driver)
	{
		element=driver.findElement(By.id("username"));
		return element;
	}
	
	public static WebElement UserPass(WebDriver driver)
	{
		element=driver.findElement(By.id("pass"));
		return element;
	}
	
	public static WebElement LoginButton(WebDriver driver)
	{
		element=driver.findElement(By.id("ogin"));
		return element;
	}
	
	
}
