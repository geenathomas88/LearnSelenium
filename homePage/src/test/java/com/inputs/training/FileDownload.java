package com.inputs.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownload {
	WebDriver driver = null;

	@BeforeClass
	public void setUp(){
		String url = "http://qtpselenium.com/test/testdownload.php";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 1);     

		//profile.setPreference("browser.download.dir","C:\\Learn");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword,application/x-rar-compressed,application/octet-stream,application/csv,text/csv");

		driver = new FirefoxDriver(profile);
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
	public void downloadFiles(){
		driver.findElement(By.xpath("html/body/a[1]")).click();
	    driver.findElement(By.xpath("html/body/a[2]")).click();
	    driver.findElement(By.xpath("html/body/a[3]")).click();

	}
}
