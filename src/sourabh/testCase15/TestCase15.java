/*
Test Case - 15 [20-06-2021]
Perform Login Test using data provider on AutomationByKrishna -> Registration
 */

package sourabh.testCase15;

import javax.xml.bind.annotation.XmlInlineBinaryData;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestCase15 {	
	
	@DataProvider(name="loginDetailsProvider")
	public Object[][] loginDataProvider(){
		Object[][] data= new Object[4][3];
		
		data[0][0]="sourabh";
		data[0][1]="sourabh123";
		data[0][2]="Success!";
		
		data[1][0]="vinayak";
		data[1][1]="vinayak123";
		data[1][2]="Success!";
		
		data[2][0]="rajdeep";
		data[2][1]="rajdeep123";
		data[2][2]="Success!";
		
		data[3][0]="abhi";
		data[3][1]="abhi123";
		data[3][2]="Failed! please enter strong password";
		
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
