package com.gurukula.structure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage{

	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}

	private static final String LOGGED_IN_ALERT = ".//div[@class='alert alert-success ng-scope ng-binding']";
	
	@FindBy(xpath=".//*[@id='username']")
	private WebElement textboxUsername;
	
	@FindBy(xpath=".//*[@id='password']")
	private WebElement textboxPassword;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/button")
	private WebElement buttonAuthenticate;
	
	public void enterUsername(String uname){
		textboxUsername.sendKeys(uname);
	}
	
	public void enterPassword(String pword){
		textboxPassword.sendKeys(pword);
	}
	
	public HomePage clickAuthenticate(){
		buttonAuthenticate.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGGED_IN_ALERT)));
		return new HomePage(driver);
	}
}