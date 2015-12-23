package com.inputs.training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtons {
	WebDriver driver = null;
	
	@BeforeClass
	public void stUp(){
		driver = new FirefoxDriver();
	}
	@AfterClass
	public void shutDown(){
		driver.quit();
	}
	
	
	@Test
	public void radioButton(){
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		List<WebElement> allRadios = driver.findElements(By.name("group1"));
		
		for(WebElement radio:allRadios ){
			System.out.println(radio.getAttribute("value")+"----"+ radio.getAttribute("checked"));
		}
	}
	
}
