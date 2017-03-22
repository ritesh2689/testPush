package TestNGPackage;

import java.util.StringTokenizer;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testing {

	public static void main(String[] args) {
		// int number = 1234;
		// int rev = 0;
		// int rem = 0;
		// while (number != 0) {
		// rem = number % 10;
		// rev = rev * 10 + rem;
		// number = number / 10;
		// }
		// int count;
		// for (int i = 2; i <= 50; i++) {
		// count=0;
		// for (int j = 2; j <= i / 2; j++) {
		// if (i % j == 0) {
		// count++;
		// }
		// break;
		// }
		// if (count == 0) {
		// System.out.println(i);
		// }
		// }

		// find 2 largest element from array
		// int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 0, 10 };
		// int maxOne = 0;
		// int maxTwo = 0;
		// for (int n : arr) {
		// if (maxOne < n) {
		// maxTwo = maxOne;
		// maxOne = n;
		// } else if (maxTwo < n)
		// maxTwo = n;
		// }
		// System.out.println(maxOne);
		// System.out.println(maxTwo);

		/*
		 * String name = "Ritesh"; int count = name.length(); String newString =
		 * ""; for (int i = 0; i <= count - 1; i++) { if (name.charAt(i) == 'R')
		 * newString = newString + 'H'; else { newString = newString +
		 * name.charAt(i); } } System.out.println(newString);
		 */

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().setSize(new Dimension(300, 500));
	}
}
