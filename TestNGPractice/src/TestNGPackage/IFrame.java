package TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class IFrame {

	@Test
	public void getIFrameCount() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.guru99.com/software-testing.html");
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameCount);

		driver.manage().window().maximize();
		driver.switchTo().frame(1);

		String title = driver.getTitle();
		System.out.println(title);
		driver.switchTo().defaultContent();
	}
}
