package com.espncricinfo.www;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTotalScore {

	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://www.espncricinfo.com/england-v-new-zealand-2015/engine/match/743953.html";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

	@Test
	public void testTotalScore(){

		List<WebElement> batsmanScores =driver.findElements(By.xpath("//*[@id='full-scorecard']/div[@class='row']/div/table[1]/tbody/tr/td[@class='bold']"));

		
		int total =0;
		int score = 0;
		
		
		for(int i =0; i<batsmanScores.size()-1;i++){
			try{
				score =Integer.parseInt(batsmanScores.get(i).getText());
				total =total+score;	
				}
			catch(NumberFormatException e){				
			}	
		}
		
		int totalScoreonPage = Integer.parseInt(batsmanScores.get(batsmanScores.size()-1).getText());
		Assert.assertEquals(total, totalScoreonPage);
	}	

}
