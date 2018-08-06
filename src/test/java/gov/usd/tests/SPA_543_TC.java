package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_543_TC extends TestBase {

	@Test(priority = 13, description = "Hover over drop down Functionality")
	public void HoverOverDropDownFunctionality() {

		extentLogger = report.createTest(
				"Check federal url, title of the Home Page, Profiles is clickble and pager buttons");

		FederalAccountsPage fap = new FederalAccountsPage();
		HomePage hp = new HomePage();
		ProfilesStatePage psp = new ProfilesStatePage();
		Actions action = new Actions(driver);

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		extentLogger.pass("Verified title of the Home Page");

		action.moveToElement(hp.profileMenu).perform();
		Assert.assertTrue(hp.federalAccountsSubMenu.isDisplayed());
		extentLogger.pass("Verified is federal account sub menu displayed");

		hp.federalAccountsSubMenu.click();
		String expectedUrl = ConfigurationReader.getProperty("urlFederal");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		extentLogger.pass("Verified federal url");

		fap.nextPagerBtn.click();
		BrowserUtils.waitFor(2);
		Assert.assertTrue(fap.backPagerBtn.isEnabled());
		extentLogger.pass("Verified pager buttons is it enable");

		fap.backPagerBtn.click();
		Assert.assertTrue(!fap.backPagerBtn.isEnabled());
		extentLogger.pass("Verified pager buttons is it enable");

	}

}
