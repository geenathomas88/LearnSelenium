package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuBeginnersBook {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://beginnersbook.com";
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
	public void dropdownMenu(){

		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='menu-item-5683']/a"));
		WebElement subMenu = driver.findElement(By.xpath("//*[@id='menu-item-5894']/a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mainMenu).build().perform();
		
		subMenu.click();
	}
}
