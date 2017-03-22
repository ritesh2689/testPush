package AppLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import androidWAP.MobileLocators;

public class LoginPage {

	public static LoginPage getInstance() { // ##U
		LoginPage lPage = null;
		try {
			lPage = new LoginPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lPage;
	}

	public WebElement nameEditBox(WebDriver driver) {
		WebElement loginName = driver.findElement(By.id(""));
		return loginName;
	}

	// public WebElement hamburgerIcon(WebDriver driver) {
	// WebElement hamIcon = driver.findElement(By
	// .id("com.shopclues:id/action_more"));
	// return hamIcon;
	// }

	public List<WebElement> hamburgerIcon(WebDriver driver) {
		List<WebElement> element = driver.findElements(By
				.className("android.widget.ImageView")); // ("com.shopclues:id/header_text"));
		return element;
	}
}
