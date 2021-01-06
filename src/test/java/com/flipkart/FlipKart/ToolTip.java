package com.flipkart.FlipKart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
	@Test
	public void toolTip() throws InterruptedException {
		
				
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://app-automate.browserstack.com/dashboard/v2");
			driver.findElement(By.id("user_email_login")).sendKeys("roopabhushan92@gmail.com");
			driver.findElement(By.id("user_password")).sendKeys("roopa90806");
			driver.findElement(By.xpath("//input[@value='Sign me in']")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			String dest = driver.findElement(By.xpath("//a[text()='App Live']")).getAttribute("data-header-tooltip");
			System.out.println(dest);			
			driver.quit();
			
		
	}

}
