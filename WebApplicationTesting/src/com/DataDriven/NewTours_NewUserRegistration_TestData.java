package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_NewUserRegistration_TestData
{

	
FirefoxDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		 driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test(priority=0)
	public void register()
	{
		driver.findElementByLinkText("REGISTER").click();
	}
	
	@Test(priority=1)
	public void userRegistration() throws IOException
	{
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestDataFiles\\NewUserRegistrationTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++)
		{
			Row r=sheet.getRow(i);
			
		driver.findElementByName("firstName").sendKeys(r.getCell(0).getStringCellValue());
		driver.findElementByName("lastName").sendKeys(r.getCell(1).getStringCellValue());
		
		double d=r.getCell(2).getNumericCellValue();
		long x=(long)d;
		String phoneNumber=Long.toString(x);
		
		driver.findElementByName("phone").sendKeys(phoneNumber);
		driver.findElementById("userName").sendKeys(r.getCell(3).getStringCellValue());
		
		driver.findElementByName("address1").sendKeys(r.getCell(4).getStringCellValue());
		driver.findElementByName("city").sendKeys(r.getCell(5).getStringCellValue());
		driver.findElementByName("state").sendKeys(r.getCell(6).getStringCellValue());
		
		double p=r.getCell(7).getNumericCellValue();
		long y=(long)p;
		String postalCode=Long.toString(y);
		
		driver.findElementByName("postalCode").sendKeys(postalCode);
		driver.findElementByName("country").sendKeys(r.getCell(8).getStringCellValue());
		
		driver.findElementById("email").sendKeys(r.getCell(9).getStringCellValue());
		driver.findElementByName("password").sendKeys(r.getCell(10).getStringCellValue());
		driver.findElementByName("confirmPassword").sendKeys(r.getCell(11).getStringCellValue());
		
		driver.findElementByName("register").click();
		
		String expected_UserName=r.getCell(9).getStringCellValue();
		System.out.println(" The expected UserName is : "+expected_UserName);
		
		
		String actual_UserRegistedText=driver.findElementByXPath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b").getText();
		System.out.println(" The actual User Registered Text is : "+actual_UserRegistedText);
		
		
		if(actual_UserRegistedText.contains(expected_UserName))
		{
			System.out.println(" The User registered Successfully - PASS");
			r.createCell(12).setCellValue("The User registered Successfully - PASS");
		}
		else
		{
			System.out.println(" User Registration Failed - FAIL");
			r.createCell(12).setCellValue("User Registration Failed - FAIL");
		}
		
		FileOutputStream file1 = new FileOutputStream(System.getProperty("user.dir")+"\\src\\com\\ApplicationTestResultFiles\\NewUserRegistation_TestResult.xlsx");
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
