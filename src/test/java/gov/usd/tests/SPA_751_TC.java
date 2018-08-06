package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_751_TC extends TestBase {

	@Test(priority = 24, description = "Check title of the home page and Explorer menu")
	public void launchUrl() {

		extentLogger = report.createTest("Check title of the home page and Explorer menu");

		HomePage hp = new HomePage();
		// launch url
		Assert.assertTrue(hp.goHomePageAndVerifyTitle());

		extentLogger.pass("Verified title of the home page");

		// hover over to spending Explorer Menu and click on it
		BrowserUtils.hover(hp.spendingExplorerMenu);

		BrowserUtils.waitFor(2);

		hp.spendingExplorerMenu.click();

		extentLogger.pass("Verified Explorer menu");
	}

	@Test(priority = 25, description = "Check Award Search Menu and SubMenus in it")
	public void awardSearch() {

		extentLogger = report.createTest("Check Award Search Menu and SubMenus in it");

		HomePage hp = new HomePage();

		// hover over to Award Search Menu and click on Advanced Search SubMenu
		BrowserUtils.hover(hp.awardSearchMenu);

		BrowserUtils.waitFor(1);

		hp.advancedSearchSubMenu.click();
		
		extentLogger.pass("Verified Advanced Search submenu");

		BrowserUtils.waitFor(1);

		// hover over to Award Search Menu and click on Keyword Search SubMenu
		BrowserUtils.hover(hp.awardSearchMenu);
		
		hp.keywordSearchSubMenu.click();
		
		extentLogger.pass("Verified keyword Search");
		
		BrowserUtils.waitFor(2);
	}

	@Test(priority = 26, description = "Check Profile Menu and SubMenus in it")
	public void profilesMenu() {
		
		extentLogger = report.createTest("Check Profile Menu and SubMenus in it");

		HomePage hp = new HomePage();

		// hover over to Profiles Menu and click on Agencies SubMenu
		BrowserUtils.hover(hp.profileMenu);
		
		hp.agenciesSubMenu.click();
		
		extentLogger.pass("Verified Agencies submenu");
		
		BrowserUtils.waitFor(2);

		// hover over to Profiles Menu and click on Federal Accounts SubMenu
		BrowserUtils.hover(hp.profileMenu);
		
		hp.federalAccountsSubMenu.click();
		
		extentLogger.pass("Verified Federal Accounts submenu");
		
		BrowserUtils.waitFor(2);

		// hover over to Profiles Menu and click on States SubMenu
		BrowserUtils.hover(hp.profileMenu);
		
		hp.statesSubMenu.click();
		
		extentLogger.pass("Verified States submenu");
		
		BrowserUtils.waitFor(2);
	}

	@Test(priority = 27, description = "Checking Download Center Menu and SubMenus in it")
	public void downloadCenterMenu() {
		
		extentLogger = report.createTest("Checking Download Center Menu and SubMenus in it");

		HomePage hp = new HomePage();
		
		// hover over to Download Center Menu and click on Award Data Archive SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		
		hp.awardDataArchiveMenu.click();
		
		extentLogger.pass("Verified Award Data Archive submenu");
		
		BrowserUtils.waitFor(2);

		// hover over to Download Center Menu and click on Custom Award Data SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		
		hp.customAwardDataSubMenu.click();
		
		extentLogger.pass("Verified Custom Award Data submenu");
		
		BrowserUtils.waitFor(2);

		// hover over to Download Center Menu and click on Agency Submission Files SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		
		hp.agencySubmissionFilesSubMenu.click();
		
		extentLogger.pass("Verified Agency Submission Files submenu");
		
		BrowserUtils.waitFor(1);
		
		BrowserUtils.switchToWindow(ConfigurationReader.getProperty("USAspending.gov"));

		// hover over to Download Center Menu and click on Database Download SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		
		hp.databaseDownloadSubMenu.click();
		
		extentLogger.pass("Verified Database Download submenu");
		
		BrowserUtils.waitFor(3);
		

		
		BrowserUtils.switchToWindow(ConfigurationReader.getProperty("USAspending.gov"));

		// hover over to Download Center Menu and click on API SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		
		hp.apiSubMenu.click();
		
		extentLogger.pass("Verified API submenu");
		
		BrowserUtils.waitFor(1);
		
		BrowserUtils.switchToWindow(ConfigurationReader.getProperty("USAspending.gov"));
	}

	@Test(priority = 28, description = "Check Glossary Menu")
	public void glossaryMenu() {
		
		extentLogger = report.createTest("Check Glossary Menu");

		HomePage hp = new HomePage();
		
		// hover over to Download Center Menu and click on API SubMenu
		BrowserUtils.hover(hp.glossaryMenu);
		
		hp.glossaryMenu.click();
		
		hp.glossaryExtraMenu.isDisplayed();
		
		extentLogger.pass("Verified Glossary Extra menu");
		
		

	}
}
