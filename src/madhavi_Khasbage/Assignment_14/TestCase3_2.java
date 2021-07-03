package madhavi_Khasbage.Assignment_14;
/*TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"
*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

public class TestCase3_2 {

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
		System.out.println("Step7: Close browser");
		driver.close();
	}

	@Test
	public void verifyMessage() {
		System.out.println("STEP2:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		System.out.println("STEP3:Enter email");
		driver.findElement(By.xpath("//div[@name='secondSegment'][2]//input[@id='exampleInputEmail1']")).sendKeys("Madhavi");
		System.out.println("STEP4:Enter password");
		driver.findElement(By.xpath("//div[@name='secondSegment'][2]//input[@id='pwd']")).sendKeys("madhavi22");

		String expectedText = "You successfully clicked on it";

		System.out.println("STEP5:Click submit.");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("STEP6:verify message You successfully clicked on it");
		Alert alert = driver.switchTo().alert();		
		Assert.assertEquals(expectedText, alert.getText());	
		alert.accept();
	}
}
