@SageTask
Feature: Create Customer Contact Types
	As a SageOne user
	I am able to Create new Customer Contact Types
	
Background:
	Given I am on the login page
	And enter the credentials as
	|Email 						 | Password |
	|rstraavaldson@mailinator.com| P@55w0rd |
	And click on Login button
	And click on Create Customer link
	And click on "New Customer" button

Scenario: Mandatory field validation for New Customer Types Screen
	And click on Save button
	Then for "Business Name" field "This field is required." message should be displayed
	And error count message "There is 1 error" should be displayed

# Fields Business Name, Contact Name, Reference Number, Mobile and Telephone fields are commented 
# because not sure about requirement.
# 366 days for leap year but system not allows to enter 366 days - Payment terms would be like 366 days but
# tested this for cover Boundary Value Testing
# In Address details, in VAT field GB is displayed if country is selected as Other?

Scenario: Negative Testing - Field validations for New Customer Types Screen
	And enter the below details
	|Field Name	   		|Test Type			   |Value 		  |Error Message 					  											|
###	|Business Name	   	|Special Characters	   |£$%		  	  |Invalid Business Name			  											|
###	|Business Name	   	|Numbers			   |1234	  	  |Invalid Business Name			  											|
###	|Contact Name	   	|Special Characters	   |£$%		  	  |Invalid Contact Name			  	  											|
###	|Contact Name	   	|Numbers			   |1234	  	  |Invalid Contact Name															|
###	|Reference Number  	|Special Characters	   |£$%		  	  |Invalid Reference Number			  	  										|
###	|Reference Number  	|Characters			   |ABCD	  	  |Invalid Reference Number														|
###	|Mobile		   		|AlphaNumeric		   |abc1234444    |Please enter a valid mobile number.  										|
###	|Telephone	   		|AlphaNumeric		   |abc1234444    |Please enter a valid mobile number. 		      								|
	|Email		   		|Characters			   |Testgmail	  |Please enter a valid email address. 											|
	|Email		   		|Numbers			   |123456789	  |Please enter a valid email address.											|	
	|VAT Number GB 		|Characters			   |abcdefghi	  |Format must match '123456789 (9 characters)' for country United Kingdom (GB).|
	|VAT Number GB 		|Numbers		   	   |1234567890	  |Format must match '123456789 (9 characters)' for country United Kingdom (GB).|
	|VAT Number IE 		|Numbers		   	   |1234567890	  |Format must match '1234567X, 1X23456X, 1234567XX, (8 or 9 characters. Includes one or two alphabetical characters (last, or second and last, or last 2))' for country Ireland (IE).|
	|Set Credit Limit   |Not a Number		   |-			  |is not a number																|
	|Set Credit Limit   |Less than 0		   |-1.00		  |must be greater than or equal to 0.00										|
	|Set Credit Terms   |Greater than 366      |367		  	  |must be less than or equal to 365											|
	|Set Credit Terms   |Not An integer		   |-			  |must be an integer															|
	|Set Credit Terms   |Less than 0		   |-1			  |must be greater than or equal to 0											|
	|Sort Code 1	    |Only SortCode 1       |33			  |is the wrong length (should be 6 characters)									|
	|Sort Code 2	    |SortCode 1 and 2      |55			  |is the wrong length (should be 6 characters)									|
	|Sort Code 3	    |5 Characters 	       |66			  |is the wrong length (should be 6 characters)									|
	|BIC/Swift		    |Invalid SWIFT	       |SWIFT		  |Invalid Format																|
	|IBAN			    |Invalid IBAN	       |IBAN		  |Invalid Format																|
And error count message "There are 8 errors" should be displayed

Scenario: Create New Customer Types Screen - Only with Mandatory fields
	And user enter the below details to create a customer
	|Field Name	   | Value 			    		  |
	|Business Name | Customer Mandatory |
	And click on Save button
    Then "Success" message "Created Customer Successfully" should be displayed
	
Scenario: Create New Customer Types Screen - with all values
	And user enter the below details to create a customer
	|Field Name	      		|Value 			    	  |
	|Business Name    		|Test Customer Name 	  |
	|Contact Name     		|Test Contact Name  	  |
	|Reference	      		|1556677892		    	  |
	|Email		      		|Test@gmail.com     	  |
	|Mobile		      		|01234567890			  |
	|Telephone	      		|01234567890			  |
	|Invoice Address 1	    |1 Test Address 1   	  |
	|Invoice Address 2	    |Test Address 2     	  |
	|Invoice Town / City    |Test City 		    	  |
	|Invoice County 	    |Test County 	    	  |
	|Invoice Postcode 	   	|XX67 0YY   	          |
	|Invoice Country        |Ireland (IE)             |
	|Account Default  		|4200 - Sale of Assets    |
	|VAT Number       		|5677565X				  |
	|Delivery Address 1	    |1 Test Address 1   	  |
	|Delivery Address 2	    |Test Address 2     	  |
	|Delivery Town / City   |Test City 		   		  |
	|Delivery County 	    |Test County 	   		  |	
	|Delivery Postcode 	    |XX67 0YY		   		  |
	|Delivery Country       |United Kingdom (GB)	  |
	|Set Credit Limit 		|1000					  |
	|Set Credit Terms 		|7						  |
	|Terms & Conditions 	|Test Terms & Conditions  |
	|Account Name			|Test Account Name		  |
	|Sort Code				|12-34-56				  |
	|Account Number			|1234567890000000000000000|
	|BIC/Swift				|MIDLGB22				  |
	|IBAN					|GB33BUKB20201555555555   |
	|Price Default 			|Trade					  |
	|Notes					|TestNotes				  |
	And click on Save button
    Then "Success" message "Created Customer Successfully" should be displayed

Scenario: Duplicate Creation - To check Customer Types not created with same reference
	And user enter the below details to create a customer
	|Field Name	      		|Value 			    	  |
	|Business Name    		|Test Customer Name 	  |
	|Contact Name     		|Test Contact Name  	  |
	|Reference	      		|1556677892		    	  |
	And click on Save button
	Then for "Reference Number" field "This reference is already taken for Test Customer Name. Please try another." message should be displayed
	And error count message "There is 1 error" should be displayed
	Then "Duplicate" message "Reference must be unique." should be displayed