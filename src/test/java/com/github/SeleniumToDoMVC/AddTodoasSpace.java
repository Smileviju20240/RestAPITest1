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

public class AddTodoasSpace {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		
		//System.setProperty("webdriver.chrome.driver", "E:\\Selenium SetUp\\Latest\\chromedriver_win32\\chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("http://www.todomvc.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  String text = driver.findElement(By.xpath("//a[@href='examples/react']")).getText();
		  System.out.println("The MV Framework is :"+text);
		  driver.findElement(By.xpath("//a[@href='examples/react']")).click();
	  }
  
	
	@Test
  public void addingspae() {
		driver.findElement(By.xpath("//input[contains(@class,'new-todo')]"));
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.SPACE).perform();
		Act.sendKeys(Keys.ENTER).perform();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(8000);
	  driver.close();
  }
  

}
