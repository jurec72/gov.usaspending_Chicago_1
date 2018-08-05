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
import gov.usd.utilities.ConfigurationReader;

public class SPA_515_TC extends TestBase {
	BrowserUtils br = new BrowserUtils();

	AgenciesPage ap = new AgenciesPage();

	HomePage hp = new HomePage();

	FederalAccountsPage fa = new FederalAccountsPage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Verifing current title")

	public void verificationTitle() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		String currentTitle = ConfigurationReader.getProperty("title");

		String actualTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle, "Verifing current title");

	}

	@Test(priority = 2, description = "Profiles is clickble")

	public void hoverOver() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesAgenciesOption.isDisplayed());

		hp.profilesAgenciesOption.click();

		Assert.assertTrue(ap.agenciesTitle.isDisplayed());

	}

	@Test(priority = 3, description = "Verify it goes to Federal AccountsPage")

	public void federalAccountsPageIsDisplayed() {

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.federalAccountsSubMenu.isDisplayed());

		hp.federalAccountsSubMenu.click();

		Assert.assertTrue(fa.federalAccountsTitle.isDisplayed());

	}

	@Test(priority = 4, description = "Verify  State Page")

	public void statePageIsDisplayed() throws InterruptedException {

		Actions action = new Actions(driver);

		Thread.sleep(2000);
		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesStateOption.isDisplayed());

		hp.profilesStateOption.click();

		Assert.assertTrue(psp.stateTitle.isDisplayed());

	}
}
