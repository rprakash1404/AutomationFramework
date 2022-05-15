package org.design.utilities;

import com.google.inject.Inject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.guice.ScenarioScoped;
import lombok.Data;

@ScenarioScoped
@Data
public class ExtentTestHandler {
	
	ExtentTest extentTest;
	private ExtentReports extentReport;
	
	@Inject
	public ExtentTestHandler(ExtentReportHandler extentReportHandler) {
		this.extentReport = extentReportHandler.getExtentReport();
	}

}
