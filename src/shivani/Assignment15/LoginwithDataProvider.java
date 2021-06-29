package shivani.Assignment15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;

//Perform Login Test using data provider on AutomationByKrishna -> Registration
public class LoginwithDataProvider {
	@Test(dataProvider = "loginDetailsProvider")
	public void loginTest(String userName, String password, String expectedResult) {
		WebDriver driver =PredefinedActions.start("http://www.automationbykrishna.com");
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP 1 :- Click on Registration link");
		driver.findElement(By.id("registration2")).click();
		System.out.println("STEP 2 :- Enter user name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shivani");
		System.out.println("STEP 3 :- Enter password");
		driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("shivani123");
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
		data[0][0] = "Shivani";
		data[0][1] = "Shivani123";
		data[0][2] = "Success!";

		data[1][0] = "Deepa";
		data[1][1] = "Deepa123";
		data[1][2] = "Success!";

		data[2][0] = "Sakshi";
		data[2][1] = "Sakshi123";
		data[2][2] = "Success!";

		data[3][0] = "Arjun";
		data[3][1] = "Arjun123";
		data[3][2] = "Success!";

		data[4][0] = "Sneha";
		data[4][1] = "Sneha123";
		data[4][2] = "Failed! please enter strong password";

		return data;	

}
}
