Feature: Add discount

@regression
Scenario: Adding a new discount
    Given User Launch Chrome browser 
    When User opens the URL "http://admin-demo.nopcommerce.com/login"
	And User enters the Email as "admin@yourstore.com" and password as "admin" 
    And Click on Login 
    Then Page Title should be "Dashboard / nopCommerce administration"
    When user clicks on Promotions
    And user clicks on Discounts
    And user clicks on Add new button
    Then Add a new discount page should be displayed
    When user enter Discount info
    When user enter Discount type 
    And click on save button
    Then The new discount has been added successfully message should be displayed
    And Close the browser
    
    
     

