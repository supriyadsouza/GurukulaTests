package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntityViewPage extends BasePage{

	EntityViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="html/body/div[3]/div[1]/div/button")
	protected WebElement buttonBack;
	
	public EntitiesPage clickBack(){
		buttonBack.click();
		if ((driver.getTitle()).equals("Branch"))
			return new BranchesPage(driver);
		else
			return new StaffsPage(driver);
	}
	
}
