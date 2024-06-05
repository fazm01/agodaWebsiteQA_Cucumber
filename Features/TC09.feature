Feature: Searching and Booking Private Stays

Scenario: Successful Search And Booking Hotel
	Given User is on Home Page
	When User Searches for a hotel
	And User chooses a hotel
	And User adds room to cart
	Then cart displays added room sucessfully

