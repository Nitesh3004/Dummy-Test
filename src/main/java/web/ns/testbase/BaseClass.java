package web.ns.testbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import web.ns.utilities.ReadProperty;
import web.ns.utilities.ReusableComponents;

public class BaseClass {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeClass
	public void setupApplication() throws IOException
	{
		
		
		Properties property=ReadProperty.FileReader("./application.properties");
		if(property.getProperty("browser").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod()
	public void tearDown(ITestResult result ) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			ReusableComponents.captureScreenShot(driver,result.getName());
		}
		
		report.endTest(logger);
		report.flush();
		driver.quit();
	}

}
