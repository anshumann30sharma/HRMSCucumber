package com.hrms.testbase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver = null;


	/**
	 * this method will run for every xml test.
	 */
/*	@BeforeTest(alwaysRun = true)
	public void generateReport() {
		public static ExtentReports report;
		public static ExtentHtmlReporter htmlReport;
		
		public static String imageName="";
		public static ExtentTest test;
		htmlReport = new ExtentHtmlReporter(Constants.REPORT_FILEPATH+"HRMS"+CommonMethod.getTimeStemp()+".html");
		htmlReport.config().setAutoCreateRelativePathMedia(true);
		htmlReport.config().setDocumentTitle("HRMS Reports");
		htmlReport.config().setReportName("HRMS Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

		report = new ExtentReports();
		report.attachReporter(htmlReport);

	}

//	@AfterTest(alwaysRun = true)//

	public void writeReport() {
		
		report.flush();
	}*/

	/**
	 * this Method will Set properties for Selenium test case and Initialize
	 * Webdriver for Chrome or Firefox based on argument. this can be write as >
	 * WebDriver driver=SeleniumSetting.driver("name of browser")<;
	 * 
	 * @param browser
	 * @return
	 */
	//@BeforeMethod(alwaysRun = true)//
	public static WebDriver setUp() {

		ConfigsReader.propertiesReader(Constants.PROPERITESFILE_PATH);

		String browser = Constants.BROWSER;
		String url = ConfigsReader.getProperty("ProjectUrl");

		switch (browser.toLowerCase()) {

		case "chrome":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, "true");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "ie":
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "true");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(url);
		PageInitializer.initialize();
		return driver;
	}

	//@AfterMethod(alwaysRun = true)//
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
