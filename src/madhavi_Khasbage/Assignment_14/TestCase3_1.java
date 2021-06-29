package madhavi_Khasbage.Assignment_14;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;
/*TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.
*/
public class TestCase3_1 {
	WebDriver driver;
	String expectedURL = "";
	
	@BeforeMethod
	void setUp() {
		System.out.println("Step1: Launch browser");
	    expectedURL = "http://automationbykrishna.com/#";		
		driver = PredefinedActions.setUp(expectedURL);	
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.urlContains(expectedURL));
	}
	
	@AfterMethod
	void tearDown() {		
		System.out.println("Step5: Close browser");
		driver.close();
	}

	@Test
	public void verifyText() {	
		System.out.println("STEP1:Click on Basic Element");		
		driver.findElement(By.id("basicelements")).click();
	
		System.out.println("STEP2:Enter Fname, Last name and Company name.");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@name='ufname']")).sendKeys("Madhavi");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@name='ulname']")).sendKeys("Khasbage");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@name='cmpname']")).sendKeys("VKSoft Technology");

		String expectedText = "Madhavi and Khasbage and VKSoft Technology";

		System.out.println("STEP3:Click submit.");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[@class='btn btn-primary']")).click();
				
		System.out.println("STEP4:Alert box should open, get that text on alert box and verify.");
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals(expectedText, alert.getText());	
		alert.accept();		
	}
}
