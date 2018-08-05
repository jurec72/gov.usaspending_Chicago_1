package gov.usd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class HomePage {
	
	Actions action = new Actions(Driver.getDriver());

	private WebDriver driver;

	public HomePage() {

		driver = Driver.getDriver();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Profiles')]")
	public WebElement profileMenu;

	@FindBy(linkText = "States")
	public WebElement profilesStateOption;

	@FindBy(xpath = "//a[contains(text(),'Federal Accounts')]")
	public WebElement federalAccountsSubMenu;

	@FindBy(xpath = "//div[@id='logo']/a")
	public WebElement logo;

	@FindBy(xpath = "//ul[@class='full-menu__list']")
	public WebElement mainMenu;
	
	@FindBy(xpath = "//a[@class='full-menu__link']/span")
	public WebElement spendingExplorerMenu;

	@FindBy(xpath = "//div[contains(text(),'Award Search')]")
	public WebElement awardSearchMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
	public WebElement advancedSearchSubMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Keyword Search')]")
	public WebElement keywordSearchSubMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Agencies')]")
	public WebElement agenciesSubMenu;

	@FindBy(xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'States')]")
	public WebElement statesSubMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Award Data Archive')]")
	public WebElement awardDataArchiveMenu;
	
	@FindBy(xpath = "//div[@class='glossary-nav__label']")
	public WebElement glossaryMenu;
	
	@FindBy(xpath = "//div[@class='usa-da-glossary-wrapper']")
	public WebElement glossaryExtraMenu;

	@FindBy(xpath = "//div[contains(text(),'Download Center')]")
	public WebElement downloadCenterMenu;

	@FindBy(xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'Custom Award Data')]")
	public WebElement customAwardDataSubMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Agency Submission Files')]")
	public WebElement agencySubmissionFilesSubMenu;

	@FindBy(xpath = "//a[contains(text(),'Database Download')]")
	public WebElement databaseDownloadSubMenu;
	
	@FindBy(xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'API')]")
	public WebElement apiSubMenu;

	@FindBy(xpath = "//div[@class='info-banner__alert-text']")
	public WebElement textOfTheMessage;
	
	@FindBy(xpath = "//div[@class='info-banner__title-text']/../a[1]")
	public WebElement clickAbout;
	
	@FindBy(xpath = "//div[@class='info-banner__title-text']/../a[2]")
	public WebElement clickCommunity;
	
	@FindBy(xpath = "//button[@class='info-banner__close-button']")
	public WebElement clickXBtn;

	@FindBy(xpath = "//a[@class='sidebar-link active']")
	public WebElement Abouttext;
	
	@FindBy(linkText = "Join the Conversation")
	public WebElement communityText;

	@FindBy(linkText="Agencies")
	public WebElement profilesAgenciesOption;
	
	@FindBy(linkText="Federal Accounts")
	public WebElement profilesFederelAccountsOption;
	
	
	/*
	 * method open home page, and verify title
	 */
	public void goHomePageAndVerifyTitle() {

		// Launch the url
		driver.get(ConfigurationReader.getProperty("urlUSA"));

		// Verifing the title
		String actualTitle = ConfigurationReader.getProperty("title");

		String currentTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle);

	}
	
	/*
	 * method that HoverOver to profile and click to State, verify Url of State
	 */
	
	public void goToProfileToStateVerifyUrl() {
		
		HomePage hp=new HomePage();
		
		action.moveToElement(hp.profileMenu).build().perform();
		
		hp.profilesStateOption.click();
		
		String expectedUrl = ConfigurationReader.getProperty("urlState");

		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);
	}
	

}
