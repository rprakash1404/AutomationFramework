package org.design.core.baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.guice.ScenarioScoped;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;

@ScenarioScoped
@Data
public class WebDriverProvider {

	WebDriver driver;

	public WebDriverProvider() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
	
	public WebDriverProvider(String browserType) {
		
		browserType = System.getProperty("browserType");
		
		switch(browserType) {
		case "firefox":
			
		case "chrome":
			
		}
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}

}
