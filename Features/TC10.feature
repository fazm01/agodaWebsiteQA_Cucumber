Feature: Book Two Hotels

Scenario: Successful Direction to reservation page of the Two Hotels
	Given User is on Home Page
	When User Searches for a hotel
	And User Adds another hotel
	And User Chooses both hotels
	Then Reservation of Two Hotels displayed sucessfully


