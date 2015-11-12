package com.gurukula.tests;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurukula.classes.RegistrationData;
import com.gurukula.structure.MenuBar;
import com.gurukula.structure.RegistrationPage;

public class RegistrationTest extends BaseTest{
	private RegistrationPage registrationPage;
	private MenuBar menuBar;
	
	@DataProvider(name = "dataRegistration")
	public Object[][] createData() {
          return new Object[][] {
        	{ new RegistrationData("\\*@&^@(", "supriya.dsouza@gmail.com", "12345", "Bad login") },
        	{ new RegistrationData("ABCDE", "supriya.dsouza@gmail.com", "12345", "Bad login") },
            { new RegistrationData("dsouzasu", "supriya.dsouza", "12345", "Bad email") },
            { new RegistrationData("dsouzasu", "supriya.dsouza@", "12345", "Bad email") },
            { new RegistrationData("dsouzasu", "supriya.dsouza@gmail.com", "1234", "Bad password") },
            { new RegistrationData("dsouzasu", "supriya.dsouza@gmail.com", "12345", "") },
          };
	}
	
	@Test(dataProvider="dataRegistration")
	public void testRegisterNewUser(RegistrationData regData){
		menuBar = new MenuBar(driver);
		menuBar.clickHome();
		menuBar.clickAccount();
		registrationPage = menuBar.clickRegister();
		registrationPage.register(regData.getLogin(), regData.getEmail(), regData.getPassword());
		
		switch(regData.getExpectedError()) {
		case "Bad login":
			Assert.assertTrue(registrationPage.isLoginInvalidMessageShown());
			break;
			
		case "Login required":
			Assert.assertTrue(registrationPage.isLoginRequiredMessageShown());
			break;
			
		case "Bad email":
			Assert.assertTrue(registrationPage.isEmailInvalidMessageShown());
			break;
			
		case "Bad password":
			Assert.assertTrue(registrationPage.isPasswordInvalidMessageShown() && 
					registrationPage.isPasswordConfrirmationInvalidMessageShown());
			break;
			
		case "":
			Assert.assertFalse(registrationPage.isFailureMessageShown());
			break;
		}
	}
}
