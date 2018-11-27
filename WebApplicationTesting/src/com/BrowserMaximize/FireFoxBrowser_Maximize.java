package com.BrowserMaximize;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser_Maximize {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

}
