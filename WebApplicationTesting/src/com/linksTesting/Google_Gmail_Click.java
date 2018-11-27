package com.linksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google_Gmail_Click {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		driver.manage().window().maximize();
		
		// class="gb_P"
		
		//WebElement gmail=driver.findElement(By.className("gb_P"));
		WebElement gmail=driver.findElementByLinkText("Gmail");
		gmail.click();
		
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
