package uk.co.sage.accountingautomation.stepdefiniton;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import uk.co.sage.accountingautomation.dataproviders.ConfigFileReader;

public class DriverManager {
	
	private static DriverManager instance = new DriverManager();
    ConfigFileReader configFileReader = new ConfigFileReader();

	public static DriverManager getInstance() {
		return instance;
	}
	
    private static WebDriver driver;

    @Before
    public void setUp() throws Exception {

    }

	public WebDriver getDriver(){
		if (driver == null) {
			 if (configFileReader.getBrowser().equals("chrome"))
			 {
				 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
				 driver = new ChromeDriver();
			 }
			 else if (configFileReader.getBrowser().equals("ie"))
			 {
				 System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\IEDriverServer_32.exe");
				 driver = new InternetExplorerDriver();
			 }
			 else if (configFileReader.getBrowser().equals("firefox"))
			 {
				 System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
				 driver = new FirefoxDriver();
			 }
		}
		return driver;
	}
	
	public void quitDriver(){
		if (driver != null){
			driver.quit();
			driver = null;
		}
	}		 
}
