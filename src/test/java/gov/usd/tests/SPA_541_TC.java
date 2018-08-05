package gov.usd.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;
import gov.usd.tests.TestBase.TestBase;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class SPA_541_TC extends TestBase {

	HomePage hp = new HomePage();

	AgenciesPage ap = new AgenciesPage();

	Actions action = new Actions(Driver.getDriver());

	@Test(priority = 1, description = "Check search result on Agencies page")
	public void agenciesPageSearchTest() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		action.moveToElement(hp.profileMenu).build().perform();

		hp.agencies.click();

		ap.searchInput.sendKeys(ConfigurationReader.getProperty("searchInputAgencies"));

		List<String> actualResult = new ArrayList<>();

		ap.searchResult.stream().forEach(x -> actualResult.add(x.getText()));

		int countResult = 0;

		for (String str : actualResult) {

			if (str.contains("Health")) {
				countResult++;
			}

		}
		int searchCountResult=Integer.parseInt(ap.searchCount.getText().substring(0, 2).trim());
		
		assertEquals(countResult,searchCountResult );

	}

}
