package com.gurukula.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected static WebDriver driver;
	protected static final String WEBSITE = "http://127.0.0.1:8080";

	@Parameters({"loginid", "password"})
	@BeforeSuite
	public void setUp(@Optional()String loginid, @Optional()String password){
		initialize();
	}

	protected void initialize() {
		driver = new FirefoxDriver();
		driver.navigate().to(WEBSITE);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	protected void demolish() {
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void tearDown(){
		demolish();
	}
}
