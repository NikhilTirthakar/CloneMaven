package com.test.JenkinsProject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUP {

	Logger Log = Logger.getLogger(SignUP.class);// log4j
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Sign Up Free')]") // page factory
	WebElement Signup;

	// POM
	// By locator_of_SignUP=By.xpath("//a[contains(text(),'Sign Up Free')]");
	By locator_of_UserName = By.id("name");
	By locator_of_Email = By.id("email");
	By locator_of_Mobile = By.id("mobile");
	By locator_of_SignUp = By.id("sub_btn_signup");
	By locator_of_OTP = By.id("otp");
	By locator_of_VerifyMobile = By.id("sub_btn_verify");
	By locator_of_OK = By.xpath("//button[text()='OK']");

	// {"method":"id","selector":"//button[(text()='OK')]"}

	public SignUP(WebDriver driver2) {

		driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public void signup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {

			// WebElement signupbutton= driver.findElement(locator_of_SignUP);
			// signupbutton.click();
			Thread.sleep(2000);
			Signup.click();

			Log.info("Click  ing on the SignUp Button");

		} catch (Exception e) {
			Log.error("Clicking on the SignUp Button is Failed");

		}

		try {

			WebElement usernameTextBox = driver.findElement(locator_of_UserName);

			usernameTextBox.sendKeys("nikhil");
			Log.info("Entered User Name in the UserName Text Box");

		} catch (Exception e) {
			Log.error("Entered User Name in the UserName Text Box is not correct");
		}

		try {

			WebElement emailTexBox = driver.findElement(locator_of_Email);
			emailTexBox.sendKeys("nikhil.r@gmail.com");
			Log.info("Entered Email ID in the Email Text Box");

		} catch (Exception e) {
			Log.error("Entered Email ID in the Email Text Box is not correct");
		}

		
		try {

			WebElement MobileNo = driver.findElement(locator_of_Mobile);
			MobileNo.sendKeys("9999999699");
			Log.info("Giving Mobile Number");
		} catch (Exception e) {
			Log.error("Mobile No. not accepting");
		}

		try {
			WebElement Signup = driver.findElement(locator_of_SignUp);
			Signup.click();
			Log.info("SignUP Sucessfully");
			Log.warn("If UserName is not same as existing then SignUP rest process not move ahead");
			Log.fatal("This is Fatal Error");
		} catch (Exception e) {
			Log.error("SignUP Failed");
		}

		Thread.sleep(2000);

		driver.findElement(locator_of_OTP).sendKeys("123456");
		Log.info("Giving OTP");
		Thread.sleep(5000);

		// Actions act=new Actions(driver);
		// act.moveToElement(verifyMobile).click(verifyMobile).build().perform();

		Thread.sleep(5000);

		try {
			WebElement verifyMobile = driver.findElement(locator_of_VerifyMobile);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", verifyMobile);
			Log.info("Verifying the Mobile Number");
		} catch (Exception e) {
			Log.error("Verifying Mobile Number is not running");
		}

		try {
			driver.findElement(locator_of_OK).click();
			Log.info("Clicking on OK Button");
		} catch (Exception e) {
			Log.error("OK Button working is not running");
		}

		Thread.sleep(2000);

	}

}
