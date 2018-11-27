package com.NewToursLogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInTest {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		
		// <input type="text" size="10" name="userName">
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		
		//<input type="password" size="10" name="password">
		driver.findElementByName("password").sendKeys("tutori");
		
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
		}
		else
		{
			System.out.println(" LogIn Failed -- FAIL");
		}
		
		driver.close();
	}

}
