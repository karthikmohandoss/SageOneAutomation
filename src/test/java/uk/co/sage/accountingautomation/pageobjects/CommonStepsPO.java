package uk.co.sage.accountingautomation.pageobjects;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import uk.co.sage.accountingautomation.stepdefiniton.DriverManager;

public class CommonStepsPO {

	public static By requiredErrorMessage = By.cssSelector(".common-input__message--error");
	public static By errorCountMessage = By.className("validation-summary__text");

	WebDriver driver = DriverManager.getInstance().getDriver();	
	Actions action = new Actions(driver);

	public void validateErrorMessage(String fieldName, String expectedErrorMessage) {
		switch(fieldName) {
			case "Business Name":
				action.moveToElement(driver.findElement(CreateCustomersSupplierPO.txtBusinessName)).build().perform();			
				String actualErrorMessage =  driver.findElement(requiredErrorMessage).getText();
		    	assertEquals(expectedErrorMessage, actualErrorMessage);
		}
	}

	public void validateErrorCountMessage(String expectedErrorCount) {
		String actualErrorCount = driver.findElement(errorCountMessage).getText();
    	assertEquals(expectedErrorCount, actualErrorCount);
	}
}