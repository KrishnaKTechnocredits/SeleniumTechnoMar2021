package sourabh.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelOperation {
	public static Object[][] readExcel(String fileName, String sheetName ) throws IOException {
		File file= new File(".//testData/"+fileName);
		FileInputStream inputStream= new FileInputStream(file);
		Workbook wb= new XSSFWorkbook(inputStream);
		
		Sheet sheet= wb.getSheet(sheetName);
		
		int totalRows= sheet.getLastRowNum()+1;// we have to add 1 for Rows.
		System.out.println("Total rows: "+totalRows);//3---> it will start from index 0. total= 0,1,2,3
	
		int totalCols= sheet.getRow(0).getLastCellNum();
		System.out.println("Total Col: "+totalCols);//3----> it will give total count.
		
		Object[][] data= new Object[totalRows][totalCols];
		
		for(int rowIndex=0; rowIndex<totalRows; rowIndex++) {
			for(int colIndex=0; colIndex<totalCols; colIndex++) {
				data[rowIndex][colIndex]= sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		return data;
	}

}
