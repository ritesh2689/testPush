package TestNGPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataPOI {

	public void writeExcel(String filePath, String fileName, String sheetName,
			String[] dataToWrite) throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream fileinputStream = new FileInputStream(file);

		Workbook myWorkBook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			myWorkBook = new XSSFWorkbook(fileinputStream);
		} else if (fileExtensionName.equals(".xls")) {
			myWorkBook = new HSSFWorkbook(fileinputStream);
		}

		Sheet sheet = myWorkBook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		Row row = sheet.getRow(0);

		// create a new row and append at the end of sheet
		Row newRow = sheet.createRow(rowCount + 1);

		// create a loop over the cell of newly created Row
		for (int i = 0; i < row.getLastCellNum(); i++) {

			// Fill Data in row
			Cell cell = newRow.createCell(i);
			cell.setCellValue(dataToWrite[i]);
		}

		// Close input Stream
		fileinputStream.close();

		// Create an object of FileOutputStream class to create write data in
		// excel file
		FileOutputStream outputStream = new FileOutputStream(file);

		// write data in excel file
		myWorkBook.write(outputStream);

		// close output stream
		outputStream.close();

	}

	public static void main(String args[]) throws IOException {
		String[] dataToWrite = { "Ritesh", "Vashisth", "QA", "FC" };
		String filePath = System.getProperty("user.dir")
				+ "\\src\\excelExportAndFileIO";
		WriteExcelDataPOI writeExcelData = new WriteExcelDataPOI();
		writeExcelData.writeExcel(filePath, "WriteExcel.xlsx", "mySheet",
				dataToWrite);
	}

}
