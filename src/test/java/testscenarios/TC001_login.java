package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_login extends BaseClass {
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyLoginElements();
		Assert.assertTrue(result);
	}
	@Test(priority = 1)
	public void loginWithValidCredential() {
		boolean result = new LoginPage()
		.enterUserName("aarthi@credosystemz.sandbox")
		.enterPassword("Credo@Testing2024")
		.clickOnLogin()
		.verifyHomeElement()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		Assert.assertTrue(result);
	}
	@Test(priority = 1)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.enterUserName("aarthi@credosystemz.sandbox")
		.enterPassword("Credo@Testing2023")
		.clickOnLoginWithInvalidCredential()
		.validateErrorMsg();
		Assert.assertTrue(result);
		
	}
}
