package com.inputs.training;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaytmFrames {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://www.paytm.com";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	@Test
	public void testFrames(){
		driver.findElement(By.linkText("Log In / Sign Up")).click();
		//List<WebElement> iframeList = driver.findElements(By.tagName("iframe")); // find all iframes in page
		//System.out.println(iframeList.size());
		/*for(int i=0;i<iframeList.size();i++){//find iframe
			driver.switchTo().frame(i);
			int s = driver.findElements(By.xpath("//*[@id='loginForm']/div/md-content/md-input-container[2]")).size();
			System.out.println(s);
			driver.switchTo().defaultContent();
			
		}*/
		
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//*[@id='input_0']")).sendKeys("sdadak");
		driver.findElement(By.xpath("//*[@id='input_1']")).sendKeys("sdadak");
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("button.md-icon-button.md-accent.close-modal-button.md-button.md-default-theme")).click();

		driver.switchTo().defaultContent();
	}
}
