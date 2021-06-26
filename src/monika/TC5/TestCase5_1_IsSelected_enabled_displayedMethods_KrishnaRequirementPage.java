package monika.TC5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase5_1_IsSelected_enabled_displayedMethods_KrishnaRequirementPage {
	private static WebDriver driver;
	@Test
	public static void verifyVisibilityOfButtons() {
		driver = PredefinedActions.start("file:///C:/Users/Monika.Kaul/Downloads/Krishna%20Requirement.html");
		boolean beforeDisableFlag =  driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		Assert.assertEquals(beforeDisableFlag, true);

		driver.findElement(By.id("enableAndDisable")).click();		
		boolean afterDisableFlag =  driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		Assert.assertEquals(afterDisableFlag, false);

		// Before hiding
		boolean beforeHidingFlag = driver.findElement(By.xpath("//div[@id = 'myDIV']")).isDisplayed();
		Assert.assertEquals(beforeHidingFlag, true);
			
		driver.findElement(By.id("visibleAndHidden")).click();
		// After Hiding
		boolean afterHidingFlag = driver.findElement(By.xpath("//div[@id = 'myDIV']")).isDisplayed();
		Assert.assertEquals(afterHidingFlag, false);
	}
	
	@Test
	static void verifyGenderIsSelected() {
		driver = PredefinedActions.start();
		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(3000L, TimeUnit.MILLISECONDS);
		/*JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//label[@for='radio-01']")));
*/		
		boolean beforeDisableFlag =  driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected();
		Assert.assertEquals(beforeDisableFlag, true);
		
		boolean afterDisableFlag =  driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected();
		Assert.assertEquals(afterDisableFlag, false);
		
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
