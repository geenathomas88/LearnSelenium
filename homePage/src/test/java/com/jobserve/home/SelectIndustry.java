package com.jobserve.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectIndustry {

WebDriver driver = null;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void selectIndustry() throws InterruptedException{
		String url = "http://www.jobserve.com";		
		String selectionValue= "Engineering";
		
		driver.get(url);
		WebElement divClick = driver.findElement(By.id("industryDisplay"));
		divClick.click();
		
			
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ddcl-selInd-ddw div.ui-dropdownchecklist-dropcontainer div")));		
		
		List<WebElement> selectBox = driver.findElements(By.cssSelector("div#ddcl-selInd-ddw div.ui-dropdownchecklist-dropcontainer div"));
		
		
		for(WebElement selectDiv: selectBox){
			if(selectDiv.findElement(By.cssSelector("label.ui-dropdownchecklist-text")).getText().equals("Select All Industries")){
				selectDiv.findElement(By.cssSelector("label.ui-dropdownchecklist-text")).click();				
			}
			if(selectDiv.findElement(By.cssSelector("label.ui-dropdownchecklist-text")).getText().equals(selectionValue)){
				selectDiv.findElement(By.cssSelector("label.ui-dropdownchecklist-text")).click();
			}
		}
	}	
	
}
