package uk.co.sage.accountingautomation.stepdefiniton;

import cucumber.api.java.en.And;
import uk.co.sage.accountingautomation.pageobjects.CustomersPO;

public class CustomersSteps {
	
	CustomersPO customerPO = new CustomersPO();

	@And("^user search for Business Name \"([^\"]*)\"$")
	public void search_for_business_name(String businessName) throws Throwable {
		customerPO.searchReferenceNumber(businessName);
	}

	@And("^record count should be displayed as \"([^\"]*)\"$")
	public void record_count_should_be_displayed_as(String count) throws Throwable {
		customerPO.assertRecordCount(count);
	}
	
	@And("^user select the record to delete$")
	public void user_select_the_record_to_delete() throws Throwable {
		customerPO.DeleteRecord();
	}

	@And("^user clicks on the Delete button$")
	public void user_clicks_on_the_Delete_button() throws Throwable {
		customerPO.clickDeleteButton();
	}

	@And("^user clicks Yes botton on the confirmation window for \"([^\"]*)\"$")
	public void user_clicks_Yes_botton_on_the_confirmation_window(String type) throws Throwable {
		customerPO.optionPopUp(type);
	}

}
