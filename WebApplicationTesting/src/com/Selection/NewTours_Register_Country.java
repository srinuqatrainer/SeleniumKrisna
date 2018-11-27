package com.Selection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTours_Register_Country {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		//Thread.sleep(7000);
		
		// <select size="1" name="country">
		
		WebElement country=driver.findElement(By.name("country"));
		
		/*List<WebElement>countryNames=country.findElements(By.tagName("option"));
		
		System.out.println(countryNames.size());
		
		for(int i=0;i<countryNames.size();i++)
		{
			System.out.println(countryNames.get(i).getText());
		}*/
		
		Select selection = new Select(country);
		//selection.selectByIndex(3);
		//selection.selectByVisibleText("INDIA");
		selection.selectByValue("236");
		
		
		//driver.quit();
		


	}

}
