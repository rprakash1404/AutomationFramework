package org.design.core.utilities;

import java.time.Duration;

import org.design.core.baseclasses.WebDriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.awaitility.Awaitility.*;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SyncUtil {

	WebDriver driver;
	JavascriptExecutor jsDriver;
	WebDriverWait wdWait;
	Wait<WebDriver> wait;

	@Inject
	public SyncUtil(WebDriverProvider driverFactory) {
		this.driver = driverFactory.getDriver();
		jsDriver = (JavascriptExecutor) this.driver;
	}

	public void waitForElementToAppear(WebElement ele, Duration duration) {
		wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(100)).withTimeout(duration)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForPageToLoad() {
		ExpectedCondition<Boolean> ec = (driver) -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals("complete");
		wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ec);

	}
	
	public void staticWait(Duration duration) {
		 await().atMost(duration).await().until(() -> false);
	}

}
