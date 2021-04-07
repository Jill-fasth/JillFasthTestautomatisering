
	Feature: Create a new account at mailchimp.com, 
	I want to create different scenarios at mailchimps by using different random user details.
	

   Scenario Outline: Creatating user account at mailchimp.com
    Given I have entered a <email>
    And A <username>
    And Finally I have entered a password
    When I click on the Sign-Up button
    Then I verify the <status> in step

    Examples: 
      | email 	| username 	 | status 			|
      | ranUser	| ranUser		 |"success" 			|
      | ranUser	| ranUser101 | "too long"  |
      | saved 	| saved 		 | "already in use"  |
      | empty	  | ranUser		 | "no email"  |
