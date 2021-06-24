//3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female


package ankit.Test_14_All_Test_TestNG_Conversion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test4_CheckAndClickRadioButton {
	
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

	private void clickOnRadioButtonAndSelect() {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		if(driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected()) {
			driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected());
	}
}
