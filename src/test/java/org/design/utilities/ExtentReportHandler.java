package org.design.utilities;

import java.io.File;

import com.google.inject.Singleton;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import lombok.Data;

@Singleton
@Data
public class ExtentReportHandler {

	private ExtentReports extentReport;

	public ExtentReportHandler() {
		String currentExecutionBaseFolder = CurrentExecutionReportFolder.getCurrentExecutionFolder() + "\\";
		String reportPath = currentExecutionBaseFolder + "ExtentReportSample" + ".html";
		extentReport = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
		extentReport.loadConfig(new File(
				System.getProperty("user.dir") + "//src//test//resources//Configurations//ExtentReportFormatter.xml"));
	}

}
