package com.flipkart.FlipKart;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToGetPriceOfIphoneAndWriteToExcel {
	@Test
	public void teGrt() throws EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		int i=0;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		ele.sendKeys("iphone 11");
		ele.sendKeys(Keys.ENTER);

		List<WebElement> all = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for(WebElement ele1:all)
		{
			File file=new File("D:\\Appium\\FlipKart\\Data\\FlipData.xlsx");
			FileInputStream fis=new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			sh.createRow(i).createCell(0).setCellValue(ele1.getText());
			i++;
			FileOutputStream fos=new FileOutputStream(file);
			wb.write(fos);
			
		}

	}

}


