/*Test Case - 16 [22-06-2021]
Perform Login Test using data provider & ExcelSheet on AutomationByKrishna -> Registration
 */

package sourabh.testCase16_ExcelReading;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sourabh.utility.ExcelOperation;

public class RegistrationWithExcelData {
	
	@DataProvider(name="loginDetailsProvider")
	public Object[][] loginDataProvider() throws IOException{
		Object[][] data= ExcelOperation.readExcel("LoginData.xlsx", "Data");
		return data;
	}
	
	@Test(dataProvider="loginDetailsProvider")
	public void registrationLogin(String username, String pwd, String exceptedAlertText ) {
		System.out.println("STEP 1: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP 2: Open automationbykrishna.com");
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();

		System.out.println("STEP 3: Click on registration link ");
		driver.findElement(By.id("registration2")).click();

		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Registration']")));
		System.out.println("STEP 4: Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(username);

		System.out.println("STEP 5: Enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(pwd);

		System.out.println("STEP 6: Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("STEP 7: Verify alert message");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		Assert.assertEquals(actualAlertText, exceptedAlertText);
		alert.accept();
		
		driver.close();
			
	}
}

