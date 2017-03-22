package com.Shopo;

import java.util.ArrayList;

import applicationComponent.AndroidAppAc;
import applicationComponent.AndroidWebAc;
import applicationComponent.BackEndWebAC;
import applicationComponent.WebAC;

import com.Shopo.Controller;
import com.Shopo.Controller;

import session.PlatFormEnvSet;
import session.TestCase;
import testCaseReporting.SuiteReporting;
import Utilities.GlobalVar;
import Utilities.Utility;

public class Controller {
	TestCase testCase = new TestCase(); // Object, defined for TestCase class
	static SuiteReporting suitreporting; // Object, defined for SuiteReporting
											// class

	// To iterate the list of test-cases to be executed frsm Suite.ods
	public void suitExecuter(ArrayList<PlatFormEnvSet> totalTestCases) {
		// To define variables
		Object oAppComponent = null; // Object, defined for application
										// component

		// 'try-catch' block to handle predefined exceptions
		try {
			for (PlatFormEnvSet platFormEnv : totalTestCases) {
				// Case; when test-script to be executed on Desktop| Web-Browser
				// environment
				if (platFormEnv.isDesktopWeb()) {
					GlobalVar.CURRENT_EXECUTION_MODE = "DesktopWeb";
					if (GlobalVar.FEATURE_TYPE.equalsIgnoreCase("MOBILE"))
						oAppComponent = new AndroidWebAc();
					else
						oAppComponent = new WebAC();
					testCase.testCaseExecuter(oAppComponent, platFormEnv);
				}

				// Case; when test-script to be executed on Mobile| Android WAP
				// environment
				if (platFormEnv.isAndroidWeb()) {
					GlobalVar.CURRENT_EXECUTION_MODE = "androidWeb";
					oAppComponent = new AndroidWebAc();
					testCase.testCaseExecuter(oAppComponent, platFormEnv);
				}

				// Case; when test-script to be executed on Mobile| Android APP
				// environment
				if (platFormEnv.isAndroidApp()) {
					GlobalVar.CURRENT_EXECUTION_MODE = "androidApp";
					oAppComponent = new AndroidAppAc();
					testCase.testCaseExecuter(oAppComponent, platFormEnv);
				}

				// Case; when test-script to be executed via APIs
				/*
				 * if (platFormEnv.isAPIStatus()) {
				 * GlobalVar.CURRENT_EXECUTION_MODE = "API";
				 * System.setProperty("jsse.enableSNIExtension", "false");
				 * oAppComponent = new APIExecuter();
				 * testCase.testCaseExecuter(oAppComponent, platFormEnv); }
				 */

				// Case; when test-script to be executed for Back-End| Web
				// Application
				if (platFormEnv.isBackEndWeb()) {
					GlobalVar.CURRENT_EXECUTION_MODE = "backEndWeb";
					oAppComponent = new BackEndWebAC();
					testCase.testCaseExecuter(oAppComponent, platFormEnv);
				}
			}

			// To summarize Test-Suite results, to be displayed in HTML results'
			// file footer
			// suitreporting.consolidateResultFooter();
			if (GlobalVar.mergeCase == true)
				GlobalVar.driver.quit();
		}
		// Catch exceptions at global level and print stack-trace
		catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			Controller c;

			GlobalVar.FEATURE_TYPE = args[0];
			GlobalVar.serverName = args[1];

			suitreporting = new SuiteReporting("Suite");
			c = new Controller();
			// suitreporting.setSuiteNameWithIp();
			// Object, defined for 'Controller' class
			Utility commonUtility = new Utility();

			// To initiate environment settings for 'Utility' instance
			try {
				commonUtility.initEnvSettings();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// To set platform settings for all iterated test-scripts
			ArrayList<PlatFormEnvSet> totalTestCase;
			totalTestCase = commonUtility.setPlatformSettingToAllTestCase();
			c.suitExecuter(totalTestCase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
