package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StaffsPage extends EntitiesPage{

	private static final String NAME_XPATH = ".//*[@id='saveStaffModal']/div/div/form/div[2]/div[2]/input";
	private static final String BRANCH_XPATH = ".//*[@id='saveStaffModal']/div/div/form/div[2]/div[3]/select";
	private static final String CANCEL_XPATH = ".//*[@id='saveStaffModal']/div/div/form/div[3]/button[1]";
	private static final String SAVE_XPATH = ".//*[@id='saveStaffModal']/div/div/form/div[3]/button[2]";
	private static final String DELETE_XPATH = ".//*[@id='deleteStaffConfirmation']/div/div/form/div[3]/button[2]";
			
	@FindBy(xpath=NAME_XPATH)
	private WebElement textboxName;
	
	@FindBy(xpath=BRANCH_XPATH)
	private WebElement selectBranch;
	
	@FindBy(xpath=CANCEL_XPATH)
	private WebElement buttonCancel;
	
	@FindBy(xpath=SAVE_XPATH)
	private WebElement buttonSave;
	
	@FindBy(xpath=DELETE_XPATH)
	private WebElement buttonDelete;
	
	StaffsPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterName(String name){
		waitUntilElementIsVisible(NAME_XPATH);
		textboxName.click();
		textboxName.clear();
		textboxName.sendKeys(name);
	}
	
	public void selectBranch(String branch){
		waitUntilElementIsVisible(BRANCH_XPATH);
		selectBranch.sendKeys(branch);
	}

	public void clickCancel(){
		waitUntilElementIsVisible(CANCEL_XPATH);
		buttonCancel.click();
		driver.navigate().refresh();
	}
	
	public void clickSave(){
		waitUntilElementIsVisible(SAVE_XPATH);
		buttonSave.click();
		driver.navigate().refresh();
	}

	public void clickDelete() {
		waitUntilElementIsVisible(DELETE_XPATH);
		buttonDelete.click();
		driver.navigate().refresh();
	}
}
