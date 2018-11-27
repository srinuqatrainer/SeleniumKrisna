package com.Frame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class IdentifyFrame {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// <iframe class="demo-frame" src="/resources/demos/droppable/default.html"> -- Frame of the Page
		// in which we have the elements to be automated
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		//  id="draggable"
		WebElement dragElement=driver.findElement(By.id("draggable"));
		
		// id="droppable
		WebElement dropElement=driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement,dropElement).build().perform();

	}

}
