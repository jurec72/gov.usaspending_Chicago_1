package gov.usd.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;


public class SPA_504_TC extends TestBase{

	@Test(priority = 2, description = "Check the error message of the Home Page, click \"About\""
			+ " in the error message text, click Community button, close error message")
	public void homePageMessageTest() {
		
		extentLogger = report.createTest("Check Home Page message");
		
		HomePage hp = new HomePage();

		String titleText = hp.textOfTheMessage.getText();
		
		String expectedTitleText = "Welcome to the new USAspending.gov!\n" + 
				"We will continue to improve the data quality and display on a rolling basis. Questions? Check out our About page for important information on the data and authoritative sources or join the conversation on our Community page.";
		
		Assert.assertEquals(expectedTitleText, titleText);
		
		extentLogger.pass("Verified the error message of the Home Page");
		
		hp.clickAbout.click();
		
		String actualText = hp.Abouttext.getText();
		
		Assert.assertEquals(ConfigurationReader.getProperty("expectedAbout"), actualText);
		
		extentLogger.pass("Verified title of the About page");
		
		hp.clickCommunity.click();
		
		BrowserUtils.switchToWindow("Topics – USAspending");
		
		Assert.assertEquals(driver.getTitle(), "Topics – USAspending");
		
		extentLogger.pass("Verified Community button title");
	
		BrowserUtils.switchToWindow("USAspending.gov");
		
		BrowserUtils.waitFor(1);
		
		hp.clickXBtn.click();
		
		extentLogger.pass("Verified close button on warning message");
	}

}