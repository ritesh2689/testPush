package Utilities;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class OdsFileUtility {

	public static int getTotalNumberOfRows(String filePath) {
		Sheet sheet;
		int rows = 0;
		try {

			// Getting the 0th sheet for manipulation| pass sheet name as string
			sheet = SpreadSheet.createFromFile(new File(filePath)).getSheet(0);

			// Get row count and column count

			int nRowCount = sheet.getRowCount();

			// //System.out.println("Rows :"+nRowCount);

			// Iterating through each row of the selected sheet
			MutableCell<?> cell = null;
			for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
				cell = sheet.getCellAt(0, nRowIndex);
				// System.out.println(cell.getValue());
				if (cell.getValue().toString().equalsIgnoreCase("")) {
					rows = nRowIndex;
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/*
	 * public static void main(String[] args) { //Creating File object of .ods
	 * file //System.out.println(OdsFileUtility.getTotalNumberOfRows(
	 * "/home/shopclues/ShopClues/ShopCluesMobileAutomation/TestRepository/TestCases/test1.ods"
	 * ));
	 * 
	 * }
	 */
}
