package priyanka_Panat.TestCase_16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {
	public static Object[][] readExcel(String path,String sheetName) throws IOException  {
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum()+1;
		System.out.println(totalRows);
		int totalCol = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Col:" + totalCol);

		Object[][] data = new Object[totalRows][totalCol];
		for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			for (int colIndex = 0; colIndex < totalCol; colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
}
