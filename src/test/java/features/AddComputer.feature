Feature: Add Computer
As an user 
In order to add a computer details in the computer database
I should be able to use the sample application

  Background: 
    Given I naviagte to the URL "http://computer-database.herokuapp.com"
     When I click on Add a new computer button
     Then I am on the "Add a computer" page
  
  Scenario: Verify that the Add Computer page should have all fields as per the specification
    Given I am on the "Add a computer" page
     Then I should be able to see the fields as per the below specification
      | Field Name           | Input Type | Remarks             | 
      | Computer name        | text       | Required            | 
      | Introduced date      | text       | Date ('yyyy-MM-dd') | 
      | Discontinued date    | text       | Date ('yyyy-MM-dd') | 
      | Company              | text       |                     | 
      | Create this computer | button     |                     | 
      | Cancel               | link       |                     | 
  
  @Regression
  Scenario Outline: Verify that I should be able to add a computer with valid data
    Given I am on the "Add a computer" page 
     When I enter computer name as "<Computer_name>"
      And I enter Introduced date as "<Introduced_date>"
      And I enter Discontinued date as "<Discontinued_date>"
      And I select Company as "<Company>"
      And I click on "Create this computer" button
     Then I should see a notification with the added "<Computer_name>"
  
    Examples: 
      | Computer_name | Introduced_date | Discontinued_date | Company | 
      | Random_name   |                 |                   |         | 
      | Random_name   | 2017-12-21      | 2018-12-21        | IBM     | 
      | Random_name   |                 | 2018-12-21        | RCA     | 
      | Random_name   | 2017-12-21      |                   | Nokia   | 
      | Random_name   |                 |                   | Sony    | 
      | Random_name   | 2017-12-21      | 2018-12-21        |         | 
  
  @Regression
  Scenario Outline: Verify that I should not be allowed to add a computer with invalid data
    Given I am on the "Add a computer" page 
     When I enter computer name as "<Computer_name>"
      And I enter Introduced date as "<Introduced_date>"
      And I enter Discontinued date as "<Discontinued_date>"
      And I select Company as "<Company>"
      And I click on "Create this computer" button
     Then I should see "<Error_Field>" highlighted in the screen
  
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
    Given I am on the "Add a computer" page
     When computer name as "Sample_Computer" 
      And I click on Cancel
     Then I should be navigated back to home screen
      And I should not see then notification with the added Computer name