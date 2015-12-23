package com.salesforce.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Page1 {

	WebDriver driver = null;
	@Test(enabled=false)
	public void sidePanel(){
		driver.get("http://salesforce.com");
		
	}
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
	}
	@AfterClass
	public void shutDown(){
		driver.quit();
	}
}
