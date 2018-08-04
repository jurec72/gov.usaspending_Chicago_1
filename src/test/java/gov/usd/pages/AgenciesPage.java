package gov.usd.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.Driver;

public class AgenciesPage {

	private WebDriver driver;

	public AgenciesPage() {

		driver = Driver.getDriver();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"agency-landing-results\"]/div/div/table/thead/tr/td[3]/div/div/div/div[2]/button[2]")
	public WebElement potDownBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Sort table by descending Percent of Total')]/..")
	public WebElement agenciesDescending;

	@FindBy(xpath = "//div[@class='generic-cell column-percentage_of_total_budget_authority']/div")
	public List<WebElement> agenciesPercentOfTotalList;

	@FindBy(xpath = "//*[contains(text(),'Sort table by ascending Percent of Total')]/..")
	public WebElement agenciesAscending;

	@FindBy(xpath = "(//*[contains(text(),'Budgetary Resources')]/..)[2]")
	public WebElement agenciesBudgetaryResourcesClick;

	@FindBy(xpath = "//div[@class='generic-cell column-budget_authority_amount']/div")
	public List<WebElement> agenciesBudgetaryResourcesList;

	@FindBy(xpath = "(//*[contains(text(),'Sort table by ascending Agency Name')]/..)")
	public WebElement agenciesAgencyNameClick;

	@FindBy(xpath = "//div[@class='agency-link-cell column-agency_name']/div")
	public List<WebElement> agenciesAgencyNameList;
	
	@FindBy(xpath = "//h2[@class='landing-page__title']")
	public WebElement agenciesTitle;

	
/*
 * this method converted String to Double
 */
	public List<Double> convertingToDouble(List<WebElement> locaters) {

		List<Double> prices = new ArrayList<>();

		for (WebElement price : locaters) {

			String priceStr = price.getText().replace("Less than", "").replace("%", "").replace("$", "")
					.replace(",", "").trim();

			prices.add(Double.valueOf(priceStr));
		}
		return prices;
	}
	/*
	 * this method returns List of String 
	 */

	public List<String> convertingToString(List<WebElement> locaters) {

		List<String> prices = new ArrayList<>();

		for (WebElement price : locaters) {

			String string = price.getText().trim();
			prices.add(string);
		}
		return prices;

	}
}

