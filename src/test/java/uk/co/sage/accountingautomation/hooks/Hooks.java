package uk.co.sage.accountingautomation.hooks;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import uk.co.sage.accountingautomation.stepdefiniton.DriverManager;
import uk.co.sage.accountingautomation.testrunner.BaseRunner;

public class Hooks {
	
	private WebDriver driver = DriverManager.getInstance().getDriver();

	@Before
	public static void startUp(Scenario scenario) throws IOException  {
	}

	@After
	public void closeDown(Scenario scenario) throws InterruptedException { 		
		if (scenario.isFailed()) {
			System.out.println("In Hooks After failed ");

			String screenshotName = scenario.getName().replaceAll(" ", "")+"";
			System.out.println("screenshotName : "+screenshotName);
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(BaseRunner.getScreenshotPath()+screenshotName+BaseRunner.getTimeStamp()+".png");
				System.out.println("destinationPath : "+destinationPath);

				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   

				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
		DriverManager.getInstance().quitDriver();
	}
	
	@After("@closebrowser")
	public void closebrowser()
	{
		driver.close();
	}

}
