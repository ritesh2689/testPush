package TestNGPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SiblingAndParentInXPath {

	@Test
	public void testSiblingAndParentInXpath() {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		List<WebElement> elements = driver.findElements(By.xpath(""));
	}
}
