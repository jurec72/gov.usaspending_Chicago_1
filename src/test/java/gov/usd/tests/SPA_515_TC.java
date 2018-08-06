package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_515_TC extends TestBase {

	@Test(priority = 4, description = "Check title of the Home Page, Profile menu and Agencies submanu")

	public void profileMenuTest() {

		extentLogger = report.createTest("Check title of the Home Page, Profile menu and Agencies submanu");

		AgenciesPage ap = new AgenciesPage();

		HomePage hp = new HomePage();
		
		Actions action = new Actions(driver);

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the Home page");

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesAgenciesOption.isDisplayed());
		
		extentLogger.pass("Verified Agencies submenu from Profile is working");

		hp.profilesAgenciesOption.click();

		Assert.assertTrue(ap.agenciesTitle.isDisplayed());
		
		extentLogger.pass("Verified title of the Agencies page");

	}

	@Test(priority = 5, description = "Check Federal Accounts Page")

	public void federalAccountsPageTest() {
		
		extentLogger = report.createTest("Check Federal Accounts submenu");
		
		HomePage hp = new HomePage();

		FederalAccountsPage fa = new FederalAccountsPage();

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.federalAccountsSubMenu.isDisplayed());
		
		extentLogger.pass("Verified Federal Accounts submenu from Profile");
		
		hp.federalAccountsSubMenu.click();

		Assert.assertTrue(fa.federalAccountsTitle.isDisplayed());
		
		extentLogger.pass("Verified Federal Accounts page title");
		
	}

	@Test(priority = 6, description = "Check States Page from Profile menu")

	public void statePageTest() {
		
		extentLogger = report.createTest("Check States submenu");

		Actions action = new Actions(driver);
		
		HomePage hp = new HomePage();
		
		ProfilesStatePage psp = new ProfilesStatePage();

		BrowserUtils.waitFor(2);
		
		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesStateOption.isDisplayed());
		
		extentLogger.pass("Verified States submenu from Profile");

		hp.profilesStateOption.click();

		Assert.assertTrue(psp.stateTitle.isDisplayed());
		
		extentLogger.pass("Verified States page title");

	}
}
