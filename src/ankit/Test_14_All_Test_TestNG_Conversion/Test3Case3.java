package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test3Case3 {

	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	@Test
	public  void verifyAlertBox() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("STEP - Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("STEP - Get Text from Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You must be TechnoCredits student!!";

		System.out.println("VERIFY - Alert text");
		Assert.assertEquals(actualText, expectedText);
		
		System.out.println("STEP - Close or Accept Alert");
		alert.accept();
	}
}
