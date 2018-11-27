package com.RadioButton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton_Testing {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table
		
		WebElement block=driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table"));
		
		// <input type="radio" value="Milk" name="group1"/>
		List<WebElement>radio=block.findElements(By.name("group1"));
		
		System.out.println(radio.size());
		
		for(int i=0;i<radio.size();i++) // performs click on each radion button
		{
			radio.get(i).click();
			
			for(int j=0;j<radio.size();j++) // will get the stutus of the radion buttons
			{
				System.out.println(radio.get(j).getAttribute("value")+" "+radio.get(j).getAttribute("checked"));
			}
			
		}
		
		
		
		driver.close();

	}

}
