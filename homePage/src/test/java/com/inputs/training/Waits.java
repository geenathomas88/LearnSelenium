package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Waits {

	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://toolsqa.com/automation-practice-switch-windows/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void timingAlertTest(){
		driver.findElement(By.id("timingAlert")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.accept();
		
		
		
	}
}
