package web.ns.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {

	public static void clickElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public static void clearElementandEnterText(WebDriver driver, WebElement element,String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void selectElement(WebDriver driver, WebElement element,int index) {
		Select selectElement = new Select(element);
		selectElement.selectByIndex(index);
	}
	
	public boolean isAlertPresent(WebDriver driver)
	{
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e){
			System.out.println();
			return false;
		}
	}
	
	public void handleAlert(WebDriver driver,boolean decision)
	{
		if(decision==true)
		{
			driver.switchTo().alert().accept();
		}
		else{
			driver.switchTo().alert().dismiss();
		}
		 		
	}
	
	public static void waitForElement(WebDriver driver , WebElement element , int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void captureScreenShot(WebDriver driver, String name) {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./screenshots"+name+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

