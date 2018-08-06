package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_572_TC extends TestBase {

	FederalAccountsPage fap = new FederalAccountsPage();

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {
		
		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

	}

	@Test(priority = 2, description = "Hover over the PROFILE to reach Federal Accounts link")
	public void openFederalAccounts() {

		Assert.assertTrue(fap.goProfileGoFederalAccVerUrl());

	}

	@Test(priority = 3, description = "Verifying pager buttons")
	public void pagerButton() {

		BrowserUtils.waitFor(2);
		
		fap.nextPagerBtn.click();

		BrowserUtils.waitFor(2);

		Assert.assertTrue(fap.backPagerBtn.isEnabled());

		fap.backPagerBtn.click();

		Assert.assertTrue(!fap.backPagerBtn.isEnabled());

	}

}
