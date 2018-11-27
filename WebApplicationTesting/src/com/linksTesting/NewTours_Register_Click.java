package com.linksTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_Register_Click {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		
		// <a href="mercuryregister.php?osCsid=52d8d3bbf14c6469ae8a79f05352949d">REGISTER</a>
		
		//a - anchor tag
		// href - attribute
		
		//element is of type link
		
		//locator -- linkText
		// selector - REGISTER
		
		//WebElement register=driver.findElementByLinkText("REGISTER");
		WebElement register=driver.findElementByPartialLinkText("REGIS");
		register.click();
		
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
