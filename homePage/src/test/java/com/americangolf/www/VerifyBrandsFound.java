package com.americangolf.www;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyBrandsFound {

	WebDriver driver = null;
	
	@BeforeClass
	public void setUp(){
		String url = "http://www.americangolf.co.uk/golf-clubs/fairway-woods";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	@Test
	public void verifyBrandsFound(){
		
		
		
		List<WebElement> refinementBrandList = driver.findElements(By.cssSelector("div.refinement.brand div span.refinement-count"));
		int sum = 0;
		String count;
		for(WebElement refinementBrand : refinementBrandList){
			
			
			count = refinementBrand.getText().replaceAll("\\D", "");
			
			sum = sum + Integer.valueOf(count);

		}
		System.out.println(sum);
		int searchCount = Integer.parseInt(driver.findElement(By.cssSelector("div.pagination div.results-hits span")).getText());
		Assert.assertEquals(sum, searchCount);
	}
	
	
}
