package com.flipkart.FlipKart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCheckDuplicateInMobileTab {
	@Test
	public void flipKart() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();

		Actions act=new Actions(driver);
		WebElement electronics=driver.findElement(By.xpath("//span[text()='Electronics']"));
		act.moveToElement(electronics).perform();
		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='_1fwVde'])[1]//a"));
		System.out.println(list.size());
		boolean flag=false;
		for(int i=1;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i).getText().equals(list.get(j).getText()))
				{
					System.out.println("Duplicate found at"+j+"value is "+list.get(j));
					flag=true;
					break;
				}				
			}
		}
		if(!flag)
		{
			System.out.println("No duplicates");
		}
		driver.quit();
	}
}
