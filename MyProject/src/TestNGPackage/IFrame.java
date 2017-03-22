package TestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrame {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.in");
	}

	/*
	 * @Test public void getIFrameCount() throws InterruptedException {
	 * WebDriver driver = new FirefoxDriver();
	 * driver.get("http://www.guru99.com/software-testing.html"); // int
	 * frameCount = driver.findElements(By.tagName("iframe")).size(); //
	 * System.out.println(frameCount);
	 * 
	 * driver.manage().window().setSize(new Dimension(400, 500));
	 * 
	 * // driver.manage().window().maximize();
	 * 
	 * // driver.switchTo().frame(1);
	 * 
	 * String title = driver.getTitle(); System.out.println(title); //
	 * driver.switchTo().defaultContent(); }
	 */

	/*
	 * //set window size,get window size
	 * 
	 * @Test public void setGetWinSize() { // WebDriver setSize method used to
	 * set window size width = 300 and // height = 500.
	 * driver.manage().window().setSize(new Dimension(300, 500));
	 * 
	 * // WebDriver getSize method used to get window width and height.
	 * System.out.println("Window height Is -> " +
	 * driver.manage().window().getSize().getHeight());
	 * System.out.println("Window width Is -> " +
	 * driver.manage().window().getSize().getWidth()); }
	 */

	@Test
	public void scrollScreen() throws InterruptedException {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript(
				"window.scrollTo(0, document.body.scrollHeight)", "");
		/*
		 * javascript.executeScript("window.scrollBy(0,700)", "");
		 * Thread.sleep(3000);
		 * javascript.executeScript("window.scrollBy(0,-300)", "");
		 */
	}
}
