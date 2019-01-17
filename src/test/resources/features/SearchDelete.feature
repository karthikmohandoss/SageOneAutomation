@SageTask
Feature: Search & Delete Customer and Supplier Contact Types
	As a SageOne user
	I am able to saerch and delte Contact Types
	
Background:
	Given I am on the login page
	And enter the credentials as
	|Email 						 | Password |
	|rstraavaldson@mailinator.com| P@55w0rd |
	And click on Login button

Scenario: To check new Customer created successfully
	And click on Create Customer link
	And user search for Business Name "Test Customer Name"
	Then record count should be displayed as "0 of 1 selected"
	
Scenario: Delete the Customer
	And click on Create Customer link
	And user search for Business Name "Test Customer Name"
	And user select the record to delete
	And user clicks on the Delete button
	And user clicks Yes botton on the confirmation window for "Customer"
    Then "Delete" message "Deleted Customer Successfully" should be displayed

Scenario: To check the Customer deleted Successfully
	And click on Create Customer link
	And user search for Business Name "Test Customer Name"
	Then record count should be displayed as "0 of 0 selected"
	
Scenario: To check new Supplier created successfully
	And click on Create Supplier link
	And user search for Business Name "Test Supplier Name"
	Then record count should be displayed as "0 of 1 selected"
	
Scenario: Delete the Supplier
	And click on Create Supplier link
	And user search for Business Name "Test Supplier Name"
	And user select the record to delete
	And user clicks on the Delete button
	And user clicks Yes botton on the confirmation window for "Supplier"
    Then "Delete" message "Deleted Customer Successfully" should be displayed

Scenario: To check the Supplier deleted Successfully
	And click on Create Supplier link
	And user search for Business Name "Test Supplier Name"
	Then record count should be displayed as "0 of 0 selected"