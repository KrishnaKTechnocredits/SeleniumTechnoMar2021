package technocredits.testngDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class DemoTableTest {
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empbasic")));
	}
	
	@Test
	public void employeeManagerRowCountTest() {
		int expectedRowCount = 6;
		int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Assert.assertEquals(actualRowCount, expectedRowCount, "On first Table, row counts was not as expected");
		System.out.println("End");
	}
	
	@Test
	public void employeeManagerColumnCountTest() {
		int expectedColCount = 4;
		int actualColCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		String errorMessage = "Col count was not displayed as expected, expected " + expectedColCount + " but we actual is " + actualColCount;
		Assert.assertTrue(actualColCount == expectedColCount,errorMessage);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
