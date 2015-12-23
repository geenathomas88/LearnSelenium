package com.inputs.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalendarMakemytrip {	
		WebDriver driver = null;

		@BeforeClass
		public void setUp(){
			String url = "http://www.makemytrip.com/";
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
		public void selectDateInMakeMyTrip() throws ParseException{
			WebElement dateIcon = driver.findElement(By.cssSelector("a#start_date_sec"));
			dateIcon.click();
			
			selectStartDate("18/1/2016");
		}
		
		public void selectStartDate(String date) throws ParseException{
			String monthYearDisplayed = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div")).getText();								
			Date currentDate = new Date();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateToBeSelected = dateFormat.parse(date);
			
			String month = new SimpleDateFormat("MMMM").format(dateToBeSelected);
			String year = new SimpleDateFormat("yyyy").format(dateToBeSelected);
			String day = new SimpleDateFormat("d").format(dateToBeSelected);
			
			System.out.println(month+" "+ day +" "+ year);
			String monthYearToBeSelected = month +" "+ year;
			
			while(true){
				if(monthYearToBeSelected.equals(monthYearDisplayed)){
					driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
					break;
				}else{
					if(dateToBeSelected.after(currentDate)){
						driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/div/a/span")).click();
					}else{
						driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
					}
				}
				monthYearDisplayed = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div")).getText();	
			}
		}
}
