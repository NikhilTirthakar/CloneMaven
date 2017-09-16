package com.test.JenkinsProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class TrackoProject {
	WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		
		driver.findElement(By.xpath("//input[@id='login-mobile']")).click();

	}
	@BeforeTest
	public void beforeTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver(); //initialize

		driver.get("https://dev.tracko.co.in/");

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(2000);
		System.out.println("classs");
		System.out.println("something is update");

	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
