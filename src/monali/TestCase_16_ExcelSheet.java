package monali;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_16_ExcelSheet {
	
	@Test(dataProvider = "loginDetailsProvider")
	public void registrationLoginTest(String userName,String passWard,String alertExpectedText) throws InterruptedException {
		
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP - click on registration link");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP - enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(userName);
		
		System.out.println("STEP - enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(passWard);
		
		System.out.println("STEP - click on submit button");
		WebElement btnELement = driver.findElement(By.id("btnsubmitdetails"));
		btnELement.click();
		System.out.println("Verify - alert message");
		Alert alert = driver.switchTo().alert();
		String alterActualText = alert.getText();
		Assert.assertEquals(alertExpectedText,alterActualText);
		alert.accept();
	}
	
	@DataProvider(name = "loginDetailsProvider")
	public Object[][] login() throws IOException{
		File file = new File("E:\\workspaceSelenium\\SeleniumTechnoMar2021\\src\\monali\\resource\\logindata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		
		Sheet sheet= wb.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum()+1;
		System.out.println("total rows "+totalRows);
		
		int totalcolumn = sheet.getRow(0).getLastCellNum();
		System.out.println("total column "+totalcolumn);
		
		Object[][] data = new Object[totalRows][totalcolumn];
		for(int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			for(int columnIndex = 0; columnIndex < totalcolumn; columnIndex++) {
				data[rowIndex][columnIndex] = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
				
				}
		}
		return data;
		
	}

}
