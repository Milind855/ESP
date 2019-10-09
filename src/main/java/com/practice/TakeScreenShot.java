package com.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


public class TakeScreenShot 
{
	static WebDriver driver;
   public  static void takescreenshot(WebDriver driver,String dstfile) throws IOException
   {
	TakesScreenshot scn=((TakesScreenshot)driver);
	File src=scn.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(dstfile));
   }

   
   public static void test(ITestResult rest) throws IOException
   {
	   if(ITestResult.FAILURE==rest.getStatus())
	   {
		   TakeScreenShot.takescreenshot(driver, "D:\\\\Learning\\\\SeleniumscreenshotExp\\\\TakeScreenShot.jpg");
	   }
   }
   
}
