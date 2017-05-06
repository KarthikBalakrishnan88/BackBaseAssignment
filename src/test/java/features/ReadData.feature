Feature: Read Data from Database
As an user 
In order to search and view the computer details in the computer database
I should be able to use the sample application

  Background: 
    Given I naviagte to the URL "http://computer-database.herokuapp.com"
     Then I should be able to see the sample application
  
  @Regression
  Scenario Outline: Verify when I enter a search criteria
    Given I am on the home page
     When I enter the search criteria as <Computer_Name>
      And I click on Filter by name button 
     Then I should be able to see the results in the screen
  
    Examples: 
      | Computer_Name | 
      | ASUS          | 
      | Space         | 
      | .             | 
      | @             | 
  
  @Regression
  Scenario: Verify when I enter no search criteria
    Given I am on the home page
     When I click on Filter by name button 
     Then I should be able to see the results in the screen
  
  @Regression
  Scenario: Verify when I enter wild card character % in search criteria
    Given I am on the home page
     When I enter the search criteria as %
      And I click on Filter by name button 
     Then I should be able to see the results in the screen
  
  @Regression
  Scenario: Verify that I should be able to read the newly added computer data 
    Given I am on the home page
      And I click on Add a new computer button
      And I enter computer details
      | Computer_Name | Introduced_Date | Discontinued_Date | Company | 
      | Karthik_PC    | 2012-12-12      |                   | IBM     | 
      And I click on Create this computer button
     When I enter the search criteria as Karthik_PC 
      And I click on Filter by name button 
     Then I should see the results
      | Computer_Name | Introduced_Date | Discontinued_Date | Company | 
      | Karthik_PC    | 12 Dec 2012     | -                 | IBM     | 
  
  @Regression
  Scenario: Verify that I should be able to read the updated computer data 
    Given I am on the home page
      And I enter the search criteria as Karthik_PC
      And I click on Filter by name button
      And I click on a computer "Karthik_PC" from the list 
      And I Update computer details
      | Computer_Name | Introduced_Date | Discontinued_Date | Company | 
      | Roel_PC       | 2012-01-12      | 2017-05-05        | Sony    | 
      And I click on save this computer  button
     When I enter the search criteria as Roel_PC 
      And I click on Filter by name button
     Then I should see the results
      | Computer_Name | Introduced_Date | Discontinued_Date | Company | 
      | Roel_PC       | 12 Jan 2012     | 05 May 2017       | Sony    | 
  
  @Regression
  Scenario: Verify that system should throw an error when I search for an removed computer data 
    Given I am on the home page
      And I enter the search criteria as Roel_PC
      And I click on Filter by name button
      And I click on a computer "Roel_PC" from the list 
      And I click on Delete this computer button
     When I enter the search criteria as Roel_PC 
      And I click on Filter by name button
     Then I should not see computer details in the results
      | Computer_Name | Introduced_Date | Discontinued_Date | Company | 
      | Roel_PC       | 12 Jan 2012     | 05 May 2017       | Sony    | 