# SageOneAutomation
SageOne Test Automation
Issues:
1) Sort code bug
Sort code 1 - Blank error message
Sort code 2 - Blank error message
Sort code 3 - 2 tool tip error messages displayed

2) VAT Number field bug - 
Enter GB invalid tax number and then tab out.
Mouse hover on the VAT number error tool tip.
And change the country to Ireland
Then IE is blank but still shows as error and shows error message which is belong to GB. 

3) VAT Number field bug - 
	GB is still displayed even after changing the country to Other.

Challenges.
Tool tip error message - challenging - Found the element using CSS. But its very difficult to find in DOM. Went through css code and found it.

Flash message as well.

For some fields clear() method didn’t work so used keys function to delete the text.	

Good to have:
Postcode Regex
Mobile Regex
Telephone Regex
In future if we call any other API then we need to change all these. So better to use Regex for some standard fields.

Fields should be unique: Id or Name
Same name for Hidden field and Checkbox- contact[credit_set] - Set Credit Limit.
Same name for Hidden field and Checkbox - contact[customer_credit_days] - Set Credit Terms
Because this will fail during accessibility testing.


Tools used:

Eclipse, Maven, Junit, Cucumber and Selenium Framework in Java.

Git Repo: Pull the code and run Maven refresh.
Then run TestRunner Class to run all the features. Framework can run in Chrome, IE and Firefox by passing the browser name in config file.
Note: Tested only in Chrome browser.

Test covered:
•	Covered most of the validation - Negative and positive testing.
•	Created and deleted customers and Suppliers. 
•	Searched the newly created customers and suppliers in the search criteria and confirm that record is created successfully.
•	Deleted the record and confirm that record is deleted successfully.

Testing techniques: Adhoc testing and Experience based testing.

Tech Debt:

Need to look the code to make it clean like putting common methods in a separate class.

Also planning to run this tests via Selenium Grid to run in different browsers at the same 

Also need to run these tests via Jenkins pipeline for CI.

Closes browser at the end of ecah scenario currently need to open the browser at feature level so that we can improve the test execution time.
