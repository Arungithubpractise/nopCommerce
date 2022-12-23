Feature: Customers 

@sanity
Scenario: Add a new Customer 
    Given User Launch Chrome browser
    When User opens the URL "http://admin-demo.nopcommerce.com/login"
	And User enters the Email as "admin@yourstore.com" and password as "admin" 
	And Click on Login 
    Then Page Title should be "Dashboard / nopCommerce administration"
	Then User can view Dashboad 
	When User click on customers Menu 
	And click on customers Menu Item 
	And click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And click on Save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	And Close the browser
	
 
	