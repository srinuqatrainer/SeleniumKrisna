package com.Annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations2
{
	@BeforeTest
	public void applicationlaunchAndLogIn()
	{
		System.out.println(" Gmail Launch and login ");
	}
	
	@AfterTest
	public void closeApplication()
	{
		System.out.println(" Gmail Application close ");
	}
	
	@Test(priority=0)
	public void inBox()
	{
		System.out.println(" Testing InBox Functionality ");
	}
	
	@Test(priority=1)
	public void composeMail()
	{
		System.out.println(" Testing compose Mail functionality ");
	}
	
	
	
}
