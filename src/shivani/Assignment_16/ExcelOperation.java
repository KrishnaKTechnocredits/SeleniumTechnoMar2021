package shivani.Assignment_16;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {
	public static Object[][] ExcelOp(String path,String sheetname) throws IOException {
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);

		Sheet sheet = wb.getSheet(sheetname);
		int totalRows = sheet.getLastRowNum() + 1;
		System.out.println("total rows " + totalRows);

		int totalcolumn = sheet.getRow(0).getLastCellNum();
		System.out.println("total column " + totalcolumn);

		Object[][] data = new Object[totalRows][totalcolumn];
		for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < totalcolumn; columnIndex++) {
				data[rowIndex][columnIndex] = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();

			}
		}
		
		wb.close();
		return data;
	}

}
