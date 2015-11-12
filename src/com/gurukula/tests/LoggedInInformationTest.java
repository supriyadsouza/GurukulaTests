package com.gurukula.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurukula.structure.MenuBar;
import com.gurukula.structure.SettingsPage;

public class LoggedInInformationTest extends BaseTestWithLogin{

	private MenuBar menuBar;
	private SettingsPage settingsPage;
	
	@Parameters({"firstname", "lastname", "email", "language"})
	@Test
	public void testEditAccountSettings(
			String firstName, String lastName, String email, String language){
		menuBar = new MenuBar(driver);
		menuBar.clickAccount();
		settingsPage = menuBar.clickSettings();
		settingsPage.enterFirstName(firstName);
		settingsPage.enterLastName(lastName);
		settingsPage.enterEmail(email);
		settingsPage.selectLanguage(language);
		settingsPage.clickSave();
		//Assert.assertTrue(settingsPage.isSuccessMessageShown());
		Assert.assertFalse(settingsPage.isFailureMessageShown());
	}
}
