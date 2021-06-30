/*Test Case - 16 [22-06-2021]
Perform Login Test using data provider & ExcelSheet on AutomationByKrishna -> Registration*/

package sangeeta;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sangeeta.Utility.ExcelOperation;

public class TestCase_16 {
	
	@Test(dataProvider = "loginDetailsProvider")
	public void loginTest(String userName, String password, String expectedResult) {
		System.setProperty("webdriver.chrome.driver", ".//resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://www.automationbykrishna.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP 1 :- Click on Registration link");
		driver.findElement(By.id("registration2")).click();
		System.out.println("STEP 2 :- Enter user name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Sangeeta");
		System.out.println("STEP 3 :- Enter password");
		driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("sangeeta123");
		System.out.println("STEP 4 :- Click button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert = driver.switchTo().alert();
		String alertActualText = alert.getText();
		Assert.assertEquals(expectedResult, alertActualText);
		alert.accept();	
	}
	
	@DataProvider(name = "loginDetailsProvider")
	public Object[][] m1() throws IOException{
		return ExcelOperation.readExcel("D:\\Automation Testing\\Java\\Workspace\\SeleniumTechnoMar2021\\Data\\loginData.xlsx", "Sheet1");
	}
}
