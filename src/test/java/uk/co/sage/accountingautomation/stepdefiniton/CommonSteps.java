package uk.co.sage.accountingautomation.stepdefiniton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import uk.co.sage.accountingautomation.dataproviders.ConfigFileReader;
import uk.co.sage.accountingautomation.pageobjects.CommonStepsPO;

public class CommonSteps {
	
    ConfigFileReader configFileReader = new ConfigFileReader();	
	CommonStepsPO commonStepsPO = new CommonStepsPO();
	WebDriver driver = DriverManager.getInstance().getDriver();
	
	 @Given("^I am on the login page$")
	 public void loginPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(configFileReader.getApplicationUrl());
   }
}
