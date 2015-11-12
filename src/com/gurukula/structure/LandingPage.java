package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div[2]/div/div[1]/a")
	private WebElement linkLogin;
	
	public AuthenticationPage clickLogin(){
		linkLogin.click();
		return new AuthenticationPage(driver);
	}
}
