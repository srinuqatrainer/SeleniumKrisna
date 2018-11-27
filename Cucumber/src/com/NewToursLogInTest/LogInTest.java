package com.NewToursLogInTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInTest
{

	FirefoxDriver driver;
	@Given("^Open FireFox browser and navigate to newtours application$")
	public void Open_FireFox_browser_and_navigate_to_newtours_application() 
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	}

	@When("^User enters valid userName and password and click on SignIn button$")
	public void User_enters_valid_userName_and_password_and_click_on_SignIn_button()  
	{
		
		driver.findElementByName("userName").sendKeys("tutorial");
		driver.findElementByName("password").sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	 
	}

	@Then("^User should be able to successfully logIn to the application and close the browser$")
	public void User_should_be_able_to_successfully_logIn_to_the_application_and_close_the_browser() 
	{
	
		String expected_Title = "Find";
		System.out.println(" The expected Title is : "+expected_Title);
		
		String actual_Title = driver.getTitle();
		System.out.println(" The actual Title is : "+actual_Title);
		
		if(actual_Title.contains(expected_Title))
		{
			System.out.println(" LogIn Successfull - PASS");
		}
		else
		{
			System.out.println(" LogIn Failed - FAIL");
		}
		
		driver.quit();
	}
	
	
	
}
