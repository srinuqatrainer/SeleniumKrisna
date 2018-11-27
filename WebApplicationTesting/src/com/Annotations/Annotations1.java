package com.Annotations;

import org.testng.annotations.Test;

public class Annotations1
{

	@Test(priority=0) 
	public void browserLaunch()
	{
		System.out.println(" FireFox Browser launch ");
	}
	
	@Test(priority=1)
	public void gmailApplicationLaunch()
	{
		System.out.println(" Navigate to Gmail Application");
	}
	
	@Test(priority=2)
	public void logIn()
	{
		System.out.println(" Testing LogIn functionality ");
	}
	
	@Test(enabled=false)
	public void inBox()
	{
		System.out.println(" Testing InBox Functionality ");
	}
	
	@Test(priority=3)
	public void composeMail()
	{
		System.out.println(" Testing compose Mail functionality ");
	}
	
	
}
