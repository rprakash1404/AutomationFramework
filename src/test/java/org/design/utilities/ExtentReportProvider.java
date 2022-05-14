package org.design.utilities;

import java.io.File;
import java.io.IOException;

import com.google.inject.Inject;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportProvider {

	private static ExtentReports extent;

	public static ExtentReports getInstance() throws IOException {

		if (extent == null) {

			String currentExecutionBaseFolder = CurrentExecutionReportFolder.getCurrentExecutionFolder() + "\\";

			String reportPath = currentExecutionBaseFolder + "ExtentReportSample" + ".html";

			System.out.println("-----------  Extent report Path - " + reportPath);
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);

			extent.loadConfig(new File(System.getProperty("user.dir")
					+ "//src//test//resources//Configurations//ExtentReportFormatter.xml"));
		}
		return extent;
	}

}
