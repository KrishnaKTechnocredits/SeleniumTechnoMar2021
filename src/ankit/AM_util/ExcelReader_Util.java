package ankit.AM_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader_Util {

	public static Object[][] getExcelData(String filePath, String workingSheetName ) throws IOException {
		//Step 1 - Create object of Class File and pass the file location in its constructor
		File file = new File(filePath);
		//Step 2 - Create an object of class FileInputStream and pass file object into its cosntructor.
		FileInputStream inputStream = new FileInputStream(file);
		//Step 2 - Create an object of Workbook (Workbook is from Apache POI jars) it will take Full workbook control
		Workbook wb = new XSSFWorkbook(inputStream);
		//Step 4 - Get the working sheet control and save it as workingSheet
		Sheet workingSheet = wb.getSheet(workingSheetName);
		//Step 5 - Get the count of Rows with data in Sheet selected it will give value 1 less than actual; because it work based on Index starts from 0
		// So adjusting the value by adding + 1 to get actual row counts
		int totalRowCounts =  workingSheet.getLastRowNum()+1;
		System.out.println(totalRowCounts);
		//Step 6 - get the count of last cell as cells are on row so we need to get row 0 first and then on that we will take last column and it works on count so no adjustment required
		int totalColumnCount = workingSheet.getRow(0).getLastCellNum();
		System.out.println(totalColumnCount);
		Object[][] data = new Object[totalRowCounts][totalColumnCount];

		for(int rowIndex = 0 ; rowIndex < totalRowCounts ; rowIndex++) {
			for(int colIndex = 0 ; colIndex < totalColumnCount ; colIndex++) {
				data[rowIndex][colIndex] = workingSheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();	
			}
		}
		return data;
	}
}
