package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;

public class SPA_520_TC extends TestBase {

	@Test(priority = 7, description = "Check Agencies submenu")

	public void agenciesPageTest() {
		
		extentLogger = report.createTest("Check Agencies submenu");

		AgenciesPage ap = new AgenciesPage();
		
		HomePage hp = new HomePage();
		
		Actions action = new Actions(driver);

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the Home page");

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesAgenciesOption.isDisplayed());
		
		extentLogger.pass("Verified Agencies submenu from Profile");

		hp.profilesAgenciesOption.click();
		
		Assert.assertTrue(ap.agenciesTitle.isDisplayed());
		
		extentLogger.pass("Verified Agencies page title");

	}
}
