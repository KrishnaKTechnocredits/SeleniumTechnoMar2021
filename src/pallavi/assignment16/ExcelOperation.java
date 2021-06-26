package pallavi.assignment16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {

	public static Object[][] readExcel(String fileName,String sheetname) throws IOException {
		File file = new File(".//testData/" +fileName);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet(sheetname);

		int totalRows = sheet.getLastRowNum() + 1;
		System.out.println("Total rows ->" + totalRows);

		int totalcol = sheet.getRow(0).getLastCellNum();
		System.out.println("Total col ->" + totalcol);

		Object[][] data = new Object[totalRows][totalcol];
		for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			for (int colIndex = 0; colIndex < totalcol; colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		wb.close();
		return data;

	}
}
