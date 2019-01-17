package uk.co.sage.accountingautomation.testrunner;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import uk.co.sage.accountingautomation.config.Properties;

public class BaseRunner{
	
	@BeforeClass
	public static void setup() {
		//Instantiate Extent reports
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(getReportPath()+getReportName());
	}

	@After
	public void afterEveryTest(){
		System.out.println("in after class");
	}

	@AfterClass
	public static void teardown() throws Throwable {
		//configure Extent reports
		Reporter.loadXMLConfig(new File(Properties.ExtentXMLConfig));
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name"));
		Reporter.setSystemInfo("Browser", System.getProperty("browser.name"));
		Reporter.setSystemInfo("Java version", System.getProperty("java.version"));
	}

	public static String getReportPath(){
		String reportPath = System.getProperty("user.dir")+File.separator+"ExtentRunReports"+File.separator; 
		System.out.println("report path invoked : "+reportPath);
		return reportPath;
	}

	public static String getReportName(){
		return "RunReport_"+getTimeStamp()+".html";
	}
	
	public static String getTimeStamp(){
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");    	
		return formatter.format(new Date());
	}

	public static String getScreenshotPath(){
		return getReportPath()+"Screenshots"+File.separator;
	}

}