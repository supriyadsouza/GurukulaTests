package com.gurukula.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBar extends BasePage {

	public MenuBar(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath=".//*[@id='navbar-collapse']//a/span[2][text()='Home']")
	private WebElement menuHome;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']/ul//span[2][text()='Entities']")
	private WebElement menuEntities;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']/ul//span[2][text()='Branch']")
	private WebElement menuBranch;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']/ul//span[2][text()='Staff']")
	private WebElement menuStaff;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']//span/span[2][text()='Account']")
	private WebElement menuAccount;

	@FindBy(xpath=".//*[@id='navbar-collapse']//a/span[2][text()='Settings']")
	private WebElement menuSettings;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']/ul/li[3]/ul/li[4]/a/span[2]")
	private WebElement menuLogout;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']//a/span[2][text()='Register']")
	private WebElement menuRegister;
	
	@FindBy(xpath=".//*[@id='navbar-collapse']//a/span[2][text()='Authenticate'")
	private WebElement menuAuthenticate;
	
	public HomePage clickHome(){
		menuHome.click();
		return new HomePage(driver);
	}

	
	public void clickEntities(){
		menuEntities.click();
	}
	
	public BranchesPage clickBranch(){
		menuBranch.click();
		return new BranchesPage(driver);
	}
	
	public StaffsPage clickStaff(){
		menuStaff.click();
		return new StaffsPage(driver);
	}
	
	public void clickAccount(){
		menuAccount.click();
	}
	
	public LandingPage clickLogout(){
		menuLogout.click();
		return new LandingPage(driver);
	}
	
	public RegistrationPage clickRegister(){
		menuRegister.click();
		return new RegistrationPage(driver);
	}
	
	public SettingsPage clickSettings(){
		menuSettings.click();
		return new SettingsPage(driver);
	}
}
