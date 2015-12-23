package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestListener {
	WebDriver driver = null;
	EventFiringWebDriver eventDriver;

	@BeforeClass
	public void setUp(){
		String url = "http://gmail.com";
		driver = new FirefoxDriver();
		eventDriver = new EventFiringWebDriver(driver);
		MyListener myListener = new MyListener();
		eventDriver.register(myListener);
		eventDriver.navigate().to(url);
		eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eventDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		eventDriver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		eventDriver.quit();
	}
	@Test
	public void testBackButton(){
		eventDriver.findElement(By.linkText("Create account")).click();
		eventDriver.navigate().back();
		eventDriver.navigate().forward();
	}
}
