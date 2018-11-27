package com.linksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Apsrtc_HeaderBlock_Testing {

	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://apsrtconline.in/oprs-web/");
		
		driver.manage().window().maximize();
		
		// <div class="menu-wrap"> -- block of the page
		
		WebElement headerBlock=driver.findElement(By.className("menu-wrap"));
		List<WebElement>headerBlocklinks=headerBlock.findElements(By.tagName("a"));
		
		System.out.println("Total number of links on headerBlock are: "+headerBlocklinks.size());
		
		for(int i=0;i<headerBlocklinks.size();i++)
		{
			String headerBlockLinkName=headerBlocklinks.get(i).getText();
			System.out.println(i+" "+headerBlockLinkName);
			
			headerBlocklinks.get(i).click();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
			
			//Thread.sleep(7000);
			Sleeper.sleepTightInSeconds(7);
			
			headerBlock=driver.findElement(By.className("menu-wrap"));
			headerBlocklinks=headerBlock.findElements(By.tagName("a"));
			
			
		}
		
		driver.quit();

	}

}
