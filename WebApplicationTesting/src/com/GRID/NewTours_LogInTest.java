package com.GRID;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTours_LogInTest
{

	@Parameters("Browser")
	@Test
	public void logIn(String browser) throws IOException
	{
		System.out.println("The Browser is : "+browser);
		
		// Nodes
		//DesiredCapabilities - is used to specify which Browser and Platform we would like to consider for the test
		
		DesiredCapabilities cap = null;
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		
	RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.3:4444/wd/hub"),cap);
	driver.get("http://newtours.demoaut.com");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestDataFiles\\NewTours_LogInTestData.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(file);
	XSSFSheet sheet = workBook.getSheet("Sheet1");
	
	int rowCount=sheet.getLastRowNum();
	
	for(int i=1;i<=rowCount;i++)
	{
		Row r=sheet.getRow(i);
		
	// <input type="text" size="10" name="userName">
	driver.findElement(By.name("userName")).sendKeys(r.getCell(0).getStringCellValue());
	
	//<input type="password" size="10" name="password">
	driver.findElementByName("password").sendKeys(r.getCell(1).getStringCellValue());
	
	// <input width="58" type="image" border="0" height="17" alt="Sign-In" 
	// src="/images/btn_signin.gif?osCsid=05af4c1ca0dc7800167d87eb39a43b86" value="Login" name="login">
	
	driver.findElementByName("login").click();
	
	String expected_Title="Find";
	System.out.println(" Expected Title is: "+expected_Title);
	
	String actual_Title=driver.getTitle();
	System.out.println(" Actual Title is: "+ actual_Title);
	
	if(actual_Title.contains(expected_Title))
	{
		System.out.println(" LogIn Successfull - PASS ");
		r.createCell(2).setCellValue("LogIn Successfull - PASS");
	}
	else
	{
		System.out.println(" LogIn Failed -- FAIL");
		r.createCell(2).setCellValue("LogIn Failed -- FAIL");
	}
	
	FileOutputStream file1 = new FileOutputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestResultFiles\\NewToursLogInResultFile.xlsx");
	workBook.write(file1);
	
	driver.navigate().back();
}
	
	driver.quit();
	}
	
	
}
