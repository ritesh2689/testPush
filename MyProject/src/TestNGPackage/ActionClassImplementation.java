package TestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassImplementation {

	 @Test
	 public void actionDemoSimpleCase() throws InterruptedException {
	 WebDriver driver = new FirefoxDriver();
	 String baseUrl = "http://newtours.demoaut.com/";
	 driver.get(baseUrl);
	 Thread.sleep(5000);
	 WebElement link_Home = driver.findElement(By.linkText("Home"));
	 Actions builder = new Actions(driver);
	 Action mouseOverHome = builder.moveToElement(link_Home).build();
	
	 WebElement td_Home = driver.findElement(By.xpath("//html/body/div"
	 + "/table/tbody/tr/td" + "/table/tbody/tr/td"
	 + "/table/tbody/tr/td" + "/table/tbody/tr"));
	 String bg_color_before = td_Home.getCssValue("background-color");
	
	 mouseOverHome.perform();
	 String bg_color_after = td_Home.getCssValue("background-color");
	 System.out.println("bg_color_before " + bg_color_before);
	 System.out.println("bg_color_after " + bg_color_after);
	 }

	// @Test
	// public void multipleActions() {
	// WebDriver driver = new FirefoxDriver();
	// String baseUrl = "http://facebook.com/";
	// driver.get(baseUrl);
	// WebElement element = driver.findElement(By.id("email"));
	// Actions builder = new Actions(driver);
	// Action seriesOfActions = builder.moveToElement(element).click()
	// .keyDown(element, Keys.SHIFT).sendKeys("hello")
	// .keyUp(element, Keys.SHIFT).doubleClick().contextClick()
	// .build();
	// seriesOfActions.perform();
	//
	// }

	@Test
	public void uploadFile() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.megafileupload.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//String filePath = "C:\\Users\\ritesh.vashisth\\Desktop\\sampleTest.txt";
		WebElement element = driver.findElement(By
				.xpath(".//*[@id='revslider-822']/ul/li/div[4]"));
		element.getText();
		//driver.switchTo().alert();
//		WebElement ele2 = driver.findElement(By
//				.id(".//div[@id='initialUploadSection']/div[1]/div/div"));
//		ele2.click();
		// ele2.sendKeys(filePath);

	}
}
