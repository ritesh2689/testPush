package TestNG;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

public class TestNGClass {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void launchapp(String browser) throws MalformedURLException {
		String URL = "http://www.calculator.net";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			String Node = "http://10.20.66.90:5555/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(URL);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on chrome");
			String Node = "http://10.20.66.90:5557/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println(" Executing on IE");
			String Node = "http://10.20.66.90:5556/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("ie");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() {
		driver.get(URL);
		Assert.assertEquals(
				"Calculator.net: Free Online Calculators - Math, Health, Financial, Science",
				driver.getTitle());
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}