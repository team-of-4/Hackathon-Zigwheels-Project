Feature: ZigWheels
	
	@start
	Scenario: ZigWheels Page
		Given User navigate to zigwheels page
		When User gets the current url
		Then Verify directed to zigwheels page

	Scenario: Upcoming Page
		Given User is on zigwheels page
		When User hover on new bikes
		And clicks on upcoming bikes
		And capturing current url
		Then Verify directed to upcoming page
	
  