package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_538_TC extends TestBase {

	@Test(priority = 9, description = "Check Percent Of Total sorting order")

	public void agenciesPercentOfTotalSortTest() {

		extentLogger = report.createTest("Check POT Down Button Active");

		AgenciesPage ap = new AgenciesPage();

		HomePage hp = new HomePage();

		Actions action = new Actions(driver);

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the Home page");

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesAgenciesOption.isDisplayed());

		extentLogger.pass("Verified Agencies submenu");

		hp.profilesAgenciesOption.click();

		BrowserUtils.waitFor(1);

		ap.agenciesAscending.click();

		List<Double> actuaAgenciesAscending = ap.convertingToDouble(ap.agenciesPercentOfTotalList);

		List<Double> expectedAgenciesAscending = new ArrayList<>();

		expectedAgenciesAscending.addAll(actuaAgenciesAscending);

		Collections.sort(expectedAgenciesAscending);

		Assert.assertEquals(expectedAgenciesAscending, actuaAgenciesAscending);

		extentLogger.pass("Verified Agencies Percent of Total ascending order");

		ap.agenciesAscending.click();

		List<Double> actuaAgenciesDescending2 = ap.convertingToDouble(ap.agenciesPercentOfTotalList);

		List<Double> expectedAgenciesDescending = new ArrayList<>();

		expectedAgenciesDescending.addAll(actuaAgenciesDescending2);

		Collections.sort(expectedAgenciesDescending);

		Collections.reverse(expectedAgenciesDescending);

		Assert.assertEquals(expectedAgenciesDescending, actuaAgenciesDescending2);

		extentLogger.pass("Verified Agencies Percent of Total Descending order");

	}

	@Test(priority = 10, description = "Check Budgetary Resources sorting order")

	public void agenciesBudgetaryResourcesSortTest() {

		extentLogger = report.createTest("Check Budgetary Resources sorting order");

		AgenciesPage ap = new AgenciesPage();

		HomePage hp = new HomePage();

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		hp.profilesAgenciesOption.click();

		BrowserUtils.waitFor(1);

		ap.agenciesBudgetaryResourcesClick.click();

		ap.agenciesBudgetaryResourcesClick.click();

		List<Double> actualBudgetaryResourcesAscending = ap.convertingToDouble(ap.agenciesBudgetaryResourcesList);

		List<Double> expectedBudgetaryResourcesAscending = new ArrayList<>();

		expectedBudgetaryResourcesAscending.addAll(actualBudgetaryResourcesAscending);

		Collections.sort(expectedBudgetaryResourcesAscending);

		Assert.assertEquals(expectedBudgetaryResourcesAscending, actualBudgetaryResourcesAscending);

		extentLogger.pass("Verified Budgetary Resources Ascending order");

		ap.agenciesBudgetaryResourcesClick.click();

		List<Double> actualBudgetaryResourcesDescending = ap.convertingToDouble(ap.agenciesBudgetaryResourcesList);

		List<Double> expectedBudgetaryResourcesDescending = new ArrayList<>();

		expectedBudgetaryResourcesDescending.addAll(actualBudgetaryResourcesDescending);

		Collections.sort(expectedBudgetaryResourcesDescending);

		Collections.reverse(expectedBudgetaryResourcesDescending);

		Assert.assertEquals(expectedBudgetaryResourcesDescending, actualBudgetaryResourcesDescending);

		extentLogger.pass("Verified Budgetary Resources Descending order");

	}

	@Test(priority = 11, description = "Check Agency Name sorting order")

	public void agenciesAgencyNameSortTest() {

		extentLogger = report.createTest("Check Agency Name sorting order");

		AgenciesPage ap = new AgenciesPage();

		HomePage hp = new HomePage();

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		hp.profilesAgenciesOption.click();

		BrowserUtils.waitFor(1);

		ap.agenciesAgencyNameClick.click();

		List<String> actualAgencyNameAscending = ap.convertingToString(ap.agenciesAgencyNameList);

		List<String> expectedAgencyNameAscending = new ArrayList<>();

		expectedAgencyNameAscending.addAll(actualAgencyNameAscending);

		Collections.sort(expectedAgencyNameAscending);

		Assert.assertEquals(expectedAgencyNameAscending, actualAgencyNameAscending);

		extentLogger.pass("Verified Agency Name Ascending order");

		ap.agenciesAgencyNameClick.click();

		List<String> actualAgencyNameDescending = ap.convertingToString(ap.agenciesAgencyNameList);

		List<String> expectedAgencyNameDescending = new ArrayList<>();

		expectedAgencyNameDescending.addAll(actualAgencyNameDescending);

		Collections.sort(expectedAgencyNameDescending);

		Collections.reverse(expectedAgencyNameDescending);

		Assert.assertEquals(expectedAgencyNameDescending, actualAgencyNameDescending);

		extentLogger.pass("Verified Agency Name Descending order");

	}

}
