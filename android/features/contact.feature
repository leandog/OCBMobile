Feature: Contacting & connecting with Ohio City Burrito

  As a hungry burrito lover
  I want to connect with Ohio City Burrito
  So that I'm informed about anything new and exciting they're doing

	Scenario: The contact information should be available in a dropdown
		Given I want to connect with Ohio City Burrito
		When I touch the connect dropdown
		Then I should see "Like Us!"
		Then I should see "Follow Us!"
		Then I should see "Email Us!"


		
