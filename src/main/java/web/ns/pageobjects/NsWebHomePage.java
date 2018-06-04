package web.ns.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.ns.utilities.ReusableComponents;

public class NsWebHomePage {

	WebDriver driver;
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(xpath="//*[contains(text(),'Sign In')]")
	WebElement signIn;
	
	public void enterUserName(WebDriver driver,String name)
	{	
		ReusableComponents.waitForElement(driver, signIn,5);
		ReusableComponents.clearElementandEnterText(driver, userName, name);
	}
	
	public void enterPassWord(WebDriver driver,String password)
	{
		ReusableComponents.clearElementandEnterText(driver, passWord, password);
	}
	
	public void clickSignIn(WebDriver driver) {
		ReusableComponents.clickElement(driver, signIn);
	}
	
	public NsWebHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


}
