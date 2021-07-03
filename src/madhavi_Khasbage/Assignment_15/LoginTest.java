package madhavi_Khasbage.Assignment_15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import  madhavi_Khasbage.base.PredefinedActions;

public class LoginTest {
	WebDriver driver;
	
	@BeforeTest
	void startUp() {		
		System.out.println("Step1:Launch Brower");
		String expectedUrl="http://automationbykrishna.com/";		
		driver = PredefinedActions.setUp(expectedUrl);
		driver.manage().window().maximize();		
	}
	
	@AfterTest
	void tearDown() {
		driver.close();
	}
	
	@Test(dataProvider="loginDataProvider")
	void testLoginCredentials(String username,String password, String expectedAlertText) throws InterruptedException {	
		System.out.println("Step2:Click on registration link");
		
		driver.findElement(By.id("registration2")).click();		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		
		Thread.sleep(1000);
		
		System.out.println("Step3:enter user name");
		driver.findElement(By.id("unameSignin")).sendKeys(username);
		
		System.out.println("Step3:enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
	
		System.out.println("Step3:click on button");
		WebElement btnElement=driver.findElement(By.id("btnsubmitdetails"));		
		btnElement.click();	
		
		System.out.println("Step5:verify alert message");
		
		Alert alert=driver.switchTo().alert();		
		Assert.assertEquals(expectedAlertText,alert.getText());
		alert.accept();
	}
	
	@DataProvider(name="loginDataProvider")
	public Object[][] loginDataProvider(){
		
		Object[][] data=new Object[4][3];
		
		data[0][0]="madhavi";
		data[0][1]="madhavi123";
		data[0][2]="Success!";
		
		data[1][0]="vishal";
		data[1][1]="vishal123";
		data[1][2]="Success!";
		
		data[2][0]="kanav";
		data[2][1]="kanav123";
		data[2][2]="Failed! please enter strong password";
		
		data[3][0]="hrudaya";
		data[3][1]="hrudaya123";
		data[3][2]="Success!";
		
		return data;		
	}
}
