# SageOneAutomation
SageOne Test Automation
1) Fields name and id should be unique:
Same name for Hidden field and Checkbox- contact[credit_set] - Set Credit Limit
Same name for Hidden field and Checkbox - contact[customer_credit_days] - Set Credit Terms
2) Sort code bug
Sort code 1 - Blank error messsage
Sort code 2 - Blank error message
Sort code 3 - 2 tool tip error messages displayed

Tool tip error message - challenging - Found the element using CSS. But its very diffcult to find DOM. Went through css code and found it.
Flash message as well.

Good to have:
Postcode Regex
Mobile Regex
Telephone Regex

VAT Number field bug - 
Enter GB invaild tax number and then tab out.
Mouse hover on the VAT number error tool tip.
And change the country to Ireland
Then IE is blank but still shows as error and shows error message which is belong to GB. 

Tools used:
Eclispe, Maven, Junit, Cucumber and Selenium Framework in Java.

Git Repo: Git pull and run Maven refresh.
Then run TestRunner Class to run all the features. Framework can run in Chrome, IE and Firefox by passing the browser name in config file.
Note: Tested only in Chrome browser.

Test covered:
Covered most of the validation - Negative and positive testing.
Created and deleted customers and Supppliers. 
Searched the newly created customers and suppliers in the search criteria and confirm that record is created successfully.
Deleted the record and confirm that record is deleted successfully.

Testing techniques: Adhoc testing and Experiecne based testing.

Improvements:

Need to look the code to make it clean like putting common methods in a separate class.
Also planning to run this tests via Selenium Grid to run in different browsers at the same
