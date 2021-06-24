package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test3Case1 {
	WebDriver driver;

	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	@Test
	public void verifyAlertText() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Enter Fname");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Ankit");

		System.out.println("STEP - Enter Lname");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Malvi");

		System.out.println("STEP - Company name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("TechnoCredits");

		System.out.println("STEP - click submit");
		driver.findElement(By.xpath("//button[@onClick='myFunctionPopUp()']")).click();

		System.out.println("STEP - get alert, get that text");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "Ankit and Malvi and TechnoCredits";

		System.out.println("VERIFY - Alert Text");
		Assert.assertEquals(actualAlertText, expectedAlertText);
		/*if(actualAlertText.equals(expectedAlertText)) 
			System.out.println("Alert Text is correct - PASS");
		else 
			System.out.println("Alert Text is Incorrect - FAIL");*/

		System.out.println("STEP - Close or Accept Alert");
		alert.accept();

		System.out.println("STEP - Close Browser ");
	}
}
