package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_login extends BaseClass {
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFileName = "TC001";
	}
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage(driver).verifyLoginElements();
		Assert.assertTrue(result);
	}
	@Test(priority = 1,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String sUserName, String sPassword) {
		boolean result = new LoginPage(driver)
		.enterUserName(sUserName)
		.enterPassword(sPassword)
		.clickOnLogin()
		.verifyHomeElement()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		Assert.assertTrue(result);
	}
	@Test(priority = 1)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage(driver)
		.enterUserName("aarthi@credosystemz.sandbox")
		.enterPassword("Credo@Testing2023")
		.clickOnLoginWithInvalidCredential()
		.validateErrorMsg();
		Assert.assertTrue(result);
		
	}
}
