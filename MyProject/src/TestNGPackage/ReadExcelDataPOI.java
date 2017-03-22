package TestNGPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataPOI {

	public void readExcel(String filePath, String fileName, String sheetName)
			throws IOException {
		// Create an object of file class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file.
		FileInputStream inputStream = new FileInputStream(file);

		Workbook myWorkBook = null;

		// Find file extension by splitting file name in substring and getting
		// only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {

			// if it is xlsx file then create object of XSSFWorkbook class
			myWorkBook = new XSSFWorkbook(inputStream);
		}

		// Check condition if file is xls file
		if (fileExtensionName.equals(".xls")) {

			// if it is xlsx file then create object of XSSFWorkbook class
			myWorkBook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet mySheet = myWorkBook.getSheet(sheetName);

		// Find number of rows in excel file
		int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = mySheet.getRow(i);

			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print excel data in console
				System.out.print(row.getCell(j).getStringCellValue() + "||");
			}
			System.out.println();
		}
	}

	// Main function is calling readExcel function to read data from excel file
	public static void main(String args[]) throws IOException {
		String filePath = System.getProperty("user.dir")
				+ "\\src\\excelExportAndFileIO";
		ReadExcelDataPOI readData = new ReadExcelDataPOI();
		readData.readExcel(filePath, "ReadExcel.xlsx", "myExcelSheet");
	}

}
