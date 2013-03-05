Feature: Getting directions to Ohio City Burrito

  As a hungry burrito lover
  I want to call OCB
  So that I can get a Brother's Burrito

	Scenario: Call button dials OCB
		Given I'm hungry for some OCB
		When I touch Call
		Then I see OCB phone number in dialer

	Scenario: Call button should be accessible from menu
		Given I touch the menu sign
		When I touch Call
		Then I see OCB phone number in dialer
