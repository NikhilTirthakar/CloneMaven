package com.test.JenkinsProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class TrackoProject {
	WebDriver driver;
	Logger Log=Logger.getLogger(TrackoProject.class);
	String str="nikhil";
	
	
	
	@BeforeTest
	public void beforeTest() throws InterruptedException 
	{
		/*-----Log4J-------*/
       //BasicConfigurator.configure();
       
        PropertyConfigurator.configure("Resource/log4j.properties");
        
        
		//Utility_Class ref= new Utility_Class();
		//int num1= ref.randomNum();
		//email="paresh"+num1+@gmail.com;
		
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--start-maximized");
		 driver = new ChromeDriver(options);
		Log.info("This will open my browser");
		driver.get("https://dev.tracko.co.in/");
		Log.info("This will open my URL");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//driver.manage().window().maximize();

		//Thread.sleep(5000);
		//System.out.println("classs");
		//System.out.println("something is update");

	}
	
	@Test
	public void testOne() throws InterruptedException
	{
		try
		{
			SignUP ref= new SignUP(driver);
			ref.signup();
			Log.info("This is SignUP Process");
		}
		catch (Exception e)
		{
			Log.error("Signup Process not running");
			
		}
		
	}
	

//	@Test
//	public void TestTwo()
//	{
//		//driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
//		
//		//driver.findElement(By.xpath("//input[@id='login-mobile']")).click();
//
//	}
/*
	@AfterTest
	public void afterTest() {

		driver.quit();

	}*/

}
