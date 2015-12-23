package com.inputs.training;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTables {
	
		WebDriver driver = null;

		@BeforeClass
		public void setUp(){
			String url = "http://www.w3schools.com/html/html_tables.asp";
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
		public void webTableExtraction(){
			List<WebElement> firstNames = driver.findElements(By.xpath("//*[@id='main']/table[@class='w3-table-all']/tbody/tr/td[2]"));
			List<WebElement> points = driver.findElements(By.xpath("//*[@id='main']/table[@class='w3-table-all']/tbody/tr/td[4]"));
			
			Assert.assertEquals(firstNames.size(), points.size());
			
			for(int i=0; i<firstNames.size(); i++){
				//System.out.println(firstNames.get(i).getText()+"----"+points.get(i).getText());
				
			}
			System.out.println("Text Jack is present in "+getRowWithCellData("Jack") +"row");
		
		}
	
		public int getRowWithCellData(String data){
			int rows = driver.findElements(By.xpath("//*[@id='main']/table[@class='w3-table-all']/tbody/tr")).size();
			int cols = driver.findElements(By.xpath("//*[@id='main']/table[@class='w3-table-all']/tbody/tr[1]/td")).size();
			
			for(int rowNum =1;rowNum<=rows;rowNum++){
				List<WebElement> rowCells = driver.findElements(By.xpath("//*[@id='main']/table[@class='w3-table-all']/tbody/tr["+rowNum+"]/td"));
				for(int colNum =0;colNum<rowCells.size();colNum++){
					String text =rowCells.get(colNum).getText();
					//System.out.println(text);
					
					if(text.contains(data)){
						return rowNum;
					}
				}
			}
			return 0;
		}
}
