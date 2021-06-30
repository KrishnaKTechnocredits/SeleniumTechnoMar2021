package ankit.Test_15_DataProviderHardCoded;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class DataProviderHardCodedDemo {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
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
		System.out.println("VERIFY - Message on Alert");
		Assert.assertEquals(actualText, expectedText);

		System.out.println("STEP - Close or Accept Alert");
		alert.accept();
	}

	@DataProvider(name ="LoginDataProvider")
	
	public Object[][] testDataToValidateLogin(){
		Object[][] data = new Object[2][3];
		data[0][0] = "Ankit";
		data[0][1] = "Malvi";
		data[0][2] = "You successfully clicked on it";

		data[1][0] = "Twisha";
		data[1][1] = "AMalvi";
		data[1][2] = "You successfully clicked on it";
		return data;
	}

	@AfterClass
	public void tearDown(){
		driver.close();	
	}	
}
