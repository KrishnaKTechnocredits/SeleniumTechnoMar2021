/*
1. validate visible button functionality click on button and validate button is displayed or not and vice versa
2. validate enable button functionality click on button and validate button is disable or not and vice versa
 * 
 */

package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test4_VisibleAndEnableCheck {
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("F:/New%20Beginning/HTML%20Forms/Krishna%20Requirement.html");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	@Test
	public void enableDisableButtonVerification() throws InterruptedException {

		System.out.println("STEP - Check the Name Text Field is Enabled");
		WebElement nameField = driver.findElement(By.xpath("//input[@id='myText']"));
		if(nameField.isEnabled()) {
			System.out.println("STEP - Enter Name in Text Field");
			nameField.sendKeys("Ankit");
			Thread.sleep(2000);
			System.out.println("Value in Name Field :"+nameField.getAttribute("value"));
		}

		System.out.println("STEP - Click on Enable and Disable Button");
		WebElement buttonED = driver.findElement(By.xpath("//button[@id='enableAndDisable']"));
		buttonED.click();

		System.out.println("VERIFY - Check Name Text Field Get disable");
		Assert.assertTrue(!nameField.isEnabled());

		System.out.println("STEP - Click again on Enable and Disable Button");
		buttonED.click();


		System.out.println("VERIFY - Check Name Text Field is Enabled again ");
		Assert.assertTrue(nameField.isEnabled());
	}

	@Test
	public void visibleHiddenButtonVerification() {

		System.out.println("STEP - Check the Block is Visible ");
		WebElement blockTC = driver.findElement(By.xpath("//div[@id='myDIV']"));
		Assert.assertTrue(blockTC.isDisplayed());

		System.out.println("STEP - Click on Visible and Hiddon Button");
		WebElement buttonVH = driver.findElement(By.xpath("//button[@id='visibleAndHidden']"));
		buttonVH.click();

		System.out.println("VERIFY - Check Block is not Visible");
		Assert.assertTrue(!blockTC.isDisplayed());

		System.out.println("STEP - Click on Visible and Hiddon Button again");
		buttonVH.click();
		System.out.println("VERIFY - Check Block is Visible again ");
		Assert.assertTrue(blockTC.isDisplayed());
	}
}