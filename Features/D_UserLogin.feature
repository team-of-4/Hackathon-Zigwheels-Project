Feature: User Login
  
  Scenario: Login Page
  	Given User is on home page
  	When Login button is displayed
  	Then click on login button and goggle sigin button
 
 	@end
 	Scenario: Google Sign Page
 		Given User is google sign page
 		When User gets title of page
 		Then Verify the page title
 		And entering wrong email id and capturing error message
 		And closing the all windows