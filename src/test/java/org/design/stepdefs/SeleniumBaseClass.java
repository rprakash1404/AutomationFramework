package org.design.stepdefs;

import org.design.core.baseclasses.WebDriverProvider;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SeleniumBaseClass {

	WebDriver driver;
	
	@Inject
	public SeleniumBaseClass(WebDriverProvider driverProvider) {
		this.driver = driverProvider.getDriver();
	}
	
	@Before
	public void loadConfig() {
		
	}
	
	@After
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
