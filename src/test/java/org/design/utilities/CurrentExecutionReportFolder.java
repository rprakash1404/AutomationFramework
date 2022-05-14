package org.design.utilities;

import org.design.constants.AutomationConstants;

import com.google.inject.Inject;

public class CurrentExecutionReportFolder {

	static String currentExecutionFolder;

//	@Inject
//	static DateTimeUtil dateTimeUtil;

	private CurrentExecutionReportFolder() {

	}

	public static String getCurrentExecutionFolder() {
		DateTimeUtil dateTimeUtil = new DateTimeUtil();
		if (currentExecutionFolder == null) {
			currentExecutionFolder = new String(AutomationConstants.extentReportBasePath)
					+ dateTimeUtil.getCurrDateTimeStr();
		}
		return currentExecutionFolder;
	}
}
