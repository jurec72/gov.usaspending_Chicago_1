package gov.usd.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

public class SPA_261_TC extends TestBase {

	HomePage hp = new HomePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {
		
		extentLogger = report.createTest("1");

		
		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("11");

	}

	@Test(priority = 2, description = "Verifing the logo")
	public void logoVerification() {
		
		extentLogger = report.createTest("2");

		boolean logoVerification = hp.logo.isDisplayed();

		Assert.assertTrue(logoVerification);
		
		extentLogger.pass("22");

	}

	@Test(priority = 3, description = "Verifing is the main menu displayed")
	public void mainMenuDisplayed() {
		
		extentLogger = report.createTest("3");

		boolean menuVerification = hp.mainMenu.isDisplayed();

		Assert.assertTrue(menuVerification);
		
		extentLogger.pass("33");

	}
}
