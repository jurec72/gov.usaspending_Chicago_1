package gov.usd.tests;



import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.tests.TestBase.TestBase;
import gov.usd.utilities.ConfigurationReader;


public class SPA_536_TC extends TestBase{

	HomePage hp=new HomePage();

	AgenciesPage ap = new AgenciesPage();


	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Title verification")
	public void verificationTitle() {

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
	}

	@Test(priority = 2, description = "Profiles is clickble")
	public void hoverOver() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesFederalAccountsOption.isDisplayed());

	}


	@Test(priority = 3, description = "Verifying POT Down Button Active")
	public void potDownButtonActive() {

		hp.agencies.click();

		String buttonActive = "sort-icon active";

		Assert.assertEquals(ap.potDownBtn.getAttribute("class"), buttonActive);

	}


}


