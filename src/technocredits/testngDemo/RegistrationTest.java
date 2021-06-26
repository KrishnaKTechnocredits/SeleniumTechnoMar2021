package technocredits.testngDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class RegistrationTest {

	@Test(dataProvider="loginDetailsProvider")
	public void registrationLoginTest(String username, String password, String expectedAlertText) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		WebElement e = driver.findElement(By.tagName("button")); // By.xpath("//button")
	    Point p = e.getLocation();
		p.getX();
		p.getY();
	    
	    System.out.println("STEP - click on registration link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println("STEP - enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(username);
		System.out.println("STEP - enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		System.out.println("STEP - click on submit button");
		WebElement btnELement = driver.findElement(By.id("btnsubmitdetails"));
		btnELement.click();
		System.out.println("Verify - alert message");
		Alert alert = driver.switchTo().alert();
		String alterActualText = alert.getText();
		Assert.assertEquals(expectedAlertText, alterActualText);
		alert.accept();
	}

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] m1() {
		Object[][] data = new Object[4][3];
		data[0][0] = "mkanani";
		data[0][1] = "mkanani123";
		data[0][2] = "Success!";
		
		data[1][0] = "shashank";
		data[1][1] = "shashank123";
		data[1][2] = "Success!";
		
		data[2][0] = "sandesh";
		data[2][1] = "sandesh123";
		data[2][2] = "Success!";
		
		data[3][0] = "krati";
		data[3][1] = "krati123";
		data[3][2] = "Failed! please enter strong password";
		
		return data;
	}

}
