package TestPackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AppLocators.LoginPage;
import Utilities.Keywords;

public class MyClass {

	LoginPage login = new LoginPage();
	Keywords keyWords = new Keywords();

	WebDriver driver;
	WebElement element = null;

	@BeforeClass
	public void initiateAndroidAppSession() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("browserName", "");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appActivity",
				"com.shopo.ui.activites.ActivitySplashGuide");
		capabilities.setCapability("appPackage", "com.shopo");
		capabilities.setCapability("deviceName", "Android");

		System.out.println("Going to trigger through Appium");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);

	}

	@Test
	public void testCal() {
		System.out.println("Starting Test Phase");
		element = LoginPage.getInstance().nameEditBox(driver);
		Keywords.click(element);
		Keywords.typeText(element, "RiteshV");
	}

	public void clickHamburger() {
		String ProdName = null;
		System.out.println("Inside clickHamburger");
		List<WebElement> element = LoginPage.getInstance()
				.hamburgerIcon(driver);
		for (WebElement element2 : element) {
			elementName = Keywords. // .getText(element2);
			Keywords.click(element2);
			break;
		}
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
