package TestNGPackage;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "SearchProvider")
	public static Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("testMethodA")) {
			return new Object[][] { { "RVQA", "India" }, { "Ritesh", "UK" },
					{ "Vashisth", "USA" }, };
		} else {
			return new Object[][] { { "author1", "search1" },
					{ "author2", "search2" }, { "author3", "search3" } };
		}
	}
}
