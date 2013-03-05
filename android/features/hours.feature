Feature: Getting the hours of Ohio City Burrito

  As a hungry burrito lover
  I want to know when OCB is open
  So I can plan my burrito consumption activities

	Scenario: The hours should be displayed 
		Given I want to connect with Ohio City Burrito
		Then I should see "Hours:"
		And I should see "Mon - Thu : 11 - 8"
		Then I should see "Fri - Sat : 11 - 9"


		
