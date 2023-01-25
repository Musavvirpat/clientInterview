@CompleteSuite
Feature: Coin Market UI Feature

  @FirstTestCase
  Scenario: Applying Filters on Crypto Currency App
  	Given User Launch the Coin Market App
  	When User Select the number of rows as "20"
  	Then User Click on Filters
  	And User Select the Algorithm as "PoW"
  	And User Select the Mineable Option
  	And User Select Coins from Crypto Currency
  	And User Select the Min Price as "100" and Max Price as "10000"
  	Then User Click On Applying Filters and Comparing Data
	