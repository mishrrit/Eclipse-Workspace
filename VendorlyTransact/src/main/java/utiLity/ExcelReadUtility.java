package utiLity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vendorly.Main.baseClass;

public class ExcelReadUtility extends baseClass {

	public static String TestDataSheetPath = "C:\\Users\\mishrrit\\eclipse-workspace\\VendorlyTransact\\src\\main\\java\\testdata\\InputSheet.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static Object[][] ReadFromExcel() {

		FileInputStream file = null;

		try {
			file = new FileInputStream(TestDataSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet("Orders");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;

	}

}
