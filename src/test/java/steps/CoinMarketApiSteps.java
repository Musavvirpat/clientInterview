package steps;

import framework.Reusable;
import io.cucumber.java.en.Given;

public class CoinMarketApiSteps extends Reusable {

	@Given("Perform Currency Conversion for the Amount {string} from {string} to {string}")
	public void perform_currency_conversion_for_the_amount_from_to(String amount, String convert, String symbol) 
	{
		new APICodes().performCurrencyConversion(amount, convert, symbol);
	}
}
