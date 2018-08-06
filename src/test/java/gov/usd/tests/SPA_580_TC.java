package gov.usd.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_580_TC extends TestBase {



	@Test(priority = 23, description = "Hover over the PROFILE to reach Federal Accounts link, Check ascending and descending order")
	public void openFederalAccounts() {
		extentLogger = report.createTest("Hover over the PROFILE to reach Federal Accounts link, Check ascending and descending order");
		
		FederalAccountsPage fap = new FederalAccountsPage();
		
		driver.get(ConfigurationReader.getProperty("urlUSA"));
		Assert.assertTrue(fap.goProfileGoFederalAccVerUrl());
		extentLogger.pass("Verified Federal Account Url");

		List<Integer> actualList = fap.convertingToInteger();
		List<Integer> expRes = fap.convertingToInteger();
		
		Collections.sort(expRes);
		fap.descendAccountNumBtn.click();

		Assert.assertNotEquals(actualList, expRes);
		extentLogger.pass("Check ascending order");
		
		List<Integer> actualList1 = fap.convertingToInteger();
		List<Integer> expRes1 = fap.convertingToInteger();

		Collections.reverse(expRes1);
		BrowserUtils.waitFor(2);
		fap.descendAccountNumBtn.click();
	
		Assert.assertEquals(actualList1, expRes1);
		extentLogger.pass("Check descending order");
	}
}
