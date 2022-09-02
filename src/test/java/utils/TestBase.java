package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Global.properties");

		Properties prop = new Properties();
		prop.load(fis);

		String URL = prop.getProperty("url");
		String browser_properties = prop.getProperty("browser");
		//The arguments we pass through cmd line are stored in system class
		String browser_maven = System.getProperty("browser");

		String browserName = (browser_maven != null) ? browser_maven : browser_properties;

		if (driver == null) {

			if (browserName.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			driver.get(URL);
		}

		return driver;

	}

}
