package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_571_TC extends TestBase {

	
	

	@Test(priority = 17, description = "Verification Federal Accounts Ascending and Descending Order")
	public void verifiedFederalAccountsAscAndDescOrder() {
		
		extentLogger = report.createTest("Verification Federal Accounts Ascending and Descending Order");
		
		FederalAccountsPage fap = new FederalAccountsPage();

		HomePage hp = new HomePage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("Verified  home page title");

		Assert.assertTrue(fap.goProfileGoFederalAccVerUrl());
		
		extentLogger.pass("Verified url of Federal Account");

		BrowserUtils.waitFor(1);

		fap.clickToGetAscendingOrder.click();

		BrowserUtils.waitFor(1);

		List<Double> actualFederalBudgetaryResources = fap.convertingToDouble();

		List<Double> expectedFederalBudgetaryResourcesAssending = new ArrayList<>();

		expectedFederalBudgetaryResourcesAssending.addAll(actualFederalBudgetaryResources);

		Collections.sort(expectedFederalBudgetaryResourcesAssending);

		Assert.assertEquals(expectedFederalBudgetaryResourcesAssending, actualFederalBudgetaryResources);
		
		extentLogger.pass("Verified ascending order of Federal Account");

		fap.clickToGetDescendingOrder.click();

		BrowserUtils.waitFor(1);

		List<Double> actualFederalBudgetaryResources1 = fap.convertingToDouble();

		List<Double> expectedFederalBudgetaryResourcesDescending = new ArrayList<>();

		expectedFederalBudgetaryResourcesDescending.addAll(actualFederalBudgetaryResources1);

		Collections.sort(expectedFederalBudgetaryResourcesDescending);

		Collections.reverse(expectedFederalBudgetaryResourcesDescending);

		Assert.assertEquals(expectedFederalBudgetaryResourcesDescending, actualFederalBudgetaryResources1);

		extentLogger.pass("Verified descending order of Federal Account");
	}

}
