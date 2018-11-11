package Utilitities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {

		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;

		String path = "C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\ExcelReader\\InputReader.xlsx";
		String Sheet = "Sheet1";

		try {
			FileInputStream file = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(file);
			ExcelWSheet = ExcelWBook.getSheet(Sheet);

			Cell = ExcelWSheet.getRow(0).getCell(0);
			String CellData = Cell.getStringCellValue();
			System.out.println(" Cell Value is " + CellData);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
