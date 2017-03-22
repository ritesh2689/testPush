package TestNGPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParallelExecution {
	
	WebDriver driver1,driver2,driver3;
	
	@BeforeTest()
	public void setup() {
		//To DO
	}

	@Test
	public void executSessionOne() {
		// First session of WebDriver
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver1 = new ChromeDriver();
		// Goto guru99 site
		driver1.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver1.findElement(By.name("uid")).sendKeys("Driver 1");
	}

	@Test
	public void executeSessionTwo() {
		// Second session of WebDriver
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver2 = new ChromeDriver();
		// Goto guru99 site
		driver2.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver2.findElement(By.name("uid")).sendKeys("Driver 2");
	}

	@Test
	public void executSessionThree() {
		// Third session of WebDriver
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver3 = new ChromeDriver();
		// Goto guru99 site
		driver3.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver3.findElement(By.name("uid")).sendKeys("Driver 3");
	}

}
