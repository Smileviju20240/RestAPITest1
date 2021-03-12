package com.github.SeleniumToDoMVC;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class EditingTodos {
	WebDriver driver;
  
	@BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("http://www.todomvc.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  String text = driver.findElement(By.xpath("//a[@href='examples/react']")).getText();
		  System.out.println("The MV Framework is :"+text);
		  driver.findElement(By.xpath("//a[@href='examples/react']")).click();
	  }
	
	@Test(groups = "Regression")
  public void edittodos() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[contains(@class,'new-todo')]")).sendKeys("Tood_1");
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//input[contains(@class,'new-todo')]")).sendKeys("Tood_2");
		Actions Act1 = new Actions(driver);
		Act1.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//div[@class='view']//label"));
		Actions Act2 = new Actions(driver);
		Act2.doubleClick(driver.findElement(By.xpath("//div[@class='view']//label"))).perform();
		driver.findElement(By.cssSelector(".edit")).sendKeys("Test123");
		Actions Act3 = new Actions(driver);
		Act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		List<WebElement> ar = new ArrayList<>();
		ar= driver.findElements(By.xpath("//div[@class='view']//label"));
		System.out.println(ar.size());
		for(WebElement p:ar) {
			System.out.println(p.getText());
		}
  }
  

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.close();
  }

}
