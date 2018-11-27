package com.WebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTable {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// html/body/div[1]/div[8]/section[1]/div/section/div[1]/div/table - identifying the block(table)
		
		WebElement table=driver.findElementByXPath("html/body/div[1]/div[8]/section[1]/div/section/div[1]/div/table");
		
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++) // Row's
		{
			List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++) // Going to every Row -- internally move to all the columns
			{
				String data=cols.get(j).getText();
				System.out.print(data+" ");
			}
			
			
			System.out.println();
			
		}
		
		driver.quit();
		

	}

}
