package com.linksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google_SignIn_Click {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		driver.manage().window().maximize();
		
		//  id="gb_70"
		
		//driver.findElement(By.id("gb_70")).click();
		//driver.findElementById("gb_70").click();
		
		//WebElement signIn=driver.findElement(By.id("gb_70"));
		//WebElement signIn=driver.findElementById("gb_70");
		//signIn.click();
		
		WebElement signIn=driver.findElement(By.linkText("Sign in"));
		signIn.click();
		
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
