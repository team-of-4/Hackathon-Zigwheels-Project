Feature: Used Car Models

	Scenario: Used Car Models Page
		Given User is on upcoming honda
		When User Scroll up
		And hover on used cars
		And click on chennai
		Then Directed to used cars in chennai
		And extract new car models to excel
		And going back to home page
