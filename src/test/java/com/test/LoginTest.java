package com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest {
	
	WebDriver driver ;
	
	Logger log = Logger.getLogger(LoginTest.class);
	
	@Test
	public void m1() throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("launching chrome");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");
		log.info("entering application url");
		
		
	}
	
	@Test
	public void search() throws InterruptedException{
		try{
	    Assert.assertFalse(driver.findElement(By.name("q")).isDisplayed());
	    log.info("search bar displayed");
		}catch(AssertionError e){
			
			log.warn("search bar not displayed");
			
		}
		driver.findElement(By.name("q")).sendKeys("ps4");
		driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
		Thread.sleep(1000);
	
		driver.findElement(By.name("btnK")).click();
	log.info("button clicked");
		
	}
	
	@AfterTest
	public void teardown(){
		
		driver.quit();
		
	}
	

}
