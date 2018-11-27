package com.FacebookLogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook_LogInTest {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		// <input id="email" class="inputtext" type="email" data-testid="royal_email" tabindex="1" name="email">
		
		// id - locator
		// email - selector
		
		driver.findElement(By.id("email")).sendKeys("krishna");
		
		// <input id="pass" class="inputtext" type="password" data-testid="royal_pass" tabindex="2" name="pass">
		
		driver.findElement(By.name("pass")).sendKeys("hello");
		
		// <label id="loginbutton" class="uiButton uiButtonConfirm" for="u_0_8">
		
		driver.findElement(By.id("loginbutton")).click();
		
		

	}

}
