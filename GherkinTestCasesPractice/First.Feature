#BACKTRACK
Scenario : Add to basket
Given the user is on the product "chair"
when  the user clicks on teh add to basket button
then the product should be in the basket

Scenario: Go to payment options
Given product "chair" is in the shopping basket
When the uer clicks on go to payment
Then the payment page shoud display

Scenario : Submit payment options
Given the uere is on the paymnet page with product "chair"
When the user submits valid payment information 
Then the "Thank you  for oredering" massage should display

# The Plan
Given I am on the HomePage
When I click on Search 
And  I search for "chair"
And I click on add to basket
And I click on payment options
And I select "iDeal"
And I click on complete payment
And I click on Confirm payment
Then I should see "Thank you for ordering"


