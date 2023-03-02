Feature: Login
@Sanity 
  Scenario: succesfull  Login with valid Credentials
    Given User Launch Chrome  browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then page Title should be "Dashboard / nopcommerce administration"
    When user click on Log out link
    Then Page Title should be "Your store.Login"
    And close Browser

@Regression
  Scenario Outline: sucessfull login with valid and inavalid credentials  DDT
    Given User Launch Chrome  browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And user enters Email as "<email>" and password as "<password>"
    And click on Login
    Then page Title should be "Dashboard / nopcommerce administration"
    When user click on Log out link
    Then Page Title should be "Your store.Login"
    And close Browser
    Examples: 
      | email               |          |password|
      | admin@yourstore.com |          | admin |
      | admin@yoursore.com  |          | admin |
      | admin@yourstore.com |          | amin  |
      | admin@yourore.com   |          | adin  |
