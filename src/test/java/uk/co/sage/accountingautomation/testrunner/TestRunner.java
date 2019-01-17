package uk.co.sage.accountingautomation.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"classpath:features"}, 
		glue= {"uk.co.sage.accountingautomation.stepdefiniton","uk.co.sage.accountingautomation.hooks"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
		tags= {"@SageTask"})

public class TestRunner extends BaseRunner {
		
}