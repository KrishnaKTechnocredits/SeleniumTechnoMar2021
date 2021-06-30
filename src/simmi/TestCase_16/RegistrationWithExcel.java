package simmi.TestCase_16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationWithExcel {
	public static Object[][] readExcel(String fileName, String sheetName) throws IOException {
		File file = new File(".//testdata/" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet(sheetName);

		int totalRows = sheet.getLastRowNum() + 1;
		System.out.println("Total Rows in Excel " + totalRows);

		int totalColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Columns in Excel " + totalColumns);

		Object[][] data = new Object[totalRows][totalColumns];
		for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
			for (int colIndex = 0; colIndex < totalColumns; colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] loginDetailsProvider() throws IOException {
		return readExcel("LoginData.xlsx", "Data");
	}

	@Test(dataProvider = "loginDetailsProvider")
	public void operation(String userName, String password, String expectedResult) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - OPEN REGISTRATION PAGE ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();

		System.out.println("");
		System.out.println("STEP - ENTER USERNAME ");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(userName);

		System.out.println("");
		System.out.println("STEP - ENTER PASSWORD ");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);

		System.out.println("");
		System.out.println("STEP - CLICK SUBMIT BUTTON ");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("VERIFY ALERT MESSAGE ");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();

		Assert.assertEquals(expectedResult, actualAlertText);
		alert.accept();

		driver.close();
		
	}
}
