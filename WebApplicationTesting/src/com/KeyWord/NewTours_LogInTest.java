package com.KeyWord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
		
		//driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("SignIn"))).click();
		
		String expected_Title="Find";
		System.out.println(" Expected Title is: "+expected_Title);
		
		String actual_Title=driver.getTitle();
		System.out.println(" Actual Title is: "+ actual_Title);
		
		if(actual_Title.contains(expected_Title))
		{
			System.out.println(" LogIn Successfull - PASS ");
			
		}
		else
		{
			System.out.println(" LogIn Failed -- FAIL");
			
		}
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	}
