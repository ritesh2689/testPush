package TestNGPackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = IReporterImplementation.class)
public class UsingIReportListener {

	@Test(priority = 0, description = "testReporterOne")
	public void testReporterOne() {
		// Pass test case
		Assert.assertTrue(true);
	}

	@Test(priority = 1, description = "testReporterTwo")
	public void testReporterTwo() {
		// Fail test case
		Assert.assertTrue(false);
	}
}
