package com.POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_HomePageTesting
{

	FirefoxDriver driver ;
	
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void HomePage() throws IOException
	{
		WelcomeMercuryTours WMT = PageFactory.initElements(driver, WelcomeMercuryTours.class);
		
		WMT.SignOn();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		
		driver.navigate().back();
		
WMT.Register();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		
		driver.navigate().back();
		
WMT.Support();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		
		driver.navigate().back();
		
WMT.Contact();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		
		driver.navigate().back();
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestDataFiles\\NewTours_LogInTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row r=sheet.getRow(i);
		
		
WMT.LogIn(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());

	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	System.out.println();
	
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
	
	FileOutputStream file1 = new FileOutputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestResultFiles\\NewToursLogInResultFile_POM.xlsx");
	workBook.write(file1);

	driver.navigate().back();
	
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
