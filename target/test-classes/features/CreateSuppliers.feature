@SageTask
Feature: Create Supplier Contact Types
	As a SageOne user
	I am able to Create new Supplier Contact Types
	
Background:
	Given I am on the login page
	And enter the credentials as
	|Email 						 | Password |
	|rstraavaldson@mailinator.com| P@55w0rd |
	And click on Login button
	And click on Create Supplier link
	And click on "New Supplier" button

Scenario: Create New Customer Types Screen - Only with Mandatory fields
	And user enter the below details to create a customer
	|Field Name	   | Value 			    |
	|Business Name | Supplier Mandatory |
	And click on Save button
    Then "Success" message "Created Supplier Successfully" should be displayed

#Due to Time constraint field validation not implemented for supplier. Mostly all fields are re-used from customers.
	
Scenario: Create New Suuplier Types Screen - with all values
	And user enter the below details to create a supplier
	|Field Name	      			|Value 			    	  |
	|Business Name    			|Test Supplier Name 	  |
	|Contact Name     			|Test Contact Name  	  |
	|Reference	      			|8044417801		    	  |
	|Email		      			|Test@gmail.com     	  |
	|Mobile		      			|01234567890			  |
	|Telephone	      			|01234567890			  |
	|Invoice Address 1	    	|1 Test Address 1   	  |
	|Invoice Address 2	    	|Test Address 2     	  |
	|Invoice Town / City    	|Test City 		    	  |
	|Invoice County 	    	|Test County 	    	  |
	|Invoice Postcode 	   		|XX67 0YY   	          |
	|Invoice Country        	|Ireland (IE)             |
	|Account Default  			|4200 - Sale of Assets    |
	|VAT Number       			|5677565X				  |
	|Set Credit Limit 			|1000					  |
	|Set Supplier Credit Terms 	|7						  |
	|Account Name				|Test Account Name		  |
	|Sort Code					|12-34-56				  |
	|Account Number				|1234567890000000000000000|
	|BIC/Swift					|MIDLGB22				  |
	|IBAN						|GB33BUKB20201555555555   |
	|Notes						|TestNotes				  |
	And click on Save button
    Then "Success" message "Created Supplier Successfully" should be displayed

Scenario: Duplicate Creation - To check Customer Types not created with same reference
	And user enter the below details to create a customer
	|Field Name	      		|Value 			    	  |
	|Business Name    		|Test Supplier Name 	  |
	|Contact Name     		|Test Contact Name  	  |
	|Reference	      		|8044417801		    	  |
	And click on Save button
	Then for "Reference Number" field "This reference is already taken for Test Supplier Name. Please try another." message should be displayed
	And error count message "There is 1 error" should be displayed
	Then "Duplicate" message "Reference must be unique." should be displayed