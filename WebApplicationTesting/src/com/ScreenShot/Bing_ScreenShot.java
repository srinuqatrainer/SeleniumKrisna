package com.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Bing_ScreenShot {

	public static void main(String[] args) throws IOException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://bing.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Sleeper.sleepTightInSeconds(10);
		
		System.out.println(System.getProperty("user.dir"));;
		
		File capturedScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(capturedScreenShot, new File("C:\\Users\\srinivas1\\Desktop\\KrishnaSelenium\\WebApplicationTesting\\ScreenShots\\bing1.png"));
		
		FileUtils.copyFile(capturedScreenShot, new File(System.getProperty("user.dir")+"\\ScreenShots\\bing2.png"));
		
		driver.quit();

	}

}
