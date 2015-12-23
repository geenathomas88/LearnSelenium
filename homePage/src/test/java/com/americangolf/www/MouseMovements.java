package com.americangolf.www;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseMovements {

	WebDriver driver = null;
	
	@BeforeClass
	public void setUp(){
		String url = "http://www.americangolf.co.uk/golf-clubs/fairway-woods";
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
	public void clickGolf(){
		Actions action = new Actions(driver);
		WebElement golfClub =driver.findElement(By.cssSelector("div#navigation ul.menu-category li:nth-child(1) a"));
		action.moveToElement(golfClub).build().perform();
		
		List<WebElement> golfLinksBox = driver.findElements(By.cssSelector("div#CLUBS_1 div.col-subcategory a.level-2"));
		//WebElement driverGolfClub = driver.findElement(By.xpath("//*[@id='CLUBS_1']/div[1]/ul[2]/li/ul/li[2]/ul/li[1]/a"));
		
		Random random = new Random();
		int randomNumber =random.nextInt(golfLinksBox.size());
		WebElement randomLink = golfLinksBox.get(randomNumber);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(randomLink));
		
		randomLink.click();
		
		WebElement priceSlider = driver.findElement(By.cssSelector("div#secondary div.refinements div.refinement.price div.priceslider-container div span.first"));
		action.dragAndDropBy(priceSlider, 50, 0).build().perform();
	}
}
