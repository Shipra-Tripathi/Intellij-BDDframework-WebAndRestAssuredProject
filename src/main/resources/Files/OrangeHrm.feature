Feature:To test Orange hrm
  Scenario:Login with valid credentials

  Given User opens orange hrm website on chrome
  When User enter valid username and password
  And User able to clear Username and password
  And User able to Re-enter username and password
  And User able to validate username and password text box present login page
  And User able to validate Tile of login page
  And User click on login button and validate login button is enabled
  Then User should be able to Navigated to Dashboard page
