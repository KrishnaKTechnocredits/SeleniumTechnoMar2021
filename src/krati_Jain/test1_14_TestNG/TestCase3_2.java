package krati_Jain.test1_14_TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3_2 {
	
	WebDriver driver;
	JavascriptExecutor je;

	@BeforeClass
	public void setDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		je = (JavascriptExecutor) driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void test3() throws InterruptedException {

		String expectedAlertMessage = "You must be TechnoCredits student!!";
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();

		Alert alertJavaScript = driver.switchTo().alert();
		String actualAlterMessage = alertJavaScript.getText();
		if (actualAlterMessage.equals(expectedAlertMessage))
			System.out.println("Verify Step - Javascript alert message is as expected : " + expectedAlertMessage);
		else
			System.out.println("Verify Step - Javascript alert message is not as expected : " + expectedAlertMessage);
		alertJavaScript.accept();

	}

	@Test
	public void test4() throws InterruptedException {

		String expectedOkMsg = "You pressed OK!";
		String expectedCancelMsg = "You pressed Cancel!";

		String expectedAlertMessage = "You must be TechnoCredits student!!";
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		WebElement elementJScript = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		je.executeScript("arguments[0].scrollIntoView(true)", elementJScript);
		elementJScript.click();
		Alert jScriptAlert = driver.switchTo().alert();
		jScriptAlert.accept();

		String actualAcceptMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualAcceptMsg.equals(expectedOkMsg))
			System.out.println(
					"Verify Step - Java Script Alert Message is as Expected when Click OK : " + actualAcceptMsg);
		else
			System.out.println("Verify Step - Java Script Alert Message is not Expected when Click OK and is : "
					+ actualAcceptMsg);

		elementJScript.click();

		Alert jScriptAlert1 = driver.switchTo().alert();
		jScriptAlert1.dismiss();
		String actualDismissMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (actualDismissMsg.equals(expectedCancelMsg))
			System.out.println(
					"Verify Step - Java Script Alert Message is as Expected when Click Cancel : " + actualDismissMsg);
		else
			System.out.println("Verify Step - Java Script Alert Message is not Expected when Click Cancel and is : "
					+ actualDismissMsg);
	}

	@Test
	public void test5() throws InterruptedException {
		String name = "Krati";
		String jsPromptExpectedMsg = "Hello " + name + "! How are you today?";
		String jsPromptExpectedCancelMsg = "User cancelled the prompt.";
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);
		WebElement jsScriptBtn = driver.findElement(By.xpath("//button[@onclick='callJavaScriptPrompt()']"));
		je.executeScript("arguments[0].scrollIntoView(true)", jsScriptBtn);
		jsScriptBtn.click();

		Alert jsPromptAlert = driver.switchTo().alert();
		jsPromptAlert.sendKeys(name);
		jsPromptAlert.accept();
		String acceptMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (acceptMsg.equals(jsPromptExpectedMsg))
			System.out.println(
					"Verify Step - JavaScript Prompt Alert Message is as Expected when Click OK : " + acceptMsg);
		else
			System.out.println(
					"Verify Step - JavaScript Prompt Alert Message is not as Expected when Click OK : " + acceptMsg);

		jsScriptBtn.click();

		Alert jsPromptAlert1 = driver.switchTo().alert();
		jsPromptAlert1.sendKeys(name);
		jsPromptAlert1.dismiss();
		String acceptCancelMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (acceptCancelMsg.equals(jsPromptExpectedCancelMsg))
			System.out.println("Verify Step - JavaScript Prompt Alert Message is as Expected when Click Cancel : "
					+ acceptCancelMsg);
		else
			System.out.println("Verify Step - JavaScript Prompt Alert Message is not as Expected when Click Cancel : "
					+ acceptCancelMsg);
	}

		@AfterClass
		public void quitBrowsers() {
			driver.quit();
		}
}