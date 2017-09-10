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
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver(); //initialize

		driver.get("https://dev.tracko.co.in/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
