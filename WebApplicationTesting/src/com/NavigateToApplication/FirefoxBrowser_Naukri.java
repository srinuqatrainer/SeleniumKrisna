package com.NavigateToApplication;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser_Naukri {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.close();

	}

}
