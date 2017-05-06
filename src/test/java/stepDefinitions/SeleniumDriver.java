package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SeleniumDriver {

	static WebDriver driver;
	static boolean browserOpenFlag = false;

	@Before
	public void setup() {
		if (!browserOpenFlag) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			browserOpenFlag = true;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@After
	public void tearDown() {
		driver.close();
		browserOpenFlag = false;
	}
}
