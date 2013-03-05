Feature: Getting directions to Ohio City Burrito

  As a hungry burrito lover
  I want to drive to OCB
  So that I can get a Brother's Burrito

	Scenario: Directions button should take us to Google Maps
		Given I'm hungry for some OCB
		When I touch Directions
		Then Google maps should provide me with directions

	Scenario: Directions button should be accessible from menu 
		Given I touch the menu sign
		When I touch Directions
		Then Google maps should provide me with directions
