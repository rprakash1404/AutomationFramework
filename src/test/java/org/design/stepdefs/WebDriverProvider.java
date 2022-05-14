package org.design.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.guice.ScenarioScoped;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;

@ScenarioScoped
@Data
public class WebDriverProvider {

	WebDriver driver;

	public WebDriverProvider() {

		String browserType = System.getProperty("browserType", System.getenv("browserType"));

		switch (browserType) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
		case "chrome":
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
		}
	}

}
