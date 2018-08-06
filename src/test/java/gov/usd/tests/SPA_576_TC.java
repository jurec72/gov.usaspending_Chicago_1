package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_576_TC extends TestBase {

	@Test(priority = 22, description = "Check number of results Awarded amount on States page")
	public void awardedAmountResultTest() {

		extentLogger = report.createTest("Check number of results Awarded amount on States page");

		HomePage hp = new HomePage();

		ProfilesStatePage psp = new ProfilesStatePage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the home page");

		BrowserUtils.waitFor(1);

		Assert.assertTrue(hp.goToProfileToStateVerifyUrl());
		
		extentLogger.pass("Verified url of the States page");

		BrowserUtils.waitFor(1);

		String resultLeftCorner = psp.LeftCornerResult.getText().replaceAll("[ results]", "");

		String resultCounted = String.valueOf(psp.statesAwardedAmount.size());

		Assert.assertEquals(resultLeftCorner, resultCounted);
		
		extentLogger.pass("Verified count of the Awarded amount page");

	}

}
