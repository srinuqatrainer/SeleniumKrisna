package com.BrowserAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ExternalBrowserAutomation {

	public static void main(String[] args)
	{
		// Chrome Browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverFiles\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.quit();
		
		// Edge Browser
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\driverFiles\\MicrosoftWebDriver.exe");
		EdgeDriver driv = new EdgeDriver();
		driv.get("http://google.com");
		driv.quit();
		
		// Internet Explorer
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\driverFiles\\IEDriverServer.exe");
		InternetExplorerDriver dri = new InternetExplorerDriver();
		dri.get("http://yahoo.com");
		
		// Latest FireFox Browser --- FF-50version to current version
		// Selenium server standalone jar file above 3.0version
		// Gecko Driver
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverFiles\\geckodriver.exe");
		FirefoxDriver d = new FirefoxDriver();
		d.get("http://gmail.com");
		

	}

}
