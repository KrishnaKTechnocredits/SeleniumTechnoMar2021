package monika.TC15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;

//Perform Login Test using data provider on AutomationByKrishna -> Registration
public class DataProviderProgram {
	WebDriver driver ;
	@Test(dataProvider="registrationData")
	public void registerUsingDataProvider(String uname, String password, String alertMsg) {
		driver = PredefinedActions.start();
		driver.findElement(By.id("registration2")).click();
		
		driver.findElement(By.id("unameSignin")).sendKeys(uname);
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		driver.findElement(By.id("btnsubmitdetails")).click();
				
		Alert alert =  driver.switchTo().alert();
		String actualMsg = alert.getText();
		Assert.assertTrue(actualMsg.equals(alertMsg));
		alert.accept();
		
	}
	
	@AfterMethod
	void close() {
		driver.close();
	}

	@DataProvider(name="registrationData")
	Object[][] registrationDataProvider() {
		Object[][] data = new Object[3][3];
		data[0][0] = "monika";
		data[0][1]="monika123";
		data[0][2]="Success!";
		
		data[1][0] = "sonika";
		data[1][1]="sonika123";
		data[1][2]="Success!";
		
		data[2][0] = "tonika";
		data[2][1]="tkau";
		data[2][2]="Failed! please enter strong password";
		return data;
	}
}
