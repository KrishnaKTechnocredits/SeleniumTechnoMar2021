package monika.TC15_DataProvider_ExcelReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCodeCheck {

	public static void main(String[] args) throws IOException {
		/*
		 * File file = new File(".//src/monika/TC15/loginExcel.xlsx"); FileInputStream
		 * input = new FileInputStream(file);
		 * 
		 * Workbook wb = new XSSFWorkbook(input); Sheet s = wb.getSheet("Data");
		 * System.out.println(s.getRow(0).getCell(0));
		 * System.out.println(s.getRow(0).getCell(1));
		 * 
		 * System.out.println(s.getLastRowNum());
		 * System.out.println(s.getFirstRowNum());
		 * 
		 * System.out.println(s.getRow(0).getLastCellNum());
		 */

		File file = new File(".//src/monika/TC15/loginExcel.xlsx");
		FileInputStream input = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(input);
		Sheet s = wb.getSheet("Data");
		int totalRow = s.getLastRowNum() + 1;
		// System.out.println(totalRow);
		int totalCol = s.getRow(3).getLastCellNum();
		// System.out.println(totalCol);
		Object[][] obj = new Object[3][totalCol];
		int rowCounter = 0;
		 int cellCounter = 0;
		for (int rowIndex = 3; rowIndex < totalRow; rowIndex++) {
				cellCounter = 0;
			for (int colIndex = 0; colIndex < totalCol; colIndex++) {
				String data = s.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				 obj[rowCounter][cellCounter] = data;
				//System.out.println(obj[rowCounter][colIndex]);
				System.out.println(data);
				
				cellCounter++;
			}
			rowCounter++;
		}

	}

}
