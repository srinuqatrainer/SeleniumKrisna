package com.CapturingURL;

import org.openqa.selenium.firefox.FirefoxDriver;

public class CapturingUrl_Facebook {

	public static void main(String[] args)
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.navigate().to("http://facebook.com");
		
		String actual_Url=driver.getCurrentUrl();
		System.out.println(" The Current URL of Facebook Application is : "+actual_Url);

		String actual_Title=driver.getTitle();
		System.out.println(" The Title of Facebook Home page is :"+ actual_Title);

		driver.close();
	}

}
