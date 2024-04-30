Feature:To test swag website

Scenario: Validate username and Password
  Given User able to open URL on chrome
  When User able to login with valid credentials
  And User should be Navigated to Dashboard page
  And Select the product and Add to the Cart
  And User should be able to proceed with checkout
  And User should be able to see payment information with payment order number
  Then User should get success message by clicking on finish button


