package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_569_TC extends TestBase {

	@Test(priority = 15, description = "Check account name sort order in Federal accounts")
	public void verificationTitle() {
		
		extentLogger = report.createTest("Check account name sort order in Federal accounts");
		
		HomePage hp = new HomePage();

		Actions action = new Actions(driver);

		FederalAccountsPage fap = new FederalAccountsPage();

        Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("Verified title of the home page");

		action.moveToElement(hp.profileMenu).build().perform();

		hp.federalAccountsSubMenu.click();

		String currentUrlForFederalAccountProfile = driver.getCurrentUrl();

		String acctualUrlForFederalAccountProfile = ConfigurationReader.getProperty("urlFederal");

		Assert.assertEquals(currentUrlForFederalAccountProfile, acctualUrlForFederalAccountProfile);

		extentLogger.pass("Verified title of the Federal Account Profile");

		String actualTitle1 = ConfigurationReader.getProperty("title");

		String currentTitle1 = driver.getTitle();

		Assert.assertEquals(currentTitle1, actualTitle1);

		extentLogger.pass("Verified that title of the Federal Account Profile matches the Federal Account Profile");

		BrowserUtils.waitFor(1);

		fap.managingAccountName.click();

		BrowserUtils.waitFor(1);

		List<String> accountNameArrow = new ArrayList<>();

		List<String> expectedNameArrow = new ArrayList<>();

		for (WebElement string : fap.accountNameRow) {

			accountNameArrow.add(string.getText().substring(0, 1));

			expectedNameArrow.add(string.getText().substring(0, 1));
		}

			Collections.sort(expectedNameArrow);

			Assert.assertEquals(accountNameArrow, expectedNameArrow);

			extentLogger.pass("Verified ascending order of Accout Name page ");

			BrowserUtils.waitFor(1);

			fap.managingAccountName.click();

			BrowserUtils.waitFor(1);

			List<String> accountNameDown = new ArrayList<>();

			List<String> expectedNameDown = new ArrayList<>(); // actual list

			for (int i = 0; i < 10; i++) {

				accountNameDown.add(fap.accountNameRow.get(i).getText().substring(0, 1));

				expectedNameDown.add(fap.accountNameRow.get(i).getText().substring(0, 1));

			}

			Assert.assertEquals(accountNameDown, expectedNameDown);

			extentLogger.pass("Verifed descending order");
		}

	}

