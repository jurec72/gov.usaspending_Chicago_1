package gov.usd.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;


public class SPA_504_TC extends TestBase{

	
	HomePage hp = new HomePage();
	

	@Test(priority = 1, description = "going to the URL")
	public void goingToUrl() {
		
		extentLogger = report.createTest("4");
		
		driver.get(ConfigurationReader.getProperty("urlUSA"));
		
		extentLogger.pass("44");
		
	}
	
	@Test(priority = 2, description = "Verifying the title of the text")
	public void titleText() {
		
		extentLogger = report.createTest("5");
		
		String titleText = hp.textOfTheMessage.getText();
		
		String expectedTitleText = "Welcome to the new USAspending.gov!\n" + 
				"We will continue to improve the data quality and display on a rolling basis. Questions? Check out our About page for important information on the data and authoritative sources or join the conversation on our Community page.";
		Assert.assertEquals(expectedTitleText, titleText);
		
		extentLogger.pass("55");
	}
	
	@Test(priority = 3, description = "click About in the title text and verify if it is functioning")
	public void clickAbout() {
		
		extentLogger = report.createTest("6");
		
		hp.clickAbout.click();
		
		String actualText = hp.Abouttext.getText();
		
		Assert.assertEquals(ConfigurationReader.getProperty("expectedAbout"), actualText);
		
		extentLogger.pass("66");
	
	}
	
	@Test(priority = 4 , description = "click Community in the title text")
	public void clickCommunity() {
		
		extentLogger = report.createTest("7");
		
		hp.clickCommunity.click();
		
		BrowserUtils.switchToWindow("Topics – USAspending");
		
		Assert.assertEquals(driver.getTitle(), "Topics – USAspending");
		
		extentLogger.pass("77");
		
	}
	
	@Test(priority = 5 , description = "click X on the right side of the title text")
	public void clickXBtn() {
		
		extentLogger = report.createTest("8");
	
		BrowserUtils.switchToWindow("USAspending.gov");
		
		BrowserUtils.waitFor(1);
		
		hp.clickXBtn.click();
		
		extentLogger.pass("88");
	}

}