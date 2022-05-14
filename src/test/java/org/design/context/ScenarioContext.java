package org.design.context;

import io.cucumber.guice.ScenarioScoped;
import lombok.Data;

@ScenarioScoped
@Data
public class ScenarioContext {

	String extentReportBaseFolder;
}
