package com.DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_NewUserRegistation
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
	public void userRegistration()
	{
		
		driver.findElementByName("firstName").sendKeys("Krishna");
		driver.findElementByName("lastName").sendKeys("Hello");
		driver.findElementByName("phone").sendKeys("502525");
		driver.findElementById("userName").sendKeys("Krishna@gmail.com");
		
		driver.findElementByName("address1").sendKeys("HiTech City");
		driver.findElementByName("city").sendKeys("Hyderabad");
		driver.findElementByName("state").sendKeys("Telangana");
		driver.findElementByName("postalCode").sendKeys("50001");
		driver.findElementByName("country").sendKeys("INDIA");
		
		driver.findElementById("email").sendKeys("Chaitanya");
		driver.findElementByName("password").sendKeys("abc123");
		driver.findElementByName("confirmPassword").sendKeys("abc123");
		
		driver.findElementByName("register").click();
		
		String expected_UserName="Chaitanya";
		System.out.println(" The expected UserName is : "+expected_UserName);
		
		
		String actual_UserRegistedText=driver.findElementByXPath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b").getText();
		System.out.println(" The actual User Registered Text is : "+actual_UserRegistedText);
		
		
		if(actual_UserRegistedText.contains(expected_UserName))
		{
			System.out.println(" The User registered Successfully - PASS");
		}
		else
		{
			System.out.println(" User Registration Failed - FAIL");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
