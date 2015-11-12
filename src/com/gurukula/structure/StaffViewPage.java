package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StaffViewPage extends EntityViewPage{

	@FindBy(xpath="html/body/div[3]/div[1]/div/div/table/tbody/tr[1]/td[2]/input")
	private WebElement textName;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div/table/tbody/tr[2]/td[2]/input")
	private WebElement textBranch;
	
	StaffViewPage(WebDriver driver) {
		super(driver);
	}
	
	public String getName(){
		return textName.getAttribute("value");
	}
	
	public String getBranchName(){
		return textBranch.getAttribute("value");
	}

}
