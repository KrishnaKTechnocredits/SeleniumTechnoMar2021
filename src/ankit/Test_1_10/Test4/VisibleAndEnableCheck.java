/*
1. validate visible button functionality click on button and validate button is displayed or not and vice versa
2. validate enable button functionality click on button and validate button is disable or not and vice versa
 * 
 */

package ankit.Test_1_10.Test4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisibleAndEnableCheck {
	static WebDriver driver; 
	

	static void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("F:\\\\New Beginning\\\\HTML Forms\\\\Krishna Requirement.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	static void enableDisableButtonVerification(WebDriver driver) throws InterruptedException {

		System.out.println("STEP - Check the Name Text Field is Enabled");//input[@id='myText']
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
		if(!nameField.isEnabled()) {
			System.out.println("Name Field is Disabled - PASS");
		}
		else 
			System.out.println("Name Field is still Enabled - FAIL");

		System.out.println("STEP - Click again on Enable and Disable Button");
		buttonED.click();


		System.out.println("VERIFY - Check Name Text Field is Enabled again ");
		if(nameField.isEnabled()) {
			System.out.println("Name Field is Enabled - PASS");
		}
		else 
			System.out.println("Name Field is still Disabled - FAIL");
	}

	static void visibleHiddenButtonVerification(WebDriver driver) {

		System.out.println("STEP - Check the Block is Visible ");
		WebElement blockTC = driver.findElement(By.xpath("//div[@id='myDIV']"));
		if (blockTC.isDisplayed()) {
			System.out.println("Block is Visible ");
		}else {
			System.out.println("Block is Hidden");
		}
		System.out.println("STEP - Click on Visible and Hiddon Button");
		WebElement buttonVH = driver.findElement(By.xpath("//button[@id='visibleAndHidden']"));
		buttonVH.click();

		System.out.println("VERIFY - Check Block is not Visible");
		if (blockTC.isDisplayed()) {
			System.out.println("Block is Visible - FAIL");
		}else {
			System.out.println("Block is Hidden - PASS");
		}
		System.out.println("STEP - Click on Visible and Hiddon Button again");
		buttonVH.click();
		System.out.println("VERIFY - Check Block is Visible again ");
		if (blockTC.isDisplayed()) {
			System.out.println("Block is Visible - PASS");
		}else {
			System.out.println("Block is Hidden - FAIL");
		}
	}

	private static void tearDown(WebDriver driver) {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		setUp();
		enableDisableButtonVerification(driver);
		visibleHiddenButtonVerification(driver);
		tearDown(driver);

	}
}