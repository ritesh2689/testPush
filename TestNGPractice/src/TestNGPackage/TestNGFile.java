package TestNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGFile {

	public WebDriver driver;

	@BeforeTest
	public void SetBrowser() {
		driver = new FirefoxDriver();
	}

	public String baseurl = "http://newtours.demoaut.com/";
	public String ExpTitle = "Welcome: Mercury Tours";

//	@Test(priority=2)
//	public void CheckPageTitle() throws InterruptedException {
//		driver.get(baseurl);
//		Thread.sleep(2000);
//		String ActTitle = driver.getTitle();
//		Assert.assertEquals(ActTitle, ExpTitle);
//	}

	@Test(priority=2)
	public void c_test() {
		Assert.assertTrue(true);
	}

	
	@Test(priority=0)
	public void a_test() {
		Assert.assertTrue(true);
	}

	@Test(priority=1)
	public void b_test() {
		Assert.assertTrue(false);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
