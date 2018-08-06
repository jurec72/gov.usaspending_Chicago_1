package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.utilities.BrowserUtils;

public class SPA_570_TC extends TestBase {

	@Test(priority = 16, description = "Check Managing Agency button sorting order")
	public void managingAgencyFunctionality() {

		extentLogger = report.createTest("Check Managing Agency button sorting order");

		FederalAccountsPage fap = new FederalAccountsPage();

		Assert.assertTrue(fap.goProfileGoFederalAccVerUrl());

		extentLogger.pass("Verified Federal Accounts page title");

		BrowserUtils.waitFor(2);

		fap.managingAgency.click();

		extentLogger.pass("Verified Managing Agency button");

	}
}
