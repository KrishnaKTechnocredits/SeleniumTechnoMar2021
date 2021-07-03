package madhavi_Khasbage.Assignment_14;



/*
 * http://automationbykrishna.com/index.html#
 * validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

public class TestCase4_1 {
	WebDriver driver;
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		String expectedURL = "http://automationbykrishna.com/index.html#";
		driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step4: Close browser");
		driver.close();
	}

	@Test
	public void checkRadioButton() {
		System.out.println("STEP2:Click on Registration");
		driver.findElement(By.id("registration2")).click();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='registration']")));	
		boolean isSelected = driver.findElement(By.id("radio-01")).isSelected();
		Assert.assertEquals(isSelected, true);
		System.out.println("STEP3:Click on radio button");
		driver.findElement(By.id("radio-02")).click();		
	}
}
