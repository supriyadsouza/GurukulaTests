package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	private static final String MSG_REG_FAILED_XPATH = ".//div[@class='alert alert-danger ng-scope']";
	private static final String MSG_LOGIN_REQ_XPATH = "html/body/div[3]/div[1]/div/div/div/form/div[1]/div/p[1]";
	private static final String MSG_EMAIL_INV_XPATH = "html/body/div[3]/div[1]/div/div/div/form/div[2]/div/p[2]";
	private static final String MSG_PWD_INV_XPATH = "html/body/div[3]/div[1]/div/div/div/form/div[3]/div[1]/p[2]";
	private static final String MSG_PWD_CONF_INV_XPATH = "html/body/div[3]/div[1]/div/div/div/form/div[4]/div/p[2]";
	private static final String MSG_LOGIN_INV_XPATH = "html/body/div[3]/div[1]/div/div/div/form/div[1]/div/p[4]";
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[1]/input")
	private WebElement textboxLogin;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[2]/input")
	private WebElement textboxEmail;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[3]/input")
	private WebElement textboxPassword;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[4]/input")
	private WebElement textboxRepeatPassword;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/button")
	private WebElement buttonRegister;
	
	public void enterUsername(String uname){
		textboxLogin.sendKeys(uname);
	}
	
	public void enterEmail(String email){
		textboxEmail.sendKeys(email);
	}
	
	public void enterPassword(String pword){
		textboxPassword.sendKeys(pword);
	}
	
	public void enterRepeatPassword(String rpword){
		textboxRepeatPassword.sendKeys(rpword);
	}
	
	public void clickRegister(){
		buttonRegister.click();
	}
	
	public void register(String login, String email, String pword){
		enterUsername(login);
		enterEmail(email);
		enterPassword(pword);
		enterRepeatPassword(pword);
		clickRegister();
	}
	
	public boolean isLoginRequiredMessageShown(){
		return isElementVisible(MSG_LOGIN_REQ_XPATH);
	}
	
	public boolean isEmailInvalidMessageShown(){
		return isElementVisible(MSG_EMAIL_INV_XPATH);
	}
	
	public boolean isPasswordInvalidMessageShown(){
		return isElementVisible(MSG_PWD_INV_XPATH);
	}
	
	public boolean isPasswordConfrirmationInvalidMessageShown(){
		return isElementVisible(MSG_PWD_CONF_INV_XPATH);
	}
	
	public boolean isLoginInvalidMessageShown(){
		return isElementVisible(MSG_LOGIN_INV_XPATH);
	}
	
	public boolean isFailureMessageShown(){
		return isElementVisible(MSG_REG_FAILED_XPATH);
	}
}
