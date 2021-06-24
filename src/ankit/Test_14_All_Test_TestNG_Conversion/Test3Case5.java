package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test3Case5 {
	
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
	public  void verifyAlertLabel() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP - Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		System.out.println("STEP - Send Text from Alert");
		Alert alert = driver.switchTo().alert();
		String sentToAlert = "Ankit";
		alert.sendKeys(sentToAlert);
		
		System.out.println("STEP - Close or Accept Alert");
		alert.accept();
	
		System.out.println("VERIFY - Label text");
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().contains(sentToAlert));
	}
}
