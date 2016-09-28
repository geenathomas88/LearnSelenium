package com.salesforce.home;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesforceLogin {

	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "https://login.salesforce.com/";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	@Test
	public void testLogin() throws InterruptedException{
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("Login")).click();	
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.uiScroller div.scroller ul.homeList li#actionCard_Lead")));
		
		Assert.assertEquals("Home", driver.getTitle());
		driver.findElement(By.cssSelector("div.uiScroller div.scroller ul.homeList li#actionCard_Lead")).click();
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.listViewEntityLabelPlural span.uiOutputText")));
	
		String title = driver.findElement(By.cssSelector("div.listViewEntityLabelPlural span.uiOutputText")).getText();
		Assert.assertEquals("LEADS", title);
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div.forceObjectHomeDesktopActionBar ul.oneActionsRibbon li a")).click();
		
		
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHanler = null;
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHanler = iterator.next();
			
		}
		driver.switchTo().window(subWindowHanler);
		
		WebElement selectLeadStatus = driver.findElement(By.cssSelector("select[id^='40']"));
		Select dropdownLead = new Select(selectLeadStatus);
		dropdownLead.selectByValue("New");
		
		WebElement selectSalutation = driver.findElement(By.cssSelector("select[id^='82']"));
		Select dropdownSalutation = new Select(selectSalutation);
		dropdownSalutation.selectByValue("Mr.");
		
		driver.findElement(By.cssSelector("input[id^='92']")).sendKeys("Geena");
		driver.findElement(By.cssSelector("input[id^='101']")).sendKeys("Thomas");
		driver.findElement(By.cssSelector("input[id^='110']")).sendKeys("Bibin");
		driver.findElement(By.cssSelector("input[id^='119']")).sendKeys("XX");
		driver.findElement(By.cssSelector("input[id^='159']")).sendKeys("Title");
		driver.findElement(By.cssSelector("input[id^='174']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[id^='174']")).sendKeys("ABC Company");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[id^='193']")).sendKeys("geenathms@gmail.com");
		
		
		WebElement selectLeadSource = driver.findElement(By.cssSelector("select[id^='278']"));
		Select dropdownLeadSource = new Select(selectLeadSource);
		dropdownLeadSource.selectByValue("Advertisement");
		
		
		
		System.out.println(driver.findElement(By.cssSelector("input[id^='174']")).getAttribute("value"));
		
		driver.findElement(By.cssSelector(".uiButton--default.uiButton--brand.uiButton.forceActionButton")).click();
	}
}
