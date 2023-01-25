package steps;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APICodes {

	public void performCurrencyConversion(String amount,String convert,String symbol)
	{
	

		RestAssured.baseURI="https://pro-api.coinmarketcap.com/v2/tools/price-conversion";
		
        //We are taking the request of the Given API URL	
        RequestSpecification request = RestAssured.given();

        //Setting the Content of the Request in the form of JSON
        request.header("Content-Type", "application/json");
        request.header("X-CMC_PRO_API_KEY", "d2bae5cf-9437-40c1-b1a8-b602d85624e7");
        
        
        //Response response = request.queryParam("amount", amount).queryParam("convert",convert).queryParam("symbol",symbol).get();
        
        // adding the query params
        Response response = request.queryParam("amount", "10000000").queryParam("convert","GBP").queryParam("symbol","GTQ").get();
        
        // converting the response into json object
        JsonPath jsonResponse = response.jsonPath();
        
        // geting the price converted in GBP
        String newPrice = "" +Math.round(jsonResponse.get("data[0].quote.GBP.price"))+"";
        
        // printing the new price
        System.out.println(newPrice);
        
        // creating new request of the given API URL
        RequestSpecification newRequest = RestAssured.given();
        
        //Setting the Content of the Request in the form of JSON
        newRequest.header("Content-Type", "application/json");
        newRequest.header("X-CMC_PRO_API_KEY", "d2bae5cf-9437-40c1-b1a8-b602d85624e7");
        
        // adding the new price to query params and making API call
        Response newResponse = newRequest.queryParam("amount", newPrice).queryParam("convert","DOGE").queryParam("symbol","GBP").get();
        
        // Fetching the body of new response which have DO
        ResponseBody body = newResponse.getBody();

        //Converting the Response Body as String and Printing them
        System.out.println(body.asString());
        

        System.out.println(response.getStatusCode());
		
        
	}
}
