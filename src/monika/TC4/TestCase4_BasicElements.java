package monika.TC4;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase4_BasicElements {

	private static WebDriver driver;
	@BeforeMethod
	public static void commonBrowserCommands() {
		System.out.println("Before method TC4");
		System.out.println("STEP1: launch a browser.");
		driver = PredefinedActions.start();
		System.out.println("STEP3: Perform Actions");
		driver.findElement(By.id("basicelements")).click();
	}

	@Test
	public static void verifyAlertText() {
		System.out.println("Test Case 1 starts here");
		driver.findElement(By.id("UserFirstName")).sendKeys("Monika");
		driver.findElement(By.id("UserLastName")).sendKeys("Kaul");
		driver.findElement(By.id("UserCompanyName")).sendKeys("ABC");
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][@onclick='myFunctionPopUp()']")).click();

		String resultAlertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	/*	if ("Monika and Kaul and ABC".equals(resultAlertMsg))
			System.out.println("Actual alert message is same as expected.");
		else
			System.out.println("Actual alert message is not same as expected.");*/

		System.out.println("Test Case1 Ends");
		Assert.assertEquals(resultAlertMsg, "Monika and Kaul and ABC");
	}
	@Test
	public static void verifyEmailPassSection() {
		System.out.println("Test Case 2 starts here");
		driver.findElement(By.name("emailId")).sendKeys("monika@demo.com");
		driver.findElement(By.id("pwd")).sendKeys("Monika");
		driver.findElement(By.id("submitb2")).click();

		driver.manage().timeouts().implicitlyWait(3000L, TimeUnit.MILLISECONDS);

		String resultAlertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

	/*	if ("You successfully clicked on it".equals(resultAlertMsg))
			System.out.println("TestCase2: Actual alert message is same as expected.");
		else
			System.out.println("TestCase2: Actual alert message is not same as expected.");*/

		Assert.assertEquals(resultAlertMsg, "You successfully clicked on it");
		System.out.println("Test Case2 Ends");
	}
	@Test()
	public static void verifyJSAlerts() {
		//javascriptAlert
		System.out.println("Test Case 3a starts here : 1st JS alert");

		JavascriptExecutor je = (JavascriptExecutor)driver;
		//je.executeScript("scroll(0,300)");
		je.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.id("javascriptAlert")).click();
		
		String alertText1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		/*if("You must be TechnoCredits student!!".equals(alertText1))
			System.out.println("TestCase 3a: Actual alert message is same as expected.");
		else
			System.out.println("TestCase3a: Actual alert message is not same as expected.");

*/

		Assert.assertEquals(alertText1, "You must be TechnoCredits student!!");
		//javascriptConfirmBox
		driver.findElement(By.id("javascriptConfirmBox")).click();
		String alertText2 = driver.switchTo().alert().getText();
			
		/*if("Are you are doing your homework regularly, Press Okay else Cancel!!".equals(alertText2))
			System.out.println("TestCase 3a: Actual alert message is same as expected.");
		else
			System.out.println("TestCase3a: Actual alert message is not same as expected.");
			*/
		
		Assert.assertEquals(alertText2, "Are you are doing your homework regularly, Press Okay else Cancel!!");
		
		//Click on OK - javascriptConfirmBox
		driver.switchTo().alert().accept();
		String okText = driver.findElement(By.id("pgraphdemo")).getText();
		/*if("You pressed OK!".equals(okText))
			System.out.println("TestCase 3b: Actual alert message is same as expected.");
		else
			System.out.println("TestCase3b: Actual alert message is not same as expected.");
		*/
		
		Assert.assertEquals(okText, "You pressed OK!");
		//click on cancel - javascriptConfirmBox
		driver.findElement(By.id("javascriptConfirmBox")).click();
		driver.switchTo().alert().dismiss();
		String cancelText = driver.findElement(By.id("pgraphdemo")).getText();
		/*if("You pressed Cancel!".equals(cancelText))
			System.out.println("TestCase 3b: Actual alert message is same as expected.");
		else
			System.out.println("TestCase3b: Actual alert message is not same as expected.");
		*/

		Assert.assertEquals(cancelText, "You pressed Cancel!");
		//javascriptPromp
		driver.findElement(By.id("javascriptPromp")).click();
		driver.switchTo().alert().sendKeys("Monika");
		driver.switchTo().alert().accept();
		
		String okTextPrompt = driver.findElement(By.id("pgraphdemo")).getText();
		/*if("Hello mk! How are you today?".equals(okTextPrompt))
			System.out.println("TestCase3c: Actual alert message is same as expected.");
		else
			System.out.println("TestCase3c: Actual alert message is not same as expected.");*/
		
		Assert.assertEquals(okTextPrompt, "Hello Monika! How are you today?");
		
		//cancel - JavascriptPromp
		driver.findElement(By.id("javascriptPromp")).click();
		driver.switchTo().alert().sendKeys("Sonika");
		driver.switchTo().alert().dismiss();
		
		String cancelTextPrompt = driver.findElement(By.id("pgraphdemo")).getText();
		/*if("User cancelled the prompt.".equals(cancelTextPrompt))
			System.out.println("TestCase3c: Actual alert message is same as expected.");
		else
			System.out.println("TestCase3c: Actual alert message is not same as expected.");
		*/
		Assert.assertEquals(cancelTextPrompt, "User cancelled the prompt.");
		
		System.out.println("Test Case 3 Ends");	
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	

/*	public static void main(String[] args) {
		WebDriver driver = commonBrowserCommands();
		verifyAlertText(driver);
		verifyEmailPassSection(driver);
		verifyJSAlerts(driver);
	}*/

}
