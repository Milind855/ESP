package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XLsheet
{     public static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
        System.setProperty("webdriver.chrome.driver","D:\\\\checkout\\\\New folder\\\\selnium\\\\chromedriver.exe");                           
        driver= new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        
        File src= new File("C:\\Users\\milind.kulkarni\\eclipse-workspace\\EspProject\\src\\main\\java\\milind.xlsx");
        FileInputStream frc= new FileInputStream(src);
       // System.out.println("mohan");
        XSSFWorkbook wb= new XSSFWorkbook(frc);
        XSSFSheet sheet= wb.getSheetAt(0);
        int size  =sheet.getLastRowNum();
        //System.out.println("yadav");
//        for(int i=0; i<=size; i++) {
        	      String username= sheet.getRow(0).getCell(0).getStringCellValue();
        	      double password= sheet.getRow(0).getCell(1).getNumericCellValue();
        	      String pass=password+"";
        	      driver.findElement(By.id("email")).sendKeys(username);
        	      driver.findElement(By.id("pass")).sendKeys(pass);
        	      driver.findElement(By.id("u_0_3")).click();
        //}
		
        driver.quit();
	}

}
