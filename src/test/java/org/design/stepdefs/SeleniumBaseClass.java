package org.design.stepdefs;

import java.io.IOException;
import java.util.Properties;

import org.design.utilities.ExtentTestHandler;
import org.design.utilities.ScreenshotUtil;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

@ScenarioScoped
public class SeleniumBaseClass {

	WebDriver driver;
	Properties appConfigs;

	ExtentReports reports;
	ExtentTest extentTest;

	@Inject
	WebDriverProvider driverProvider;

	@Inject
	ScreenshotUtil screenShotUtil;

	@Inject
	ExtentTestHandler extentTestHandler;

	@Before(order = 1)
	public void loadConfig() throws IOException {
		appConfigs = new Properties();
		appConfigs.load(this.getClass().getResourceAsStream("/Configurations/appConfig.properties"));
	}

	@Before(order = 2)
	public void reportSetUp(Scenario currentScenario) throws IOException {
		reports = extentTestHandler.getExtentReport();
		extentTest = reports.startTest(currentScenario.getName());
		extentTestHandler.setExtentTest(extentTest);
	}

	@Before(order = 3)
	public void instantiateBrowser() throws IOException {
		driver = driverProvider.getDriver();
	}

	@AfterStep
	public void reportStepStatus(Scenario currentScenario) {

		if (currentScenario.isFailed()) {
			extentTest.log(LogStatus.FAIL, String.valueOf(currentScenario.getLine()),
					extentTest.addScreenCapture(screenShotUtil.captureScreenshot()));
		}
	}

	@After
	public void closeBrowser(Scenario currentScenario) {
		reports.endTest(extentTest);
		reports.flush();
		driver.close();
		driver.quit();
	}
}
