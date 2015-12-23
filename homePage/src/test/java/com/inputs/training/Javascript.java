package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Javascript {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://www.w3schools.com/js/";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	@Test
	public void TestJavascript(){
		//((JavascriptExecutor) driver).executeScript("document.getElementById('demo').innerHTML=Date()");
		
		
		((JavascriptExecutor) driver).executeScript("w3_open_nav('references')");
	}
}
