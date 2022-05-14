package org.design.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.design.stepdefs.SeleniumBaseClass;
import org.design.stepdefs.WebDriverProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import io.cucumber.guice.ScenarioScoped;

@Singleton
public class ScreenshotUtil {

	WebDriver driver;

	@Inject
	DateTimeUtil dateTimeUtil;

	@Inject
	public ScreenshotUtil(WebDriverProvider webDriverProvider) {
		this.driver = webDriverProvider.getDriver();
	}

	public String captureScreenshot() {

		String targetFile = CurrentExecutionReportFolder.getCurrentExecutionFolder() + "\\"
				+ dateTimeUtil.getCurrTimeStr() + ".jpg";

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return targetFile;

	}

}
