package www.facebook.com;

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

public class ChangeProfilePic {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://www.facebook.com";
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	@Test
	public void TestProfilePicChange(){
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("loginbutton")).click();
		
		driver.findElement(By.xpath("//*[@id='userNav']/ul/li[1]/a/div/span")).click();		//goto profile				
		
		WebElement profilePic = driver.findElement(By.xpath("//img[@class='profilePic img']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(profilePic).build().perform();
				
		driver.findElement(By.xpath("//div[text()='Update Profile Picture']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[type='file'][title='Choose a file to upload']"))));
		
		driver.findElement(By.cssSelector("input[type='file'][title='Choose a file to upload']")).click();
		
		
		
		
		
		
		
		
	}
}
