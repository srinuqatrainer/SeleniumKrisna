package com.Hybrid;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_LogInTest
{

ChromeDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		 //driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverFiles\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	

	@Test
	public void logIn() throws IOException
	{
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\newTours.properties");
		Properties pr = new Properties();
		pr.load(file);

		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestDataFiles\\NewTours_LogInTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file1);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			Row r=sheet.getRow(i);
			
		//driver.findElement(By.name("userName")).sendKeys("tutorial");
			driver.findElement(By.name(pr.getProperty("UserName"))).clear();
		driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys(r.getCell(0).getStringCellValue());
		
		driver.findElement(By.name(pr.getProperty("Password"))).clear();
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys(r.getCell(1).getStringCellValue());
		
		driver.findElement(By.name(pr.getProperty("SignIn"))).click();
		
		String expected_Title="Find";
		System.out.println(" Expected Title is: "+expected_Title);
		
		String actual_Title=driver.getTitle();
		System.out.println(" Actual Title is: "+ actual_Title);
		
		if(actual_Title.contains(expected_Title))
		{
			System.out.println(" LogIn Successfull - PASS ");
			r.createCell(2).setCellValue("LogIn Successfull - PASS ");
			
		}
		else
		{
			System.out.println(" LogIn Failed -- FAIL");
			r.createCell(2).setCellValue("LogIn Failed -- FAIL");
		}
		
		FileOutputStream file2 = new FileOutputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestResultFiles\\NewTours_LogInTestResult_Hybrid.xlsx");
		workBook.write(file2);
		
		driver.navigate().back();
		
		//driver.navigate().refresh();
	}	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

	
	
}
