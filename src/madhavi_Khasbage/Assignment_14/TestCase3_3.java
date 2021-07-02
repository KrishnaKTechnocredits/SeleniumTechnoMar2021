package madhavi_Khasbage.Assignment_14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

/* Test case 3 of 3
Javascript
click Alert button
Verify - "You must be TechnoCredits student"
Observations: we need to scroll the window in order to click on the alert
 as the alert button is not visible 
so receiving - org.openqa.selenium.ElementClickInterceptedException
*/

public class TestCase3_3 {
	WebDriver driver;
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		String expectedURL = "http://automationbykrishna.com/";
		driver = PredefinedActions.setUp(expectedURL);		
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step5: Close browser");
		driver.close();
	}

	@Test
	void verfyMessage() {		
		System.out.println("STEP2:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		String expectedText = "You must be TechnoCredits student!!";

		System.out.println("STEP3:Click Alert button.");
		driver.findElement(By.id("javascriptAlert")).click();

		System.out.println("STEP4:Verify - You must be TechnoCredits student!!");
		Alert alert = driver.switchTo().alert();	
		Assert.assertEquals(expectedText, alert.getText());	
		alert.accept();		
	}
}
