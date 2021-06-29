// Write test case for login with data driven framework.

package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase15 {
	
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
	public Object[][] m1(){
		Object [][] data = new Object[5][3];
		data[0][0] = "Sangeeta";
		data[0][1] = "Sangeeta123";
		data[0][2] = "Success!";
		
		data[1][0] = "Kartik";
		data[1][1] = "Kartik123";
		data[1][2] = "Success!";
		
		data[2][0] = "Sharvi";
		data[2][1] = "Sharvi123";
		data[2][2] = "Success!";
		
		data[3][0] = "Atiksh";
		data[3][1] = "Atiksh123";
		data[3][2] = "Success!";
		
		data[4][0] = "Anshu";
		data[4][1] = "Anshu123";
		data[4][2] = "Failed! please enter strong password";
		
		return data;	
	}
}
