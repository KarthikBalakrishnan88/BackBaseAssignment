Feature: Edit Computer
As an user 
In order to Edit a computer details in the computer database
I should be able to use the sample application

#Precondition - The system should have aleast one exisiting item
  Background: 
    Given I naviagte to the URL "http://computer-database.herokuapp.com"
     When I click on a computer name "ASUS" from the list
     Then I am on the "Edit computer" page
  
  Scenario: Verify that the Edit Computer page should have all fields as per the specification 
    Given I am on the "Edit computer" page
     Then I should be able to see the fields as per the below specification
      | Field Name           | Input Type | Remarks             | 
      | Computer name        | text       | Required            | 
      | Introduced date      | text       | Date ('yyyy-MM-dd') | 
      | Discontinued date    | text       | Date ('yyyy-MM-dd') | 
      | Company              | text       |                     | 
      | Save this computer   | button     |                     | 
      | Cancel               | link       |                     | 
      | Delete this computer | button     |                     | 
  
  @Regression
  Scenario: Verify that user should be able to update the computer name with valid data
    Given I am on the "Edit computer" page 
     When I edit computer name as "Random_name"
      And I click on Save this computer button
     Then I should see a notification with the edited "Random_name"
  
  Scenario: Verify that user should be able to update the Introduced date with with valid data
    Given I am on the "Edit computer" page 
     When I edit the Introduced date as "2017-12-12"
      And I click on Save this computer button
     Then I should see a notification with the edited "Random_name"
  
  Scenario: Verify that user should be able to update the Discontinued date with valid data
    Given I am on the "Edit computer" page 
     When I edit the Discontinued date as "2017-05-04"
      And I click on Save this computer button
     Then I should see a notification with the edited "Random_name"
  
  Scenario: Verify that user should be able to update the company name with valid data
    Given I am on the "Edit computer" page 
     When I select Company as "some Company"
      And I click on Save this computer button
     Then I should see a notification with the edited "Random_name"
  
  Scenario Outline: Verify when invalid data is entered system highlight the errors
    Given I am on the "Edit computer" page 
     When I enter computer name as "<Computer_name>"
      And I enter Introduced date as "<Introduced_date>"
      And I enter Discontinued date as "<Discontinued_date>"
      And I select Company as "<Company>"
      And I click on Save this computer button
     Then I should not be able to update the computer details
      And I should see "<Error_Field>" highlighted in the screen
  
    Examples: 
      | Computer_name | Introduced_date | Discontinued_date | Company | Error_Field       | 
      |               |                 |                   |         | Computer_name     | 
      | Random_name   | 12-12-1988      | 2018-12-21        | IBM     | Introduced_date   | 
      | Random_name   | 25-12-1988      | 2018-12-21        | RCA     | Introduced_date   | 
      | Random_name   | 88-12-12        |                   | Sony    | Introduced_date   | 
      | Random_name   |                 | 12-12-1988        | Nokia   | Discontinued_date | 
      | Random_name   | 2017-12-21      | 25-12-1988        |         | Discontinued_date | 
      | Random_name   | 2017-12-21      | 88-21-12          |         | Discontinued_date | 
  
  Scenario: Verify that the cancel button on the screen
    Given I am on the "Edit computer" page 
     When I enter the computer name as "New_Computer_Name" 
      And I click on Cancel
     Then I should be navigated back to home screen
      And I should not see then notification with the edited Computer name
  
  @Regression
  Scenario: Verify that user can delete a computer
    Given I am on the "Edit computer" page 
     When I click on Delete this computer button
     Then I should see a notification "Done! Computer has been deleted"