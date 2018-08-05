package gov.usd.tests;



import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.tests.TestBase.TestBase;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;


public class SPA_543_TC extends TestBase{

	FederalAccountsPage fap = new FederalAccountsPage();

	HomePage hp=new HomePage();


	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Title verification")
	public void verificationTitle() {

		hp.goHomePageAndVerifyTitle();
		
	}

	@Test(priority = 2, description = "Profiles is clickble")
	public void hoverOver() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesFederalAccountsOption.isDisplayed());

		hp.profilesFederalAccountsOption.click();

	}


	@Test(priority = 3, description = "Verifying federal url")
	public void statesUrl() {

		String expectedUrl = ConfigurationReader.getProperty("urlFederal");

		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);

	}

	@Test(priority=4,description="Verifying pager buttons")
	public void pagerButton(){

		fap.nextPagerBtn.click();

		BrowserUtils.waitFor(2);

		Assert.assertTrue(fap.backPagerBtn.isEnabled());

		extentLogger.pass("Verified pager button up");

		fap.backPagerBtn.click();

		Assert.assertTrue(!fap.backPagerBtn.isEnabled());

	}

}


