package shivani.Assignment_16;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.PredefinedActions;

//Perform Login Test using data provider & ExcelSheet on AutomationByKrishna -> Registration
public class DataProviderExcelSheet {
	

	@Test(dataProvider = "loginDetailsProvider")
	public void loginTest(String userName, String password, String expectedResult) throws InterruptedException {
		WebDriver driver= PredefinedActions.start();
		System.out.println("STEP 1 :- Click on Registration link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println("STEP 2 :- Enter user name");
		driver.findElement(By.id("unameSignin")).sendKeys(userName);

		System.out.println("STEP 3- enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(password);

		System.out.println("STEP 4- click on submit button");
		WebElement btnELement = driver.findElement(By.id("btnsubmitdetails"));
		btnELement.click();
		Alert alert = driver.switchTo().alert();
		String alertActualText = alert.getText();
		Assert.assertEquals(expectedResult, alertActualText);
		alert.accept();	
		driver.close();
	}

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] m1() throws IOException{
		return ExcelOperation.ExcelOp("D:\\git_Techno\\SeleniumTechnoMar2021\\src\\shivani\\resources\\Book1.xlsx","Data");
	}
}
