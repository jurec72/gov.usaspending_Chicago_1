package gov.usd.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

public class SPA_261_TC extends TestBase {

	

	@Test(priority = 1, description = "Home page Title, logo, main menu verification")
	public void verifyHomePageTitleMenu() {
		
		extentLogger = report.createTest("Home page Title, logo, main menu verification");
		
		HomePage hp = new HomePage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("Verified title of the home page");

		boolean logoVerification = hp.logo.isDisplayed();

		Assert.assertTrue(logoVerification);
		
		extentLogger.pass("Verified logo of the home page");

		boolean menuVerification = hp.mainMenu.isDisplayed();

		Assert.assertTrue(menuVerification);
		
		extentLogger.pass("Verified main menu of the home page");

	}
}
