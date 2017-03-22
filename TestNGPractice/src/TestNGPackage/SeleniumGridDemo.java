package TestNGPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumGridDemo {

	WebDriver driver;
	String baseUrl, nodeUrl;

	@BeforeTest
	public void setup() throws MalformedURLException {
		baseUrl = "http://www.google.com";
		nodeUrl = "http://192.168.1.35:5566/wd/hub";
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

	@Test
	public void simpleTest() {
		driver.get(baseUrl);
		Assert.assertEquals("Google", driver.getTitle());
	}
}