package uk.co.sage.accountingautomation.stepdefiniton;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import uk.co.sage.accountingautomation.pageobjects.CreateCustomersSupplierPO;

public class CreateCustomersSupplierSteps {
	
	CreateCustomersSupplierPO createCustomerSupplierPO = new CreateCustomersSupplierPO();
	
	@And("^click on Create (Customer|Supplier) link$")
	public void click_on_Create_Customer_link(String type) throws Throwable {
		if (type.equals("Customer"))
			createCustomerSupplierPO.clickCreateCustomerLink();
		else if (type.equals("Supplier"))
			createCustomerSupplierPO.clickSupplierCustomerLink();
	}
	
	@Then("^click on \"([^\"]*)\" button$")
	public void click_on_button(String option) throws Throwable {
			createCustomerSupplierPO.clickCreateCustomerSupplierButton();
	}
	
	@Then("^click on Save button$")
	public void click_on_Save_button() throws Throwable {
		createCustomerSupplierPO.clickSave();
		Thread.sleep(1000);
	}
	
	@And("^enter the below details$")
	public void enter_the_below_details(DataTable data) throws Throwable {
		createCustomerSupplierPO.validateErrorMessage(data);
	}
	
    @Then("^for \"([^\"]*)\" field \"([^\"]*)\" message should be displayed$")
    public void for_field_message_should_be_displayed(String fieldName, String errorMessage) throws Throwable {
    	createCustomerSupplierPO.assertErrorMessage(fieldName, errorMessage);
    }
    
    @Then("^error count message \"([^\"]*)\" should be displayed$")
    public void error_count_message_should_be_displayed(String expectedErrorCount) throws Throwable {
    	createCustomerSupplierPO.validateErrorCountMessage(expectedErrorCount);
    }

	@And("^user enter the below details to create a (customer|supplier)$")
	public void user_enter_the_below_details_to_create_a_customer(String contactType, Map<String, String> customerData) throws Throwable {
    	createCustomerSupplierPO.createNewCustomer(customerData);
	}
	
	@Then("^\"([^\"]*)\" message \"([^\"]*)\" should be displayed$")
	public void message_should_be_displayed(String messageType, String flashMessage) throws Throwable {
    	createCustomerSupplierPO.assertFlashMessage(messageType, flashMessage);
	}
}
