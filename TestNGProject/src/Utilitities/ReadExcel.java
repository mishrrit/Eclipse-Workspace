package Utilitities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static XSSFWorkbook Workbook;
	public static XSSFSheet WorkSheet;
	public static void ReadExcelData(String path,String Sheet) throws Exception {
		
		File file = new File(path);
				
		FileInputStream fis = new FileInputStream(file);
				
		Workbook = new XSSFWorkbook(fis);
		WorkSheet = Workbook.getSheet(Sheet);
		
		Iterator<Row> rowIterator = WorkSheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				
				Cell cell = cellIterator.next();
				switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "|");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "|");
                        break;
                }
			}
			System.out.println();
		}
		fis.close();	
				
	}

}
