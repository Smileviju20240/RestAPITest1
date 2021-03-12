package com.github.SeleniumToDoMVC;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class AddTextAsIntSpecialCharacters {
    WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("http://todomvc.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  String text = driver.findElement(By.xpath("//a[@href='examples/react']")).getText();
		  System.out.println("The MV Framework is :"+text);
		  driver.findElement(By.xpath("//a[@href='examples/react']")).click();
	  }
	
	@Test(groups = "Regression", priority=2)
  public void AddTodosasIntegers() {
		WebElement text3 = driver.findElement(By.xpath("//input[contains(@class,'new-todo')]"));
		text3.sendKeys("1234");
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.ENTER).perform();
  }
	
	@Test(groups = "Regression", priority=1)
	  public void AddTodosasSpecialCharacters() {
			WebElement text3 = driver.findElement(By.xpath("//input[contains(@class,'new-todo')]"));
			text3.sendKeys("@#$<>");
			Actions Act = new Actions(driver);
			Act.sendKeys(Keys.ENTER).perform();
	  }
	
	@Test(priority=3)
	  public void AddTodosascombo() {
			WebElement text3 = driver.findElement(By.xpath("//input[contains(@class,'new-todo')]"));
			text3.sendKeys("sele@2322");
			Actions Act = new Actions(driver);
			Act.sendKeys(Keys.ENTER).perform();
	  }
  

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(8000);
	  driver.close();
  }

}
