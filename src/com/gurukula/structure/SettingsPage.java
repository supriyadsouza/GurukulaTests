package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	private static final String MSG_SETTINGS_SAVED_XPATH = 
			".//div[@class='alert alert-success ng-scope']/strong[text()='Settings saved!']";
	private static final String MSG_ERROR_XPATH = 
			"html/body/div[3]/div[1]/div/div/div/div[3]/strong";
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[1]/input")
	private WebElement textboxFirstName;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[2]/input")
	private WebElement textboxLastName;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[3]/input")
	private WebElement textboxEmail;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/div/form/div[4]/select")
	private WebElement dropdownLanguage;
	
	@FindBy(xpath=".//button[@class='btn btn-primary ng-scope'][text()='Save']")
	private WebElement buttonSave;
	
	public void enterFirstName(String fname){
		textboxFirstName.clear();
		textboxFirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname){
		textboxLastName.clear();
		textboxLastName.sendKeys(lname);
	}
	
	public void enterEmail(String email){
		textboxEmail.clear();
		textboxEmail.sendKeys(email);
	}
	
	public void selectLanguage(String language){
		dropdownLanguage.sendKeys(language);
	}
	
	public void clickSave(){
		buttonSave.click();
	}
	
	public boolean isFailureMessageShown(){
		return isElementVisible(MSG_ERROR_XPATH);
	}
	
	public boolean isSuccessMessageShown(){
		return isElementVisible(MSG_SETTINGS_SAVED_XPATH);
	}
}
