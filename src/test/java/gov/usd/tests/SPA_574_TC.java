package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_574_TC extends TestBase {

	
	@Test(priority = 20, description = "Verification States Awarded Amount in Ascending And Descending Order")
	public void sortStatesAwardedAmountInAscAndDescOrder() {
		
		extentLogger = report.createTest("Verification States Awarded Amount in Ascending And Descending Order");

		HomePage hp = new HomePage();

		ProfilesStatePage psp = new ProfilesStatePage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("Verified  home page title");

		Assert.assertTrue(hp.goToProfileToStateVerifyUrl());

		extentLogger.pass("Verified  states url");

		BrowserUtils.waitFor(1);

		psp.clickToGetAssendingOrder.click();

		List<Double> actualStatesAwardedAmountAssending = psp.convertingToDouble();

		List<Double> expectedStatesAwardedAmountAssending = new ArrayList<>();

		expectedStatesAwardedAmountAssending.addAll(actualStatesAwardedAmountAssending);

		Collections.sort(expectedStatesAwardedAmountAssending);

		Assert.assertEquals(expectedStatesAwardedAmountAssending, actualStatesAwardedAmountAssending);

		extentLogger.pass("Verified States Awarded Amount Ascending order");
		
		psp.clickToGetDecendingOrder.click();

		List<Double> actualStatesAwardedAmountDecending = psp.convertingToDouble();

		Collections.reverse(expectedStatesAwardedAmountAssending);

		Assert.assertEquals(expectedStatesAwardedAmountAssending, actualStatesAwardedAmountDecending);

		extentLogger.pass("Verified States Awarded Amount Descending order");
	}

}
