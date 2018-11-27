package com.ValidatingTitle;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidatingTitle_Google {

	public static void main(String[] args)
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.navigate().to("http://google.com");
		
		String expected_Title="Google";
		System.out.println(" Expected title of Google home page is : "+expected_Title);
		
		String actual_Title=driver.getTitle();
		System.out.println(" Actual Title of Facebook Home page is :"+ actual_Title);
		
		if(actual_Title.equals(expected_Title))
		{
			System.out.println(" Title Matched -- PASS");
		}
		else
		{
			System.out.println(" Title not matched -- FAIL");
		}

		driver.close();

	}

}
