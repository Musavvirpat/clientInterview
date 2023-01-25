# clientInterview

Assignment details :-

Part One:

1.go to https:coinmarketcap.com

2.show rows by 20

3.capture all page contents- will decide what is the correct information to capture, suggestions e.g.price,name,position.

4.filter by Algorith-"PoW"

5.followed by "+Add Filter"

6.toggle "Mineable"

7.then select "All Cryptocurrencies"

8.select "coins"

9.then select price and set minimum value to 100 maximum to 10,000

10.compare page content in step 3

Part Two: 

Reading documentation and making API calls 


.register for free account -
  https://coinmarketcap.com/api/documentation/v1/#section/Introduction,
  
.convert "10000000" Guatemalan Quetzal to British pounds

.convert the amount received in GBP to Doge coin

Approach Used For Automation:-

BDD Cucumber Framework is used.

In this framework feature file present in src/test/resources/features.
 
step defination file will be placed in src/test/java/steps.

STEPS TO EXECUTE THE SCRIPT :-

Open CoinMarketUI File from src/test/java

After Opening the File,

Go to runner/test runner file 

then click on Run as TestNG Test

Then the Code will be executed .
