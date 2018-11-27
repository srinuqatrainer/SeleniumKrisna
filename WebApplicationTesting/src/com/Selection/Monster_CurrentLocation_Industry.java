package com.Selection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Monster_CurrentLocation_Industry {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://my.monsterindia.com/sponsered_popup.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// <select class="border_grey1"
		
		WebElement currentLocation=driver.findElement(By.className("border_grey1"));
		
		Select selection = new Select(currentLocation);
		selection.selectByIndex(3);
		
		// select id="id_industry"
		WebElement industry=driver.findElement(By.id("id_industry"));
		
		Select sel = new Select(industry);
		sel.selectByIndex(1);
		sel.selectByValue("4");
		sel.selectByVisibleText("Banking/ Financial Services");
		
		sel.deselectAll();
		
		

	}

}
