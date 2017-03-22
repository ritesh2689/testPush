package TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserScript {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E://chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	@Test
	public void testParameterWithXML() {
		driver.get("http://demo.guru99.com/V4/");
		// Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		// Fill user name
		userName.sendKeys("testqa");
		// Find password
		WebElement password = driver.findElement(By.name("password"));
		// Fill password
		password.sendKeys("testqa");
	}

}
