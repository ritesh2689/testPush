package Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import session.PlatFormEnvSet;
import Utilities.OdsFileUtility;
import Utilities.GlobalVar;

public class Utility {
	Properties prop = null;
	ArrayList<PlatFormEnvSet> totalTestCases = new ArrayList<PlatFormEnvSet>();

	public void initEnvSettings() throws Exception {

		try {
			int portNumber = generatePortNumber();
			// The method will start appium even when there is no Android
			// cases are run
			startAppium(portNumber);
			// GlobalVar.appiumPort = portNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int generatePortNumber() { // ##U
		Random rand = new Random();
		int max = 16000;
		int min = 11500;
		int randomNum = rand.nextInt((max - min) - 1) + min;
		return randomNum;
	}

	private void startAppium(int port) {
		Process p;
		System.out.println("Port number is: " + port);
		String command = "/Applications/Appium.app/Contents/Resources/node/bin/node /Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js --address 127.0.0.1 --port "
				+ port
				+ " --log /Users/shopclues/DailyRunNew/Jobs/AppiumOutput/app"
				+ port
				+ ".log"
				+ " --chromedriver-port 9516 --bootstrap-port 4725 --selendroid-port 8082 --no-reset --local-timezone"
				+ " --platform-version 4.4 --automation-name Appium --command-timeout 60 --device-ready-timeout 10";
		try {
			p = Runtime.getRuntime().exec(command);
			GlobalVar.appiumProcess = p;
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PlatFormEnvSet> setPlatformSettingToAllTestCase()
			throws Exception {
		int totalRows = 0;
		try {
			// String suitExc = GlobalVar.CURRENT_PROJECT_PATH
			// + "/TestRepository/TestSuite/TestSuite.ods";
			String suitExc = "E:/TestRepository/TestSuite/TestSuite.ods";
			/*
			 * if (GlobalVar.FEATURE_TYPE.equalsIgnoreCase("admin")) { suitExc =
			 * GlobalVar.CURRENT_PROJECT_PATH +
			 * "/TestRepository/TestSuite/ShopClues_AdminSuite.ods"; } else if
			 * (GlobalVar.FEATURE_TYPE.equalsIgnoreCase("mobile")) { suitExc =
			 * GlobalVar.CURRENT_PROJECT_PATH +
			 * "/TestRepository/TestSuite/ShopClues_MobileSuite.ods"; } else if
			 * (GlobalVar.FEATURE_TYPE.equalsIgnoreCase("frontend")) { suitExc =
			 * GlobalVar.CURRENT_PROJECT_PATH +
			 * "/TestRepository/TestSuite/ShopClues_FrontEndSuite.ods"; }
			 */
			File file = new File(suitExc);
			Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);

			totalRows = OdsFileUtility.getTotalNumberOfRows(suitExc);
			System.out.println("Total rows : " + totalRows);
			for (int i = 1; i < totalRows; i++) {
				PlatFormEnvSet plt = new PlatFormEnvSet();
				// System.out.println("plat object is " + plt);

				// System.out.println("rowcount " + i);

				plt.setTestCaseName(sheet.getCellAt(1, i).getValue().toString());
				// System.out.println("testCAseName is " + sheet.getCellAt(1,
				// i).getValue().toString());

				plt.setDesktopWebBrowserName(sheet.getCellAt(2, i).getValue()
						.toString());
				// System.out.println("Browser Name is "
				// + sheet.getCellAt(2, i).getValue().toString());

				plt.setDesktopWeb(Boolean.parseBoolean(sheet.getCellAt(3, i)
						.getValue().toString()));
				// System.out.println("DeskTop status is " + sheet.getCellAt(3,
				// i).getValue().toString());

				plt.setAndroidWeb(Boolean.parseBoolean(sheet.getCellAt(4, i)
						.getValue().toString()));
				// System.out.println("Adroid web status is "
				// + sheet.getCellAt(4, i).getValue().toString());

				plt.setAndroidApp(Boolean.parseBoolean(sheet.getCellAt(5, i)
						.getValue().toString()));
				// System.out.println("Adroid app status is "
				// + sheet.getCellAt(5, i).getValue().toString());

				plt.setBackEndWeb(Boolean.parseBoolean(sheet.getCellAt(6, i)
						.getValue().toString()));
				// System.out.println("BackEnd Web status is "
				// + sheet.getCellAt(6, i).getValue().toString());

				/*
				 * plt.setAPIStaus(Boolean.parseBoolean(sheet.getCellAt(7, i)
				 * .getValue().toString()));
				 */
				// System.out.println(sheet.getCellAt(7,
				// i).getValue().toString());

				plt.setStartScriptDataRow(Integer.parseInt(sheet
						.getCellAt(8, i).getValue().toString()));
				// System.out.println(sheet.getCellAt(8,
				// i).getValue().toString());

				plt.setEndScriptDataRow(Integer.parseInt(sheet.getCellAt(9, i)
						.getValue().toString()));
				// System.out.println(sheet.getCellAt(9,
				// i).getValue().toString());

				/*
				 * String IP; try { IP = sheet.getCellAt(10,
				 * i).getValue().toString(); } catch (Exception ex) { IP =
				 * "localhost"; } if (IP.trim().isEmpty()) IP = "localhost";
				 * 
				 * plt.setIP(IP);
				 */

				totalTestCases.add(plt);

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return totalTestCases;
	}

	public static HashMap<String, String> getOdsSheetData(String odsFilePath,
			String server, int rowNumber) {
		Sheet sheet = null;
		try {
			File file = new File(odsFilePath);
			sheet = SpreadSheet.createFromFile(file).getSheet(server);
			fetchRowDataOds(sheet, rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fetchRowDataOds(sheet, rowNumber);
	}

	public static HashMap<String, String> fetchRowDataOds(Sheet sheet,
			int rowNumber) {
		HashMap<String, String> rowData = new HashMap<String, String>();
		for (int i = 0; i < sheet.getColumnCount(); i++) {
			rowData.put(sheet.getValueAt(i, 0).toString(),
					sheet.getValueAt(i, rowNumber).toString());
		}
		return rowData;
	}

	public ArrayList<String> fetchActionComponent(String testCaseName) {
		ArrayList<String> actionComponent = new ArrayList<String>();

		try {
			String testCaseOds = System.getProperty("user.dir")
					+ "/TestRepository/TestCases/" + testCaseName + ".ods";
			GlobalVar.TestexcelPath = testCaseOds;
			File file = new File(testCaseOds);
			Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);

			for (int i = 1; i < sheet.getRowCount(); i++) {
				// sheet.getValueAt(0, i).toString();
				actionComponent.add(sheet.getValueAt(0, i).toString());
				// //System.out.println(sheet.getValueAt(0, i).toString());
			}

			// String testCaseExcel = System.getProperty("user.dir")
			// + "\\TestRepository\\TestCases\\" + testCaseName + ".xls";
			// GlobalVar.TestexcelPath = testCaseExcel;
			// ExcelUtility exlUtil = new ExcelUtility();
			// Workbook workbook = exlUtil.openWorkbook(testCaseExcel);
			// Sheet sheet = exlUtil.getSheetHandel(workbook, 0);

			// for (int i = 1; i < sheet.getRows(); i++) {
			// Cell[] c = sheet.getRow(i);
			// actionComponent.add(c[0].getContents());

			// }
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return actionComponent;
	}
}
