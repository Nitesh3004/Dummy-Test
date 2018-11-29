package web.ns.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import web.ns.pageobjects.NsWebHomePage;
import web.ns.pageobjects.WorkSpaceVoyageManager;
import web.ns.testbase.BaseClass;

public class LoginToNs_01 extends BaseClass {
		
	@Test
	public void login() {
		
		NsWebHomePage homePage = new NsWebHomePage(driver);
		WorkSpaceVoyageManager voyageManager = new WorkSpaceVoyageManager(driver);
		
		report = new ExtentReports("./testresults/Automation-Results.html");
		logger = report.startTest("LoginToNs_01");
		
		homePage.enterUserName(driver, "ADMIN");
		logger.log(LogStatus.INFO, "User entered username");
		
		homePage.enterPassWord(driver, "123456");
		logger.log(LogStatus.INFO, "User entered password");
		
		/*if(driver.getTitle().contains("NSWeb-Login")) {
			logger.log(LogStatus.PASS, "Title as expected");
		}else {
			logger.log(LogStatus.FAIL, "Title not as expected");
		}*/
	/*	
		homePage.clickSignIn(driver);
		logger.log(LogStatus.INFO, "User clicked on sign in");
		
		voyageManager.clickVoyageManager(driver);
		
		voyageManager.clickVoyage(driver);
		
		voyageManager.clickCreateVoyage(driver);
		*/
	}
}
