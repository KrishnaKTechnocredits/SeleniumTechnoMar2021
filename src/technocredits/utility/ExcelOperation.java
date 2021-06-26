package technocredits.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {

	public static Object[][] readExcel(String fileName,String sheetName) throws IOException {
		File file = new File(".//testdata/"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		
		Sheet sheet = wb.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum()+1;
		System.out.println("total rows -> " + totalRows); // 0->3
		
		int totalCol = sheet.getRow(0).getLastCellNum();
		System.out.println("total col -> " + totalCol); // 3
		
		Object[][] data = new Object[totalRows][totalCol];
		for(int rowIndex=0;rowIndex<totalRows;rowIndex++) {
			for(int colIndex=0;colIndex<totalCol;colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
}
