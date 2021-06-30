package radha.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {
	
	public static Object[][] readFormExcel(String filepath, String sheetName) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet(sheetName);
		int totalRow = sheet.getLastRowNum()+1;
		System.out.println("Total Rows - "+totalRow);
		int totalCol = sheet.getRow(0).getLastCellNum();
		System.out.println("Total columns - "+totalCol);
		Object[][] data = new Object[totalRow][totalCol];
		for(int rowIndex =0; rowIndex<totalRow;rowIndex++) {
			for(int colIndex=0;colIndex<totalCol;colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}

}
