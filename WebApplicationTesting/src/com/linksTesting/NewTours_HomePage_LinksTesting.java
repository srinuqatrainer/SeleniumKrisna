package com.linksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_HomePage_LinksTesting {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		
		/*<a href="mercurysignon.php">SIGN-ON</a>
		<a href="mercuryregister.php">REGISTER</a>
		<a href="mercuryunderconst.php">SUPPORT</a>*/
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		
		int linksCount=links.size();
		System.out.println(" The total number of links on the NewTours Application Home page are: "+linksCount);
		
		for(int i=0;i<linksCount;i++)
		{
			String linkName=links.get(i).getText();
			System.out.println(i+" "+linkName);
			
			links.get(i).click();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
			
			links=driver.findElements(By.tagName("a"));
			
		}
		
		driver.quit();


	}

}
