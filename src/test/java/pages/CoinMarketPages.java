package pages;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import dev.failsafe.internal.util.Durations;
import framework.Reusable;

public class CoinMarketPages extends Reusable {
	

	private WebElement ddl_ShowRows()
	{
		return driver.findElement(By.xpath("//p[text()='Show rows']/following-sibling::div"));
	}
	
	private WebElement option_SelectRows(String noOfRows)
	{
		return driver.findElement(By.xpath("//div[@class='tippy-content']/descendant::div/descendant::button[text()='"+noOfRows+"']"));
	}
	
	private WebElement btn_CloseBanners()
	{
		return driver.findElement(By.xpath("//div[@id='cmc-cookie-policy-banner']/descendant::div[2]"));
	}
	
	private WebElement btn_Filters()
	{
		return driver.findElement(By.xpath("//div[@class='scroll-child']/descendant::button[text()='Filters']"));
	}
	
	private WebElement btn_Algorithm()
	{
		return driver.findElement(By.xpath("//button[text()='Algorithm']"));
	}
	
	private WebElement option_SelectAlgorithm(String algorithmName)
	{
		return driver.findElement(By.xpath("//li[text()='"+algorithmName+"']"));
	}
	
	private WebElement btn_FiltersIcon()
	{
		return driver.findElement(By.xpath("//li[@class='filter']/following-sibling::li[4]"));
	}
	
	private WebElement ddl_Mineable()
	{
		return driver.findElement(By.xpath("//label[@for='mineable']"));
	}
	
	private WebElement btn_CryptoCurrencies()
	{
		return driver.findElement(By.xpath("//button[text()='All Cryptocurrencies']"));
	}
	
	private WebElement ddl_Coins()
	{
		return driver.findElement(By.xpath("//button[text()='Coins']"));
	}
	
	private WebElement btn_ApplyFilter()
	{
		return driver.findElement(By.xpath("//button[text()='Apply Filter']"));
	}
	
	private WebElement btn_ShowResults()
	{
		return driver.findElement(By.xpath("//button[text()='Show results']"));
	}
	
	private WebElement btn_Price()
	{
		return driver.findElement(By.xpath("//button[text()='Price']"));
	}
	
	private WebElement txt_MinRange()
	{
		return driver.findElement(By.xpath("//input[@data-qa-id='range-filter-input-min']"));
	}
	
	private WebElement txt_MaxRange()
	{
		return driver.findElement(By.xpath("//input[@data-qa-id='range-filter-input-max']"));
	}
	
	private void explicit_Wait(String xPath)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	
	}
	
	/*************************************************************************************************************************************************/
	
	public void clickOnShowRows() throws Exception
	{
		explicit_Wait("//p[text()='Show rows']/following-sibling::div");
		ddl_ShowRows().click();
	}
	
	public void selectNoOfRows(String noOfRows) throws Exception
	{
		String xPath = "//div[@class='tippy-content\']/descendant::div/descendant::button[text()='"+noOfRows+"']";
		explicit_Wait(xPath);
		option_SelectRows(noOfRows).click();
	}
	
	public void clickOnCloseBanners() throws Exception
	{
		explicit_Wait("//div[@id='cmc-cookie-policy-banner']/descendant::div[2]");
		btn_CloseBanners().click();
		
		if(driver.findElements(By.xpath("//div/descendant::*[@fill='currentColor' and contains(@class,'close')]")).size()!=0) {
		explicit_Wait("//div/descendant::*[@fill='currentColor' and contains(@class,'close')]");
		driver.findElement(By.xpath("//div/descendant::*[@fill='currentColor' and contains(@class,'close')]")).click();
		}
		
		
		explicit_Wait("//span[text()='Maybe later']");
		driver.findElement(By.xpath("//span[text()='Maybe later']")).click();
		
	}
	
	public void clickOnFilters() throws Exception
	{
		explicit_Wait("//div[@class='scroll-child']/descendant::button[text()='Filters']");
		btn_Filters().click();
	}
	
	public void clickOnAlgorithm() throws Exception
	{
		
		explicit_Wait("//button[text()='Algorithm']");
		btn_Algorithm().click();


	}
	
	public void selectAlgorithm(String algorithmName) throws Exception
	{
		
		String xPath = "//li[text()='"+algorithmName+"']";
		explicit_Wait(xPath);
		option_SelectAlgorithm(algorithmName).click();

	}
	
	public void clickOnMineable() throws Exception
	{
		explicit_Wait("//li[@class='filter']/following-sibling::li[4]");
		btn_FiltersIcon().click();
	
		explicit_Wait("//label[@for='mineable']");
		ddl_Mineable().click();
	
	}
	
	public void clickOnCoins() throws Exception
	{
		
		explicit_Wait("//button[text()='All Cryptocurrencies']");
		btn_CryptoCurrencies().click();
	
		
		explicit_Wait("//button[text()='Coins']");
		ddl_Coins().click();
	
	}
	
	public void clickOnShowResults() throws Exception
	{
		explicit_Wait("//button[text()='Apply Filter']");
		
		btn_ApplyFilter().click();
		
		
		
		explicit_Wait("//button[text()='Show results']");
		
		btn_ShowResults().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	public void enterMinAndMaxRanges(String minRange,String maxRange) throws InterruptedException
	{
		
		explicit_Wait("//button[text()='Price']");
		btn_Price().click();
	
		
		String xPath = "//input[@data-qa-id='range-filter-input-min']";
		explicit_Wait(xPath);
		
		txt_MinRange().sendKeys(minRange);
	
		
		String xPath1 = "//input[@data-qa-id='range-filter-input-max']";
		
		txt_MaxRange().sendKeys(maxRange);
		
	}
}
