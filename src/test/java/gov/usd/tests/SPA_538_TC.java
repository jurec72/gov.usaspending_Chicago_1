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
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_538_TC extends TestBase {
	
	BrowserUtils br = new BrowserUtils();
	
	AgenciesPage ap = new AgenciesPage();
	
	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Verifing current title")

	public void verificationTitle() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		String currentTitle = ConfigurationReader.getProperty("title");

		String actualTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle, "Verifing current title");

	}

	@Test(priority = 2, description = "Profiles is clickble")

	public void hoverOver() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesAgenciesOption.isDisplayed());

		hp.profilesAgenciesOption.click();

	}

	@Test(priority = 3, description = "Verifing Percent Of Total ascending order")

	public void agengiesAscendingOrder() throws InterruptedException {

		ap.agenciesAscending.click();

		List<Double> actuaAgenciesDescending = ap.convertingToDouble(ap.agenciesPercentOfTotalList);

		List<Double> expectedAgenciesDescending = new ArrayList<>();

		expectedAgenciesDescending.addAll(actuaAgenciesDescending);

		Collections.sort(expectedAgenciesDescending);

		Assert.assertEquals(expectedAgenciesDescending, actuaAgenciesDescending);

	}

	@Test(priority = 4, description = "Verifing Percent Of Total descending order")

	public void agenciesDescendingOrder() throws InterruptedException {

		ap.agenciesAscending.click();

		List<Double> actuaAgenciesDescending2 = ap.convertingToDouble(ap.agenciesPercentOfTotalList);

		List<Double> expectedAgenciesDescending = new ArrayList<>();

		expectedAgenciesDescending.addAll(actuaAgenciesDescending2);
		
		Collections.sort(expectedAgenciesDescending);
		Collections.reverse(expectedAgenciesDescending);

		Assert.assertEquals(expectedAgenciesDescending, actuaAgenciesDescending2);
	
	}

	@Test(priority = 5, description = "Verifing Percent Of Total ascending order")

	public void agenciesBudgetaryResourcesAscending() {

		ap.agenciesBudgetaryResourcesClick.click();
		ap.agenciesBudgetaryResourcesClick.click();

		List<Double> actualBudgetaryResourcesAscending = ap.convertingToDouble(ap.agenciesBudgetaryResourcesList);

		List<Double> expectedBudgetaryResourcesAscending = new ArrayList<>();

		expectedBudgetaryResourcesAscending.addAll(actualBudgetaryResourcesAscending);

		Collections.sort(expectedBudgetaryResourcesAscending);

		Assert.assertEquals(expectedBudgetaryResourcesAscending, actualBudgetaryResourcesAscending);

	}

	@Test(priority = 6, description = "Verifing Percent Of Total descending order")

	public void agenciesBudgetaryResourcesDescending() {

		ap.agenciesBudgetaryResourcesClick.click();

		List<Double> actualBudgetaryResourcesDescending = ap.convertingToDouble(ap.agenciesBudgetaryResourcesList);

		List<Double> expectedBudgetaryResourcesDescending = new ArrayList<>();

		expectedBudgetaryResourcesDescending.addAll(actualBudgetaryResourcesDescending);

		Collections.sort(expectedBudgetaryResourcesDescending);
		Collections.reverse(expectedBudgetaryResourcesDescending);

		Assert.assertEquals(expectedBudgetaryResourcesDescending, actualBudgetaryResourcesDescending);

	}

	@Test(priority = 7, description = "Verifing Agency Name ascending order")

	public void agenciesAgencyNameAscending() {

		ap.agenciesAgencyNameClick.click();

		List<String> actualAgencyNameAscending = ap.convertingToString(ap.agenciesAgencyNameList);

		List<String> expectedAgencyNameAscending = new ArrayList<>();

		expectedAgencyNameAscending.addAll(actualAgencyNameAscending);

		Collections.sort(expectedAgencyNameAscending);

		Assert.assertEquals(expectedAgencyNameAscending, actualAgencyNameAscending);

	}

	@Test(priority = 8, description = "Verifing agencies descending order")

	public void agenciesAgencyNameDescending() {

		ap.agenciesAgencyNameClick.click();

		List<String> actualAgencyNameDescending = ap.convertingToString(ap.agenciesAgencyNameList);

		List<String> expectedAgencyNameDescending = new ArrayList<>();

		expectedAgencyNameDescending.addAll(actualAgencyNameDescending);

		Collections.sort(expectedAgencyNameDescending);
		Collections.reverse(expectedAgencyNameDescending);

		Assert.assertEquals(expectedAgencyNameDescending, actualAgencyNameDescending);

	
	}

}
