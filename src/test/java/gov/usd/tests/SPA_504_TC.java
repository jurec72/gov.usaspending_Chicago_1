package gov.usd.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;


public class SPA_504_TC extends TestBase{

	
	HomePage hp = new HomePage();
	

	@Test(priority = 1, description = "going to the URL")
	public void goingToUrl() {
		
		driver.get(ConfigurationReader.getProperty("urlUSA"));
		
	}
	@Test(priority = 2, description = "Verifying the title of the text")
	public void titleText() {
		String titleText = hp.textOfTheMessage.getText();
		String expectedTitleText = "Welcome to the new USAspending.gov!\n" + 
				"We will continue to improve the data quality and display on a rolling basis. Questions? Check out our About page for important information on the data and authoritative sources or join the conversation on our Community page.";
		System.out.println("printed title = "+titleText);
		Assert.assertEquals(expectedTitleText, titleText);
	}
	@Test(priority = 3, description = "click About in the title text")
	public void clickAbout() {
		hp.clickAbout.click();
	}
	@Test(priority = 4 , description = "click About in the title text")
	public void clickCommunity() {
		BrowserUtils.waitFor(1);
		hp.clickCommunity.click();
	}
	@Test(priority = 5 , description = "click X on the right side of the title text")
	public void clickXBtn() {
		BrowserUtils.waitFor(1);
		hp.clickXBtn.click();
	}

}