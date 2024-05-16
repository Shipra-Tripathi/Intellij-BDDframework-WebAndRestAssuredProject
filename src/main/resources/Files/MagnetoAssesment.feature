Feature: To Test online website
Scenario: To place a order online via website

  Given User should be able to open URL in browser
  When User should be able to select Men as a categeory and select jacket
  And User should be able to select size and color
  And User should be able to add product to basket
  And User should be able to proceed checkout process
  And User should be able to fill address details and proceed with next button
  And User should be able to place a order
  Then User should get sucess message and order details