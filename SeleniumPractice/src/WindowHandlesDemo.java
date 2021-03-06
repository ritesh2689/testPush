import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlesDemo {

	public static void main(String args[]) {

		// System.setProperty("webdriver.chrome.driver",
		// "E://chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.findElement(By.tagName("a")).click();

		String mainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String childWindow = i1.next();
			driver.switchTo().window(childWindow);
			try {
				driver.findElement(By.xpath("//*[@type='text']")).sendKeys(
						"wfwf@fg.com");
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// switching to parent window
		driver.switchTo().window(mainWindow);
		System.out.println(driver.findElement(By.tagName("a")).getText());
	}

}
