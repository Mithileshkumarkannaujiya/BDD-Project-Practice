Feature: AddNewCustomer
Background:
Given User Launch Chrome  browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then user  can view Dashboard
    When user click on customer menu
    And click on customer
  
  @Sanity
  Scenario: succesfull  Login with valid Credentials
    And click on Add New Button
    Then user can view Add New Cutomer Page
    When user enter Customer info
    And click on save Button
    Then user can view confirmation Page "The new customer has been addded successfully."
    And close Browser

  @Regression 
  Scenario: Search By Email ID
      And Enter customer Email
    And click on search button
    Then user shoud found Email in the Search table
    And close Browser

  @Sanity   @Regression  
  Scenario: Search customer  By Name
    And Enter customer Name
    And click on search button
    Then user shoud found Email in the Search table
    And close Browser