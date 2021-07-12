package monika.TC15_DataProvider_ExcelReading;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class RegistrationUsingExcel {
	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = PredefinedActions.start();
	}

	@Test(dataProvider = "successLoginDetails")
	public void verifySuccessRegistrationUnamePass(String uname, String pass, String result)
			throws InterruptedException {
		driver.findElement(By.id("registration2")).click();
		driver.findElement(By.id("unameSignin")).sendKeys(uname);
		driver.findElement(By.id("pwdSignin")).sendKeys(pass);
		driver.findElement(By.id("btnsubmitdetails")).click();
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, result);
		alert.accept();
	}

	@Test(dataProvider = "failLoginDetails")
	public void verifyFailRegistrationUnamePass(String uname, String pass, String expFailMsg)
			throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("registration2")).click();
		driver.findElement(By.id("unameSignin")).sendKeys(uname);
		driver.findElement(By.id("pwdSignin")).sendKeys(pass);
		driver.findElement(By.id("btnsubmitdetails")).click();
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expFailMsg);
		alert.accept();
	}

	@DataProvider(name = "successLoginDetails")
	public Object[][] successregistrationDetails() throws IOException {
		File file = new File(".//src/monika/TC15/loginExcel.xlsx");
		FileInputStream input = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(input);
		Sheet s = wb.getSheet("Data");
		int totalRow = s.getLastRowNum() - 2;
		int totalCol = s.getRow(0).getLastCellNum();

		Object[][] obj = new Object[totalRow][totalCol];

		for (int rowIndex = 0; rowIndex < totalRow; rowIndex++) {
			for (int colIndex = 0; colIndex < totalCol; colIndex++) {
				obj[rowIndex][colIndex] = s.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		return obj;
	}

	@DataProvider(name = "failLoginDetails")
	public static Object[][] failRegistrationDetails() throws IOException {
		File file = new File(".//src/monika/TC15/loginExcel.xlsx");
		FileInputStream input = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(input);
		Sheet s = wb.getSheet("Data");
		int totalRow = s.getLastRowNum() + 1;
		int totalCol = s.getRow(3).getLastCellNum();
		Object[][] obj = new Object[3][totalCol];
		int rowCounter = 0;
		for (int rowIndex = 3; rowIndex < totalRow; rowIndex++) {
			for (int colIndex = 0; colIndex < totalCol; colIndex++) {
				String data = s.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				obj[rowCounter][colIndex] = data;
				System.out.println(data);
			}
			rowCounter++;
		}
		return obj;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
