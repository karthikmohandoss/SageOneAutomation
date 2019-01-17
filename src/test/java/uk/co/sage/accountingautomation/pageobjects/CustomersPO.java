package uk.co.sage.accountingautomation.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.co.sage.accountingautomation.stepdefiniton.DriverManager;

public class CustomersPO {

	WebDriver driver = DriverManager.getInstance().getDriver();
    private SoftAssertions softAssertions = new SoftAssertions();

	public static By txtSearchBox = By.id("filter_search_text");
	public static By btnSearchSubmit = By.name("submit");
	public static By lblTotalRecordCount = By.cssSelector("#ui-main > div.UIGridStaticPattern > div.UIContainer > div.UIActionToolbar > div.UIContainer");
	public static By chkBoxDelete = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Telephone'])[1]/following::input[1]");
	public static By btnDeleteButton = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::i[3]");
	public static By popUpOptionCustomerYes = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete Customer?'])[1]/following::button[1]");
	public static By searchResult = By.xpath("//*[@id=\"customer_grid\"]/div[2]/table");
	public static By popUpOptionSupplierYes = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete Supplier?'])[1]/following::button[1]");
	String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	String subWindowHandler = null;
	
	public void searchReferenceNumber(String businessName) {
	    driver.findElement(txtSearchBox).clear();
	    driver.findElement(txtSearchBox).sendKeys(businessName);
	    driver.findElement(btnSearchSubmit).click();
	}
	
	public void assertRecordCount(String count) throws InterruptedException {
		//Helper.waitForElementToBeRefreshedAndClickable(driver, lblTotalRecordCount); // Not working at the moment
		Thread.sleep(1000);
	    softAssertions.assertThat(driver.findElement(lblTotalRecordCount).getText()).isEqualTo(count);
	    softAssertions.assertAll();
	}

	public void DeleteRecord() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(chkBoxDelete).click();
	}

	public void clickDeleteButton() {
	    driver.findElement(btnDeleteButton).click();
	}

	public void optionPopUp(String type) throws InterruptedException {
		Thread.sleep(1000);
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		if (type.equals("Customer"))
		{
			driver.findElement(popUpOptionCustomerYes).click();
		}
		else if (type.equals("Supplier"))
		{
			driver.findElement(popUpOptionSupplierYes).click();
		}
	}	

}
