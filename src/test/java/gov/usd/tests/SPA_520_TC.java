package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_520_TC extends TestBase {
BrowserUtils br = new BrowserUtils();
	
	AgenciesPage ap = new AgenciesPage();
	
	HomePage hp = new HomePage();

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
}
