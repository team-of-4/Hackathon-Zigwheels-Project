Feature: Upcoming Bikes

	Scenario: Selecting Honda 
		Given User is on upcoming bikes page
		When User selects honda 
		And getting current url
		Then Verify directed to honda upcoming bikes
		
		
	Scenario: Check Bike Details and extract bikes under 4 lac
		Given User is on honda upcoming page
		When User click on view more
		Then Verify bike names
		And verify bike prices
		And verify bike release dates
		And extract bikes under 4 lac to excel
		
	