package uk.co.sage.accountingautomation.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.co.sage.accountingautomation.dataproviders.ConfigFileReader;
import uk.co.sage.accountingautomation.stepdefiniton.DriverManager;

public class LoginPagePO {
	
	ConfigFileReader configReader = new ConfigFileReader();
	//private DriverManager driverManager;

	public By txtEmail = By.id("sso_Email");
	public By txtPassword = By.id("sso_Password"); 	 		
	public By pageHeading = By.cssSelector("#ui-body > header > hgroup > h1");
	
	// Css selector
	public By btnLogin = By.cssSelector("body > div > div.container > div > form > div.content > div.navigation > span > input");

//	public LoginPagePO(DriverManager driverManager) {
//		this.driverManager = driverManager;
//	}
	WebDriver driver = DriverManager.getInstance().getDriver();
	
	public void enterCredentials(String userName, String password)
	{
		//Clear fields
		driver.findElement(txtEmail).clear();
		driver.findElement(txtPassword).clear();
		
		// Enter credentials
		driver.findElement(txtEmail).sendKeys(userName);
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickSubmit() 
	{
		// Form Submit
		driver.findElement(txtEmail).submit();
	}

	public void checkPageHeading(String title) {
		assertEquals(driver.findElement(pageHeading).getText(), title);		
	}
}