package com.KeyBoardOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Facebook_LogInTest {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//  id="email"
		
		driver.findElement(By.id("email")).sendKeys("Krishna");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		
		act.sendKeys("hello").build().perform();
		
		act.sendKeys(Keys.ENTER).build().perform();

	}

}
