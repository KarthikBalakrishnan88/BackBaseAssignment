Feature: Home Page
As an user 
In order to view the computer details in the computer database
I should be able to use the sample application

  Background: 
    Given I naviagte to the URL "http://computer-database.herokuapp.com"
     Then I should be able to see the sample application
  
  Scenario: Verify that the home page should display the total number of computers found in the database
    Given I am on the home page
     Then I should be able to see the total number of computers
  
  Scenario: Verify that the home page should have a text box to enter the computer name to search
    Given I am on the home page
     Then I should be able to see a textbox to enter the search criteria
      And the text box should have default text as "Filter by computer name.."
  
  Scenario: Verify that the home page should have a button to trigger the search
    Given I am on the home page
     Then I should be able to see a button with caption as "Filter by name"
      And the Button color should have the back color as "#0064cd"
  
  @Regression
  Scenario: Verify that the home page should have a button to add a new computer
    Given I am on the home page
     Then I should be able to see a button with caption as "Add a new computer"
      And the Button color should have the back color as "rgba(87, 169, 87, 1)" 
  
  @Regression
  
  Scenario: Verify that the home page should display the list of computers and details
  #For this scenarios make sure there is atleast three computer items already added in the system
    Given I am on the home page
     Then I should be able to see the results in the screen
      And the computer detail table should have the below columns
      | Column1       | Column2    | Column3      | Column4 | 
      | Computer name | Introduced | Discontinued | Company | 
  
  Scenario: Verify that the search results table should have navigatin buttons to move Next and Previous
  #For this scenarios make sure there is atleast 11 computer items already added in the system
    Given I am on the home page
     Then I should be able to see a table with computer details
      And the "Next" link should be visible
      And the "Previous" link should be visible