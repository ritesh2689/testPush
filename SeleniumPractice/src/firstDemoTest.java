import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class firstDemoTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String expectedTitle = "Facebook - Log In or Sign Up";
		String baseUrl = "http://www.facebook.com";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println("testing");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (expectedTitle.equals(actualTitle))
			System.out.println("titles are matched");

		// WebElement emailField = driver
		// .findElement(By.xpath("//*[@id='email']"));
		// emailField.clear();
		// emailField.sendKeys("vashisth.ritesh");
		//
		// WebElement passwordField = driver.findElement(By
		// .xpath("//*[@id='pass']"));
		// passwordField.clear();
		// passwordField.sendKeys("February@1234");
		//
		// WebElement loginButton = driver.findElement(By
		// .xpath("//*[@type='submit' and @value='Log In']"));
		// loginButton.click();
		//
		// WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		// .until(ExpectedConditions.presenceOfElementLocated(By
		// .id("fbRequestsJewel")));
		// boolean result = myDynamicElement.isDisplayed();
		// System.out.println(result);

		WebElement firstName = driver.findElement(By
				.xpath("//*[@type='text' and @name='firstname']"));
		firstName.clear();
		firstName.sendKeys("testfirstname");

		WebElement surName = driver.findElement(By
				.xpath("//*[@type='text' and @name='lastname']"));
		surName.clear();
		surName.sendKeys("testLastName");

		WebElement regEmailField = driver.findElement(By
				.xpath("//*[@type='text' and @name='reg_email__']"));
		regEmailField.clear();
		regEmailField.sendKeys("test@tts.com");

		// reg_email_confirmation__
		WebElement regEmailConfirmation = driver
				.findElement(By
						.xpath("//*[@type='text' and @name='reg_email_confirmation__']"));
		regEmailConfirmation.clear();
		regEmailConfirmation.sendKeys("test@tts.com");

		// reg_passwd__
		WebElement regPasswd = driver.findElement(By
				.xpath("//*[@type='password' and @name='reg_passwd__']"));
		regPasswd.clear();
		regPasswd.sendKeys("test@123");

		// dropDown
		Select birthDayDropDown = new Select(driver.findElement(By
				.name("birthday_day")));
		birthDayDropDown.selectByValue("26");

		Select birthMonthDropDown = new Select(driver.findElement(By
				.name("birthday_month")));
		birthMonthDropDown.selectByValue("2");

		Select birthYearDropDown = new Select(driver.findElement(By
				.name("birthday_year")));
		birthYearDropDown.selectByValue("1990");

		// gender radio button
		WebElement element = driver.findElement(By
				.xpath("//*[@type='radio' and @name='sex' and @value='2']"));
		element.click();

		// web submit button
		WebElement createAccountButton = driver.findElement(By
				.xpath("//*[@type='submit' and @name='websubmit']"));
		createAccountButton.click();

		// reg error
		WebElement regError = driver.findElement(By.id("reg_error_inner"));
		boolean regErrorPresence = false;

		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions
						.visibilityOf(regError));

		regErrorPresence = regError.isDisplayed();
		System.out.println("error message present? " + regErrorPresence);

		// driver.quit();
		
		//-----------------------------------------------------------------
		
	}
}
