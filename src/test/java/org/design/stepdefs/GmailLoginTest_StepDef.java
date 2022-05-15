package org.design.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.design.pageobjects.GmailLoginPageObjects;
import org.design.utilities.ExtentTestHandler;
import org.design.utilities.ScreenshotUtil;
import org.design.utilities.SyncUtil;
import org.openqa.selenium.WebDriverException;

import com.google.inject.Inject;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GmailLoginTest_StepDef {

	@Inject
	GmailLoginPageObjects gmailLoginPO;

	@Inject
	SyncUtil sync;

	@Inject
	ScreenshotUtil util;

	@Inject
	ExtentTestHandler extentTestHandler;

	@Given("I navigate to gmail login page")
	public void openUrl() {
		try {
			gmailLoginPO.launchBrowser();
			gmailLoginPO.NavigateToSignInPage();
			extentTestHandler.getExtentTest().log(LogStatus.PASS, "I navigate to gmail login page");
		} catch (Exception ex) {
			extentTestHandler.getExtentTest().log(LogStatus.INFO,
					"Exception occured while entering username - " + ex.getMessage());
			fail("Exception occured while entering username");
			ex.printStackTrace();
		}
	}

	@When("I enter valid {string}")
	public void enterUserName(String userName) {
		try {
			gmailLoginPO.enterUserName(userName);
			extentTestHandler.getExtentTest().log(LogStatus.PASS, "I enter valid user");
		} catch (Exception ex) {
			extentTestHandler.getExtentTest().log(LogStatus.INFO,
					"Exception occured while entering username - " + ex.getMessage());
			fail("Exception occured while entering username");
			ex.printStackTrace();
		}
	}

	@When("I enter invalid {string}")
	public void enterPassword(String password) throws InterruptedException {
		try {
			gmailLoginPO.enterPassword(password);
			extentTestHandler.getExtentTest().log(LogStatus.PASS, "I enter valid password");
		} catch (WebDriverException Wex) {
			Wex.printStackTrace();
			extentTestHandler.getExtentTest().log(LogStatus.INFO,
					"Exception occured while entering password - " + Wex.getMessage());
			fail("Exception occured while entering password");
		} catch (Exception ex) {
			extentTestHandler.getExtentTest().log(LogStatus.INFO,
					"Exception occured while entering password - " + ex.getMessage());
			fail("Exception occured while entering password");
			ex.printStackTrace();
		}
	}

	@And("I click login button")
	public void clickLogin() {
		try {
			gmailLoginPO.clickLogin();
			extentTestHandler.getExtentTest().log(LogStatus.PASS, "I click login");
		} catch (Exception ex) {
			extentTestHandler.getExtentTest().log(LogStatus.INFO,
					"Exception occured while clicking login button - " + ex.getMessage());
			fail("Exception occured while clicking login button");
			ex.printStackTrace();
		}
	}

	@Then("I should get login error")
	public void asserLoginFailure() {
		try {
			assertTrue(gmailLoginPO.isWrongPasswordMessagePresent());
			extentTestHandler.getExtentTest().log(LogStatus.PASS, "Got error as expected");
		} catch (Exception ex) {
			extentTestHandler.getExtentTest().log(LogStatus.INFO, "Exception occured whileasserting login failure.");
			fail("Exception occured whileasserting login failure");
			ex.printStackTrace();
		}

	}

}
