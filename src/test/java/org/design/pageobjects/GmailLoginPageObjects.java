package org.design.pageobjects;

import java.time.Duration;

import org.design.core.baseclasses.WebDriverProvider;
import org.design.core.utilities.SyncUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GmailLoginPageObjects {
	
	WebDriver driver;
	
	@Inject
	SyncUtil sync;

	@FindBy(how = How.XPATH, using = "//a[text()='Sign in']")
	WebElement Btn_SignIn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"identifierId\"]")
	WebElement TxtBox_UserName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement TxtBox_Password;

	@FindBy(how = How.XPATH, using = "//*[text()='Next']/parent::button")
	WebElement Btn_Next;
	
	@FindBy(how = How.XPATH, using = "//div[@jsname=\"B34EJ\"]/span[contains(text(),'Wrong')]")
	WebElement Message_WrongPassword;	
	
	@Inject
	public GmailLoginPageObjects(WebDriverProvider driverFactory) {
		this.driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void launchBrowser() {
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");
		sync.waitForPageToLoad();
	}
	
	public void NavigateToSignInPage() {
		Btn_SignIn.click();
	}
	
	public void enterUserName(String userName) {
		sync.waitForPageToLoad();
		TxtBox_UserName.sendKeys(userName);
		sync.waitForElementToAppear(Btn_Next, Duration.ofSeconds(1));
		Btn_Next.click();
		sync.staticWait(Duration.ofSeconds(5));
	}
	
	public void enterPassword(String password) {
		sync.waitForPageToLoad();
		sync.waitForElementToAppear(TxtBox_Password, Duration.ofSeconds(5));
		TxtBox_Password.sendKeys("text");
	}
	
	public void clickLogin() {
		sync.waitForElementToAppear(Btn_Next, Duration.ofSeconds(5));
		Btn_Next.click();
	}
	
	public boolean isWrongPasswordMessagePresent() {
		sync.waitForElementToAppear(Message_WrongPassword, Duration.ofSeconds(1));
		return Message_WrongPassword.isDisplayed();
	}
	
}
