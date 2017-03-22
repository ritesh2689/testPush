package TestNGPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TakeScreenShot {

	@Test
	public void testTakeScreenShot() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		takeSnapShot(driver, "E://test.png");

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath)
			throws Exception {

		// Convert web driver object to TakeScreenShot
		TakesScreenshot scrShot = (TakesScreenshot) webdriver;

		// Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file to destination
		FileUtils.copyFile(srcFile, DestFile);
	}

}
