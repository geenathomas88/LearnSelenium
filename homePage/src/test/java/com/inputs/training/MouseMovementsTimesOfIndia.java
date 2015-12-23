package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseMovementsTimesOfIndia {
	WebDriver driver = null;
	EventFiringWebDriver eventDriver;
	MyListener myListener;

	@BeforeClass
	public void setUp(){
		String url = "https://en.wikipedia.org/wiki/Christmas";
		driver = new FirefoxDriver();
		eventDriver = new EventFiringWebDriver(driver);
		myListener = new MyListener();
		eventDriver.register(myListener);
		eventDriver.navigate().to(url);
		eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eventDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		eventDriver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		//eventDriver.quit();
	}
	@Test
	public void mouseMoveAndRightClick(){
		EventFiringMouse mouse = new EventFiringMouse(eventDriver, myListener);
		
		//move mouse
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='mw-content-text']/div[27]/a"));
		Coordinates coordinates = hoverItem.getCoordinates();
		
		try {
			mouse.mouseMove(coordinates);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='mw-content-text']/div[27]/a")).sendKeys(Keys.chord(Keys.SHIFT,Keys.F10));
		
		Point point = driver.findElement(By.xpath("//*[@id='mw-content-text']/div[27]/a")).getLocation();
		System.out.println(point.x +"----"+ point.y);
	}
}
