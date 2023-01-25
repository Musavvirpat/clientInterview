package steps;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Reusable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CoinMarketPages;

public class CoinMarketSteps extends Reusable {

	CoinMarketPages coinMarketPages=new CoinMarketPages();
	
	List<String> cryptoNames=null;
	List<String> priceNames=null;
	
	List<WebElement> cryptoNames_New=null;
	List<WebElement> priceNames_New=null;
	
	@Given("User Launch the Coin Market App")
	public void launch_the_coin_market_app() 
	{
		driver.get("https://coinmarketcap.com/");
		
	}
	

	@When("User Select the number of rows as {string}")
	public void select_the_number_of_rows_as(String noOfRows) throws Exception 
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
		
		coinMarketPages.clickOnShowRows();

		coinMarketPages.selectNoOfRows(noOfRows);	
		coinMarketPages.clickOnCloseBanners();

		
		cryptoNames = driver.findElements(By.xpath("//table/descendant::tbody/tr/td[3]"))   
                .stream()
                .map(WebElement::getText)       
                .map(String::trim)               
                .collect(Collectors.toList());   

		priceNames = driver.findElements(By.xpath("//table/descendant::tbody/tr/td[4]"))   
                .stream()
                .map(WebElement::getText)       
                .map(String::trim)               
                .collect(Collectors.toList());   
		
	}

	@Then("User Click on Filters")
	public void click_on_filters() throws Exception
	{
		

		coinMarketPages.clickOnFilters();
	}

	@And("User Select the Algorithm as {string}")
	public void select_the_algorithm_as(String algorithmName) throws Exception 
	{
		coinMarketPages.clickOnAlgorithm();
		
		coinMarketPages.selectAlgorithm(algorithmName);
	}

	@And("User Select the Mineable Option")
	public void select_the_mineable_option() throws Exception 
	{
		coinMarketPages.clickOnMineable();
	}

	@And("User Select Coins from Crypto Currency")
	public void select_coins_from_crypto_currency() throws Exception 
	{
		coinMarketPages.clickOnCoins();
	}

	@And("User Select the Min Price as {string} and Max Price as {string}")
	public void select_the_min_price_as_and_max_price_as(String minPrice, String maxPrice) throws Exception 
	{
		coinMarketPages.enterMinAndMaxRanges(minPrice, maxPrice);
	}

	@Then("User Click On Applying Filters and Comparing Data")
	public void click_on_apply_filters() throws Exception 
	{
		coinMarketPages.clickOnShowResults();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/descendant::tbody/tr/td[3]")));
		
		cryptoNames_New = driver.findElements(By.xpath("//table/descendant::tbody/tr/td[3]"));
                   

		priceNames_New = driver.findElements(By.xpath("//table/descendant::tbody/tr/td[4]"));
		
		if(!cryptoNames_New.toString().equals(cryptoNames))
		{
			
		}
		
		else
			throw new Exception("Data is same for Crypto names even after changing filters");
		
		if(!priceNames_New.toString().equals(priceNames))
		{
			
		}
		
		else
			throw new Exception("Data is same for prices even after changing filters");
			
		
	}
}
