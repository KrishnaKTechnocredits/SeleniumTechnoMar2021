package madhavi_Khasbage.Assignment_14;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import madhavi_Khasbage.base.PredefinedActions;

/*Test case 3_5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.
*/

public class TestCase3_5 {
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

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("javascriptPromp")));

		System.out.println("STEP2:JS Prompt");
		driver.findElement(By.id("javascriptPromp")).click();
		
		System.out.println("STEP3:enter name");
		Alert alert = driver.switchTo().alert();
		String name = "madhavi";
		alert.sendKeys(name);
		alert.accept();
		System.out.println("STEP4:from the message verify that " + name + " is present.");

		Assert.assertEquals(name, driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText());
	}

}
