package gov.usd.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;

import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.Driver;

public class SPA_567_TC extends TestBase {

	@Test(priority = 14, description = "Check title, Profile menu, Check after click on Account"
			+ " Number btn gives descending order")

	public void accountNumberShortTest() {
		extentLogger = report
				.createTest("Check title, Profile menu, Check after click on Account Num btn gives descending order");

		HomePage hp = new HomePage();

		FederalAccountsPage fap = new FederalAccountsPage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the Home page");

		Assert.assertTrue(fap.goProfileGoFederalAccVerUrl());

		extentLogger.pass("Verified  federal profile verification");

		BrowserUtils.waitFor(1);

		fap.accountNumBtn.click();

		BrowserUtils.waitFor(1);

		List<String> actualResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(y -> actualResultOfNumber.add(y.getText().substring(0, 3)));

		List<String> reverseResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(x -> reverseResultOfNumber.add(x.getText().substring(0, 3)));

		Collections.sort(reverseResultOfNumber);

		Collections.reverse(reverseResultOfNumber);

		assertEquals(actualResultOfNumber, reverseResultOfNumber, "verify descending order");
		extentLogger.pass("verify descending order");

		fap.accountNumBtn.click();

		BrowserUtils.waitFor(1);

		List<String> actualResultOfNumber1 = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(y -> actualResultOfNumber1.add(y.getText().substring(0, 3)));

		List<String> sortedResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(x -> sortedResultOfNumber.add(x.getText().substring(0, 3)));

		Collections.sort(sortedResultOfNumber);

		assertEquals(actualResultOfNumber1, sortedResultOfNumber, "Verified ascending order Account Number Colomn");

		extentLogger.pass("Verified ascending order Account Number Colomn");

	}

}
