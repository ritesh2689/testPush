package session;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;

import testCaseReporting.SuiteReporting;
import testCaseReporting.TestCaseReporting;
import Utilities.ExcelUtility;
import Utilities.GlobalVar;
import Utilities.Utility;

public class TestCase {
	Object o[] = null;
	ExcelUtility exlUtil = new ExcelUtility();
	DriverFactory df = null;
	ArrayList<String> actioncomponent = null;
	Utility commonUtility = new Utility();
	TestCaseReporting testCaseReporting = null;
	int startPoint = 1;
	private static int testCaseNumber = 1;

	public void testCaseExecuter(Object ac, PlatFormEnvSet platFormEnv)
			throws Exception {
		initializeTestCaseVars(platFormEnv);
		/*
		 * if (GlobalVar.RunAllOnServerIP)
		 * platFormEnv.setIP(GlobalVar.serverIP);
		 */

		if (platFormEnv.getIP().equalsIgnoreCase(GlobalVar.serverIP)
				|| GlobalVar.FEATURE_TYPE.equalsIgnoreCase("mobile")) {
			while (startPoint <= platFormEnv.getEndScriptDataRow()) {
				// int endpoint=platFormEnv.getEndScriptDataRow();
				GlobalVar.BrowserName = platFormEnv.getDesktopWebBrowserName();
				String testCaseName = setTestCaseSession(platFormEnv
						.getTestCaseName());
				System.out.println(SuiteReporting.pathToSuiteFolder
						+ "/TestCase/" + testCaseName + " ("
						+ GlobalVar.CURRENT_EXECUTION_MODE + ")_"
						+ GlobalVar.BrowserName + ".html");

				exlUtil.fetchTestCaseData(startPoint);
				testCaseReporting.header();
				Class<?> testCaseComponent = ac.getClass();
				Method[] testCaseMethod = testCaseComponent
						.getDeclaredMethods();
				try {
					for (String actionCom : actioncomponent) {
						if (actionCom.isEmpty())
							break;
						for (Method m : testCaseMethod) {
							try {
								if (GlobalVar.ExitTestCase == false) {
									if (m.getName().equalsIgnoreCase(actionCom)) {
										m.invoke(ac, o);
										break;
									}
								} else if (m.getName().equalsIgnoreCase(
										"closeApplication")
										|| m.getName().equalsIgnoreCase(
												"closeAPI")) {
									m.invoke(ac, o);
									break;
								}
							} catch (Exception e) {
								if (GlobalVar.mergeCase == false)
									GlobalVar.driver.quit();
								throw new Exception(e.getMessage());
							}
						}
					}
				} catch (Exception e) {
					DriverSession.getLastExecutionReportingInstance().footer();
					System.out.println("Exception throw : Exit from TestCase");
				}
				GlobalVar.ExitTestCase = false;
				startPoint++;
			}
		}
	}

	private String setTestCaseSession(String testCaseName) throws SQLException {
		DriverFactory df = new DriverFactory(GlobalVar.CURRENT_EXECUTION_MODE);
		DriverSession.setLastExecutionDriver(df.getDriver());

		if (GlobalVar.CURRENT_EXECUTION_MODE.contains("Web")) {
			GlobalVar.url = df.getUrl(GlobalVar.serverName);
			GlobalVar.vendorUrl = df.getVendorUrl();
		}

		/*if (GlobalVar.CURRENT_EXECUTION_MODE.equalsIgnoreCase("API")) {
			GlobalVar.url = df.getUrl(GlobalVar.serverName);
			GlobalVar.staticKey = df.getStaticKey();
		}*/
		try {
			if (GlobalVar.detailReporting == true)
				testCaseName = String.format("%03d", testCaseNumber) + "_"
						+ testCaseName;
		} catch (Exception ex) {

		}
		testCaseReporting = new TestCaseReporting(testCaseName);
		DriverSession.setLastExecutionReportingInstance(testCaseReporting);
		testCaseNumber++;
		return testCaseName;
	}

	public void initializeTestCaseVars(PlatFormEnvSet platFormEnv) {
		if (GlobalVar.CURRENT_EXECUTION_MODE.equalsIgnoreCase("api")) {
			/*
			 * actioncomponent =
			 * commonUtility.fetchActionComponentApi(platFormEnv
			 * .getTestCaseName()); GlobalVar.CURRENT_TEST_CASE_NAME =
			 * platFormEnv.getTestCaseName(); startPoint =
			 * platFormEnv.getStartScriptDataRow();
			 */
		} else {
			actioncomponent = commonUtility.fetchActionComponent(platFormEnv
					.getTestCaseName());
			GlobalVar.CURRENT_TEST_CASE_NAME = platFormEnv.getTestCaseName();
			startPoint = platFormEnv.getStartScriptDataRow();
		}
	}
}