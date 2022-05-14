package org.design.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.design.pageobjects.GmailLoginPageObjects;
import org.design.utilities.ScreenshotUtil;
import org.design.utilities.SyncUtil;

import com.google.inject.Inject;

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

	@Given("I navigate to gmail login page")
	public void openUrl() {
		System.out.println("I navigate to gmail login page");
		gmailLoginPO.launchBrowser();
		gmailLoginPO.NavigateToSignInPage();
		//fail();
	}

	@When("I enter valid {string}")
	public void enterUserName(String userName) {
		System.out.println("I enter valid user");
		gmailLoginPO.enterUserName(userName);
	}

	@When("I enter invalid {string}")
	public void enterPassword(String password) throws InterruptedException {
		System.out.println("I enter valid pwd");
		gmailLoginPO.enterPassword(password);
	}

	@And("I click login button")
	public void clickLogin() {
		System.out.println("I click login");
		gmailLoginPO.clickLogin();
	}

	@Then("I should get login error")
	public void asserLoginFailure() {
		System.out.println("I get error");
		assertTrue(gmailLoginPO.isWrongPasswordMessagePresent());
	}
	
}
