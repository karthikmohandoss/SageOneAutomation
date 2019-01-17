package uk.co.sage.accountingautomation.stepdefiniton;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import uk.co.sage.accountingautomation.pageobjects.LoginPagePO;

public class UserLoginSteps {
	LoginPagePO loginPage = new LoginPagePO();

	@And("^enter the credentials as$")
	public void enter_the_credentials_as(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw();
		loginPage.enterCredentials(data.get(1).get(0), data.get(1).get(1));
	}

	@And("^click on Login button$")
	public void click_on_login_button() throws Throwable {
		loginPage.clickSubmit();
	}

	@Then("^the page heading will be \"([^\"]*)\"$")
	public void checkPageHeading(String title) throws Throwable {
		loginPage.checkPageHeading(title);
	}	
}