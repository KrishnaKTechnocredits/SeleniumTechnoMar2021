package madhavi_Khasbage.Assignment_16;

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
		int totalRows = sheet.getLastRowNum() + 1;

		int totalColumn = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[totalRows][totalColumn];

		for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < totalColumn; columnIndex++) {
				data[rowIndex][columnIndex] = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
			}
		}

		wb.close();
		return data;
	}

}
