package gov.usd.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;

import gov.usd.utilities.BrowserUtils;

public class SPA_575_TC extends TestBase {

	@Test(priority = 21, description = "Check Percent of Total on the States Page sorting order")
	public void percentOfTotalSortingTest() {

		extentLogger = report.createTest("Check Percent of Total on the States Page sorting order");

		HomePage hp = new HomePage();

		ProfilesStatePage psp = new ProfilesStatePage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the home page");

		Assert.assertTrue(hp.goToProfileToStateVerifyUrl());
		
		extentLogger.pass("Verified url of the States page");

		BrowserUtils.waitFor(1); // wait 1 sec before click

		psp.arrowPercentOfTotalUp.click(); // click on arrow button

		List<String> actualResultOfPercent = new ArrayList<>(); // actual list

		// add to actual list all data from webElement
		psp.percentOfTotalAllColumnInfo.stream().forEach(y -> actualResultOfPercent.add(y.getText()));

		List<String> sortedResultOfPercent = new ArrayList<>();

		psp.percentOfTotalAllColumnInfo.stream().forEach(x -> sortedResultOfPercent.add(x.getText()));

		Collections.sort(sortedResultOfPercent);// sorted list

		assertEquals(actualResultOfPercent, sortedResultOfPercent, "verify ascending order");
		
		extentLogger.pass("Verified Percent of Total ascending order");

		psp.arrowPercentOfTotalDown.click();

		List<String> actualResultOfPercent1 = new ArrayList<>();

		psp.percentOfTotalAllColumnInfo.stream().forEach(y -> actualResultOfPercent1.add(y.getText()));

		List<String> decendingResultOfPercent = new ArrayList<>();

		psp.percentOfTotalAllColumnInfo.stream().forEach(y -> decendingResultOfPercent.add(y.getText()));

		Collections.sort(decendingResultOfPercent);

		Collections.reverse(decendingResultOfPercent);

		assertEquals(actualResultOfPercent1, decendingResultOfPercent);
		
		extentLogger.pass("Verified Percent of Total descending order");

	}

}
