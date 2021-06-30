package ankit.Test_16_DataProvider_ExcelReading;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;
import ankit.AM_util.ExcelReader_Util;

public class DataProviderExcelReaderDemo {
	WebDriver driver;


	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");
	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyLoginAlert(String email, String password, String expectedText) throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Enter Email ID ");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);

		Thread.sleep(2000);
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);

		Thread.sleep(2000);
		System.out.println("STEP - Click on submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Thread.sleep(2000);
		System.out.println("STEP - Verify message on Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		Thread.sleep(2000);
		Assert.assertEquals(actualText, expectedText);

		System.out.println("STEP - Close or Accept Alert");
		alert.accept();
	}

	@DataProvider(name ="LoginDataProvider")
	
	public Object[][] testDataToValidateLogin() throws IOException{
		Object[][] data = ExcelReader_Util.getExcelData("./src/ankit/AM_resources/Automation_By_Krishna_TestData.xlsx", "Login Validation Test Data");
		return data;
	}

	@AfterClass
	public void tearDown(){
		driver.close();	
	}	
}
