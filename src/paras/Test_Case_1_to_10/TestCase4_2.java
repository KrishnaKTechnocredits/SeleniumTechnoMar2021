/*
1. validate visible button functionality click on button and validate button is displayed or not and vice versa
2. validate enable button functionality click on button and validate button is disable or not and vice versa.
 */
package paras.Test_Case_1_to_10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4_2 {

	static void enableandDisableButton(WebDriver driver) throws InterruptedException {

		System.out.println("Check the Name Text Field is Enabled");
		WebElement name = driver.findElement(By.xpath("//input[@id='myText']"));

		if (name.isEnabled()) {
			System.out.println("Enter Name");
			name.sendKeys("Paras");
			Thread.sleep(2000);
			System.out.println("Value in Name :" + name.getAttribute("value"));
		}

		System.out.println("Click Enable & Disable Button");
		WebElement button = driver.findElement(By.xpath("//button[@id='enableAndDisable']"));
		button.click();

		System.out.println("To check name field disable");
		if (!name.isEnabled()) {
			System.out.println("Name Field is Disabled - Test PASS");
		} else
			System.out.println("Name Field is still Enabled - Test FAIL");

		button.click();

		System.out.println("To check name field enabled ");
		if (name.isEnabled()) {
			System.out.println("Name Field is Enabled - Test PASS");
		} else
			System.out.println("Name Field is still Disabled - Test FAIL");
	}

	static void visibleButton(WebDriver driver) {

		WebElement block = driver.findElement(By.id("myDIV"));
		if (block.isDisplayed()) {
			System.out.println("Block is Visible on screen ");
		} else {
			System.out.println("Block is Hidden on screen");
		}
		System.out.println("Click on Visible & Hiddon Button");
		WebElement clickbutton = driver.findElement(By.id("visibleAndHidden"));
		clickbutton.click();

		System.out.println("Check for Block is Visible");
		if (block.isDisplayed()) {
			System.out.println("Block is Visible - FAIL");
		} else {
			System.out.println("Block is Hidden - PASS");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\TechnoCredits\\HTML Forms\\Krishna Requirement.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		enableandDisableButton(driver);
		visibleButton(driver);
	}
}