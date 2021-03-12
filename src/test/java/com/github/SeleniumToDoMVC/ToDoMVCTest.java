package com.github.SeleniumToDoMVC;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ToDoMVCTest {
	WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		    
	  }
	
  @Test(groups = "Regression")
  public void TestcaseOne() throws InterruptedException {
	  
	  driver.get("http://www.todomvc.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();	
	  // Store the text
	  String text = driver.findElement(By.xpath("//a[@href='examples/react']")).getText();
	  System.out.println("The MV Framework is :"+text);
	  driver.findElement(By.xpath("//a[@href='examples/react']")).click();
	  String text2 = driver.getTitle();
	  System.out.println(text2);
	  
  }
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
