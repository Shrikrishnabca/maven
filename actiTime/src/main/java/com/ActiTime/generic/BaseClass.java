package com.ActiTime.generic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static
	{
		System.setProperty("webdriver.chromedriver.driver", "./chromedriver.exe");
	}
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
	Reporter.log("open Browser",true);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterTest
	public void closeBrowser()
	{
		Reporter.log("close Browser",true);
		driver.close();
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("Login",true);
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("Logout",true);
	}



}
