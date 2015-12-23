package com.inputs.training;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraggableJQueryui {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://jqueryui.com/droppable/";
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
	public void testDraggableObject(){
		/*List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		System.out.println(frameList.size());
		*/
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//*[@id='droppable']/p")).getText());
		WebElement src = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement tgt = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(src, tgt).build().perform();
		//System.out.println(driver.findElement(By.xpath("//*[@id='droppable']/p")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='droppable']/p")).getText(), "Dropped!");
		driver.switchTo().defaultContent();
		
	}
}
