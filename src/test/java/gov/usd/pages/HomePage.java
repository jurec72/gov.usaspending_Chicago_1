package gov.usd.pages;

import java.util.ArrayList;
import java.util.List;

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

	@FindBy(xpath = "//ul[@class='nav-children__list']/li/a[.='Federal Accounts']")
	public WebElement profilesFederalAccountsOption;

	@FindBy(xpath = "//div[@id='logo']/a")
	public WebElement logo;

	@FindBy(xpath = "//ul[@class='full-menu__list']")
	public WebElement mainMenu;
	

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/div/ul/li[1]/a")
	public WebElement agencies;

	@FindBy(xpath = "//div[@class='info-banner__alert-text']")
	public WebElement textOfTheMessage;
	
	@FindBy(xpath = "//div[@class='info-banner__title-text']/../a[1]")
	public WebElement clickAbout;
	
	@FindBy(xpath = "//div[@class='info-banner__title-text']/../a[2]")
	public WebElement clickCommunity;
	
	@FindBy(xpath = "//button[@class='info-banner__close-button']")
	public WebElement clickXBtn;

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
