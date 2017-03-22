package Utilities;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import session.DriverSession;
import Utilities.Keywords;

public class Keywords {
	public static AppiumDriver a_Driver;
	public static WebDriver driver;

	static {
		Keywords.driver = DriverSession.getLastExecutionDriver();
	}

	public Keywords(AppiumDriver A_driver) { // ##U
		try {
			a_Driver = A_driver;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Keywords() {

	}

	public static void click(WebElement element) {
		try {
			element.click();
			GlobalVar.StepsReport = true;
		} catch (Exception ee) {
			GlobalVar.StepsReport = false;
		}
	}

	// to type text in element
	public static void typeText(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			GlobalVar.StepsReport = true;
		} catch (Exception ee) {
			GlobalVar.StepsReport = false;
		}
	}
}
