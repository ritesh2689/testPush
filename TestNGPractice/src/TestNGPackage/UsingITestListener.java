package TestNGPackage;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerImplementation.class)
public class UsingITestListener {

	@Test
	public void testReportTrue() {
		Assert.assertTrue(true);
	}

	@Test
	public void testRealReportTwo() {
		Assert.assertTrue(false);
	}

	// Test case depends on failed testcase= testRealReportTwo
	@Test(dependsOnMethods = "testRealReportTwo")
	public void testRealReportThree() {
	}
}
