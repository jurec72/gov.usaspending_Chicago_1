package gov.usd.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_751_TC extends TestBase {

	HomePage hp = new HomePage();

	@Ignore
	@Test(priority = 1, description = "Launch the URL")
	public void launchUrl() {
		// launch url
		hp.goHomePageAndVerifyTitle();
		// hover over to spending Explorer Menu and click on it
		BrowserUtils.hover(hp.spendingExplorerMenu);
		BrowserUtils.waitFor(2);
		hp.spendingExplorerMenu.click();
	}

	@Ignore
	@Test(priority = 2, description = "Checking Award Search Menu and SubMenus in it")
	public void awardSearch() {
		hp.goHomePageAndVerifyTitle();
		// hover over to Award Search Menu and click on Advanced Search SubMenu
		BrowserUtils.hover(hp.awardSearchMenu);
		hp.advancedSearchSubMenu.click();
		BrowserUtils.waitFor(2);

		// hover over to Award Search Menu and click on Keyword Search SubMenu
		BrowserUtils.hover(hp.awardSearchMenu);
		hp.keywordSearchSubMenu.click();
		BrowserUtils.waitFor(2);
	}

	@Ignore
	@Test(priority = 3, description = "Checking Profile Menu and SubMenus in it")
	public void profilesMenu() {
		hp.goHomePageAndVerifyTitle();

		// hover over to Profiles Menu and click on Agencies SubMenu
		BrowserUtils.hover(hp.profileMenu);
		hp.agenciesSubMenu.click();
		BrowserUtils.waitFor(2);

		// hover over to Profiles Menu and click on Federal Accounts SubMenu
		BrowserUtils.hover(hp.profileMenu);
		hp.federalAccountsSubMenu.click();
		BrowserUtils.waitFor(2);

		// hover over to Profiles Menu and click on States SubMenu
		BrowserUtils.hover(hp.profileMenu);
		hp.statesSubMenu.click();
		BrowserUtils.waitFor(2);
	}

	@Test(priority = 4, description = "Checking Download Center Menu and SubMenus in it")
	public void downloadCenterMenu() {
		hp.goHomePageAndVerifyTitle();

		// hover over to Download Center Menu and click on Award Data Archive SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		hp.awardDataArchiveMenu.click();
		BrowserUtils.waitFor(2);

		// hover over to Download Center Menu and click on Custom Award Data SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		hp.customAwardDataSubMenu.click();
		BrowserUtils.waitFor(2);

		// hover over to Download Center Menu and click on Agency Submission Files SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		hp.agencySubmissionFilesSubMenu.click();
		BrowserUtils.waitFor(3);
//		Assert.assertEquals(ConfigurationReader.getProperty("titleOfAgencySubmissionsPage"),driver.getTitle());
		BrowserUtils.switchToWindow(ConfigurationReader.getProperty("USAspending.gov"));

		// hover over to Download Center Menu and click on Database Download SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		hp.databaseDownloadSubMenu.click();
		BrowserUtils.waitFor(3);
//		Assert.assertEquals(ConfigurationReader.getProperty("titleOfDataBaseDownloadPage"),driver.getTitle());
		BrowserUtils.switchToWindow(ConfigurationReader.getProperty("USAspending.gov"));

		// hover over to Download Center Menu and click on API SubMenu
		BrowserUtils.hover(hp.downloadCenterMenu);
		hp.apiSubMenu.click();
		BrowserUtils.waitFor(3);
//		Assert.assertEquals(ConfigurationReader.getProperty("titleOfApiPage"),driver.getTitle());
		BrowserUtils.switchToWindow(ConfigurationReader.getProperty("USAspending.gov"));
	}

	@Test(priority = 5, description = "Checking Glossary Menu")
	public void glossaryMenu() {
		hp.goHomePageAndVerifyTitle();

		// hover over to Download Center Menu and click on API SubMenu
		BrowserUtils.hover(hp.glossaryMenu);
		hp.glossaryMenu.click();
		hp.glossaryExtraMenu.isDisplayed();

	}
}
