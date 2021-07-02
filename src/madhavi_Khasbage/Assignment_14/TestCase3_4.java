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

/*Test Case 3_4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK"
based on Cancel - "You pressed Cancel!"
*/

public class TestCase3_4 {

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
	public void verifyAlertMessage() {
		System.out.println("STEP2:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP2:JS confirmation.");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		String expectedOkText = "You pressed OK!";
		String expectedCancelText = "You pressed Cancel!";

		System.out.println("STEP3:Read message and accordingly click - OK");
		Alert alert = driver.switchTo().alert();	
		String alertConfText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();		
		Assert.assertEquals(expectedOkText, alertConfText, "Test Pass >> ok press");
		alert.accept();
		
		System.out.println("STEP4:Read message and accordingly click - cancel");
		driver.findElement(By.id("javascriptConfirmBox")).click();
	    driver.switchTo().alert();	
		String alertCancelConfText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		alert.dismiss();
		Assert.assertEquals(expectedCancelText, alertCancelConfText, "Test Pass >> cancel press");
		
	}
}
