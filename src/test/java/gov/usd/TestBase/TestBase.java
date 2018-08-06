
package gov.usd.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import gov.usd.pages.HomePage;
import gov.usd.pages.SpendingExplorerPage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public abstract class TestBase {

	protected static WebDriver driver;

	protected static ExtentReports report;

	protected static ExtentHtmlReporter htmlReporter;

	protected static ExtentTest extentLogger;

	

	
	@BeforeTest(alwaysRun=true)
	public void setUpTest() {

		report = new ExtentReports();

		String filePath = System.getProperty("user.dir") + "/test-output/report.html";

		htmlReporter = new ExtentHtmlReporter(filePath);

		report.attachReporter(htmlReporter);

		report.setSystemInfo("ENV", "staging");

		report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));

		report.setSystemInfo("OS", System.getProperty("os.name"));

		htmlReporter.config().setReportName("USASPENDING.GOV");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		
		driver = Driver.getDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		driver.manage().window().fullscreen();
		
		driver.get(ConfigurationReader.getProperty("urlUSA"));

	}

	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws IOException {

		// checking if the test method failed

		if (result.getStatus() == ITestResult.FAILURE) {

			// get screenshot using the utility method and save the location of the

			// screenshot

			String screenshotLocation = BrowserUtils.getScreenshot(result.getName());

			// capture the name of test method
			extentLogger.fail(result.getName());

			// add the screenshot to the report
			extentLogger.addScreenCaptureFromPath(screenshotLocation);

			// capture the exception thrown
			extentLogger.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {

			extentLogger.skip("Test Case Skipped is " + result.getName());
		}
		Driver.closeDriver();

	}

	@AfterTest(alwaysRun=true)
	public void tearDownTest() {

		report.flush();
	}


}
