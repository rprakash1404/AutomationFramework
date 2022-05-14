package org.design.core.runner;

import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "classpath:org.design.stepdefs", tags = "@login", plugin = {
		"pretty", "junit:target/cucumber-reports/demo-test-report.xml", "json:target/json_output/cucumber.json" })
public class TestRunner {


}