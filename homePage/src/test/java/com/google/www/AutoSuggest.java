package com.google.www;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSuggest {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://www.google.com";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testAutoSuggest(){
		driver.findElement(By.name("q")).sendKeys("hi there");

		List<WebElement> suggestions = driver.findElements(By.cssSelector("div.sbdd_b div.sbsb_a ul"));
		
		for(int i=0; i<suggestions.size();i++){
			System.out.println(driver.findElement(By.cssSelector("div.sbdd_b div.sbsb_a ul")).getText());
		}
	}
}
