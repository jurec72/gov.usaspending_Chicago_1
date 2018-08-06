package gov.usd.tests;



import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.pages.SpendingExplorerPage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.Driver;

public class SPA_511_TC extends TestBase {

	@Test(priority = 3, description = "Go to the home page, Hover over to the Award Search"
			+ " functionality, Hover over Profiles functionality, Download center,"
			+ "Glossary functionality")
	public void homePageMenuSubmenusTests() {
		
		extentLogger = report.createTest("Check Home Page menu");
		
		Actions action = new Actions(Driver.getDriver());
		
		HomePage hp = new HomePage();
		
		SpendingExplorerPage sep = new SpendingExplorerPage();

		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		
		extentLogger.pass("Verified title of the Home page");
		
		BrowserUtils.waitFor(1);

		action.moveToElement(sep.awardSearchMenu).build().perform();

		Assert.assertTrue(sep.adnvacedSearch.isDisplayed());
		
		extentLogger.pass("Verified Advanced search submanu is working");
		
		Assert.assertTrue(sep.keywordSearch.isDisplayed());
		
		extentLogger.pass("Verified Keyword search submanu is working");
		
		BrowserUtils.waitFor(1);

		action.moveToElement(sep.profilesMenu).build().perform();

		Assert.assertTrue(sep.agencies.isDisplayed());
		
		extentLogger.pass("Verified Agencies submanu is working");
		
		Assert.assertTrue(sep.federalAccounts.isDisplayed());
		
		extentLogger.pass("Verified Federal accounts submanu is working");
		
		Assert.assertTrue(sep.states.isDisplayed());
		
		extentLogger.pass("Verified States submanu is working");
		
		Assert.assertTrue(sep.recipients.isDisplayed());
		
		extentLogger.pass("Verified Recipients submanu is working");
		
		BrowserUtils.waitFor(1);

		action.moveToElement(sep.downloadCenterMenu).build().perform();

		Assert.assertTrue(sep.awardDataArchive.isDisplayed());
		
		extentLogger.pass("Verified Award Data Archieve submanu is working");
		
		Assert.assertTrue(sep.customAwardData.isDisplayed());
		
		extentLogger.pass("Verified Custom Data Archieve submanu is working");
		
		Assert.assertTrue(sep.agencySubmissionFiles.isDisplayed());
		
		extentLogger.pass("Verified Agency Submission Files submanu is working");
		
		Assert.assertTrue(sep.databaseDownload.isDisplayed());
		
		extentLogger.pass("Verified Database Download submanu is working");
		
		Assert.assertTrue(sep.api.isDisplayed());
		
		extentLogger.pass("Verified API submanu is working");
		
		BrowserUtils.waitFor(1);

		sep.glossary.click();
		
		BrowserUtils.waitFor(1);

		Assert.assertTrue(sep.glossaryTitle.isDisplayed());
		
		extentLogger.pass("Verified Glossary title is working");

	}
}
