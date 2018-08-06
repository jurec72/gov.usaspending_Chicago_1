package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;

public class SPA_536_TC extends TestBase {

	@Test(priority = 8, description = "Check POT Down Button Active")
	public void POTDwonBtnTest() {

		extentLogger = report.createTest("Check POT Down Button Active");

		HomePage hp = new HomePage();

		AgenciesPage ap = new AgenciesPage();

		Actions action = new Actions(driver);

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the Home page");

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.federalAccountsSubMenu.isDisplayed());

		extentLogger.pass("Verified Federal Accounts submenu");

		hp.agenciesSubMenu.click();

		String buttonActive = "sort-icon active";

		Assert.assertEquals(ap.potDownBtn.getAttribute("class"), buttonActive);

		extentLogger.pass("Verified POT Down Button");

	}

}
