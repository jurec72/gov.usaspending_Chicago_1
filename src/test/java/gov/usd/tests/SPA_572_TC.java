package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_572_TC extends TestBase {

	@Test(priority = 18, description = "Check Federal Accounts change pages ")
	public void pageBtnTest() {
		
		extentLogger = report.createTest("Check Federal Accounts change pages ");

		FederalAccountsPage fap = new FederalAccountsPage();

		HomePage hp = new HomePage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("Verified title of the home page ");

		Assert.assertTrue(fap.goProfileGoFederalAccVerUrl());
		
		extentLogger.pass("Verified url of the Federal Accounts page ");

		BrowserUtils.waitFor(2);

		fap.nextPagerBtn.click();

		BrowserUtils.waitFor(2);

		Assert.assertTrue(fap.backPagerBtn.isEnabled());
		
		extentLogger.pass("Verified button back ");

		fap.backPagerBtn.click();

		Assert.assertTrue(!fap.backPagerBtn.isEnabled());
		
		extentLogger.pass("Verified button forward ");

	}

}
