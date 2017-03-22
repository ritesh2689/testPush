package TestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParameterizationByMethodInDataProvider {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}

	@Test(dataProvider = "SearchProvider", dataProviderClass = DataProviderClass.class)
	public void testMethodA(String author, String searchKey)
			throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome ->" + author + " Your search key is->"
				+ searchKey);
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue + "::::" + searchKey);
		searchText.clear();
		// Verify if google text box is showing correct value
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}
}
