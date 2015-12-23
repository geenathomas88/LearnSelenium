package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://qtpselenium.com/test/uploadform/contactform.php";
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
	public void testFileUpload(){
		driver.findElement(By.cssSelector("input#photo")).sendKeys("C:\\Users\\bibin_000\\Downloads\\pic.jpg");
	}
}
