package com.ValidatingURL;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidatingURL_Facebook {

	public static void main(String[] args)
	{
			
		FirefoxDriver driver = new FirefoxDriver();
		driver.navigate().to("http://facebook.com");
		
		String expected_Url="facebook.com";
		System.out.println(" Expected URL is: "+ expected_Url);
		
		String actual_Url=driver.getCurrentUrl();
		System.out.println(" The Current URL of Facebook Application is : "+actual_Url);
		
		if(actual_Url.contains(expected_Url))
		{
			System.out.println(" URL Requirement is met -- PASS");
		}
		else
		{
			System.out.println(" Expected Text not found in the URL  -- FAIL");
		}
		
		
		driver.close();
	}

}
