package com.gurukula.structure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private static final int TIMEOUT = 1000;
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isElementVisible(String xpath){
		waitUntilElementIsVisible(xpath);
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean containsString(String s){
		if (driver.getPageSource().contains(s))
			return true;
		else
			return false;
	}
	
	public void waitUntilElementIsVisible(String xpath){
		wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
}
