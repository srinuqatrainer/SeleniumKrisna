package com.MouseOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_HelloSignIn_MouseHover {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://amazon.in");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// id="nav-link-yourAccount"  -- hello SignIn
		
		WebElement helloSignIn=driver.findElement(By.id("nav-link-yourAccount"));
		
		Actions act = new Actions(driver);
		act.moveToElement(helloSignIn).build().perform();

	}

}
