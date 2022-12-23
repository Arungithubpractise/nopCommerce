Feature: checkingorders

@regression
Scenario: Checking the orders of a a customer
    Given User Launch Chrome browser 
	When User opens the URL "http://admin-demo.nopcommerce.com/login" 
	And User enters the Email as "admin@yourstore.com" and password as "admin"   
	And Click on Login 
	Then Page Title should be be displayed as "Dashboard / nopCommerce administration" 
	And Click on sales and orders 
	Then Page Title should be be displayed  "Orders / nopCommerce administration"
	When User user enters order details
	And Click on search
	Then orders detail should be displayed below
	And Close the browser
		
    