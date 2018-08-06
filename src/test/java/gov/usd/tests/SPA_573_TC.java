package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_573_TC extends TestBase {



	@Test(priority = 19, description = "Home page Title verification, Profile State option,"
			+ " ascending and descending order of states")
	
	public void verifyHomePageTitle() {
		extentLogger = report.createTest("Home page Title verification, Profile State option,\"\n"
				+ " ascending and descending order of states");
		
		HomePage hp = new HomePage();
		ProfilesStatePage psp = new ProfilesStatePage();
		
		Assert.assertTrue(hp.goHomePageAndVerifyTitle());
		extentLogger.pass("Verified Home page Title");
		
		Assert.assertTrue(hp.goToProfileToStateVerifyUrl());
		extentLogger.pass("Verified Profile State option");

		List<String> actualStatesAssending = new ArrayList<>();
		List<String> expectedStatesAssending = new ArrayList<>();
		
		psp.states.stream().limit(5).forEach(x -> actualStatesAssending.add(x.getText()));
		psp.states.stream().limit(5).forEach(x -> expectedStatesAssending.add(x.getText()));
		Collections.sort(expectedStatesAssending);
		Assert.assertEquals(actualStatesAssending,expectedStatesAssending);
		extentLogger.pass("Verified ascending order of states");
		
		BrowserUtils.waitFor(2);
		psp.clickToGetDecendingStatesOrder.click();
		
		List<String> actualStatesAssending1 = new ArrayList<>();
		List<String> expectedStatesAssending1 = new ArrayList<>();
		psp.states.stream().limit(5).forEach(x -> actualStatesAssending1.add(x.getText().trim()));
		psp.states.stream().limit(5).forEach(x -> expectedStatesAssending1.add(x.getText().trim()));
		Collections.reverse(expectedStatesAssending1);
		Assert.assertEquals(expectedStatesAssending1, actualStatesAssending1);
		extentLogger.pass("Verified descending order of states");
		
	}}



