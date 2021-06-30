package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test3Case2 {
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
	public void verifyAlertText2() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Enter Email ID ");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("Ankit.Malvi");
		
		Thread.sleep(2000);
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Malvi");
		
		Thread.sleep(2000);
		System.out.println("STEP - Click on submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Thread.sleep(2000);
		System.out.println("STEP - Verify message on Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You successfully clicked on it"; 
		
		Thread.sleep(2000);
		System.out.println("VERIFY - Message on Alert");
		Assert.assertEquals(actualText, expectedText);
	
		System.out.println("STEP - Close or Accept Alert");
		alert.accept();

		System.out.println("STEP - Close Browser ");
		
	}
}
