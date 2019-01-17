@Sanity
Feature: Login to SageOne website.
	As a SageOne user
	I am able to login the SageOne website
	So that user can access the record
	and then log out of the account

Background: 
	Given I am on the login page

Scenario: Login with valid credentials
	And enter the credentials as
	|Email 						 | Password |
	|rstraavaldson@mailinator.com| P@55w0rd |
	And click on Login button
	Then the page heading will be "Hi, Robert"