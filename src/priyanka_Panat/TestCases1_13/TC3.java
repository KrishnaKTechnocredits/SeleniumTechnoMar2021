package priyanka_Panat.TestCases1_13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("1. Launch a chrome");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("TC-1 First Box");
		Thread.sleep(2000);
		System.out.println("STEP-Click Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("STEP- Enter First Name");
		Thread.sleep(2000);
		driver.findElement(By.id("UserFirstName")).sendKeys("Priyanka");
		System.out.println("STEP- Enter Last Name");
		Thread.sleep(2000);
		driver.findElement(By.id("UserLastName")).sendKeys("priya123");
		System.out.println("STEP-Enter company name");
		Thread.sleep(2000);
		driver.findElement(By.id("UserCompanyName")).sendKeys("AtosSyntel");
		Thread.sleep(2000);
		System.out.println("STEP-Click submit");
		driver.findElement(By.xpath("//button[@onclick=\'myFunctionPopUp()']")).click();

		Thread.sleep(2000);
		System.out.println("Step- Verify Alert message");
		Alert alert = driver.switchTo().alert();
		String expectedmsg = "Priyanka and priya123 and AtosSyntel";
		String alertMsg = alert.getText();
		if (alertMsg.equals(expectedmsg)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		alert.dismiss();

		System.out.println("TC-2 Second Box");
		System.out.println("STEP-Click Basic Elements link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		System.out.println("STEP- Enter email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("priyankapanat30@gmail.com");

		Thread.sleep(2000);
		System.out.println("STEP- Enter password");
		driver.findElement(By.id("pwd")).sendKeys("priya@123");

		Thread.sleep(2000);
		System.out.println("STEP- click submit");
		driver.findElement(By.id("submitb2")).click();

		Thread.sleep(2000);
		System.out.println("Step- Verify Alert message");
		alert = driver.switchTo().alert();
		expectedmsg = "You successfully clicked on it";
		String alertActualText = alert.getText();
		if (expectedmsg.equals(alertActualText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		Thread.sleep(2000);
		alert.dismiss();

		System.out.println("TC-3 Click Alert Button");
		System.out.println("STEP-Click Basic Elements link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		System.out.println("STEP-Click on alert buttton");
		driver.findElement(By.id("javascriptAlert")).click();

		String msg = "You must be TechnoCredits student!!";
		Thread.sleep(2000);
		System.out.println("Step- Verify Alert message");
		alert = driver.switchTo().alert();
		String alertActualTextMsg = alert.getText();
		if (msg.equals(alertActualTextMsg))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		Thread.sleep(2000);
		alert.dismiss();

		System.out.println("TC-4 JS Confirmation");
		System.out.println("STEP-Click Basic Elements link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		System.out.println("STEP-Click on javascript confirmation buttton");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		Thread.sleep(2000);
		System.out.println("Step- Verify Alert message");
		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String expectedAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		System.out.println("Step10:Press OK");
		alert.accept();
		System.out.println("Step: Check if Alert handled?");
		boolean flag = driver.findElement(By.xpath("//p[contains(text(), \"You pressed OK!\")]")).isDisplayed();
		if (flag)
			System.out.println("Alert accepted successfully");

		Thread.sleep(2000);
		System.out.println("Step: Click on Confirmation Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step: Switch to Alert");
		alert = driver.switchTo().alert();
		alertText = alert.getText();
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		System.out.println("Step: Press Cancel");
		alert.dismiss();
		System.out.println("Step: Check if Alert handled?");
		flag = driver.findElement(By.xpath("//p[contains(text(), \"You pressed Cancel!\")]")).isDisplayed();
		if (flag)
			System.out.println("Alert dismissed successfully");

		System.out.println("TC-5 JS Prompt");
		System.out.println("STEP-Click Basic Elements link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		System.out.println("Enter javascript prompt");
		driver.findElement(By.id("javascriptPromp")).click();

		Thread.sleep(2000);
		System.out.println("Step- Verify Alert message");
		Alert alert5 = driver.switchTo().alert();
		System.out.println("Verfiy alert text");
		alertText = alert5.getText();
		expectedAlertMsg = "Please enter your name :";
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		alert.sendKeys("Priyanka");
		System.out.println(" Name entered");
		System.out.println(" Press OK");
		alert.accept();
		flag = driver.findElement(By.xpath("//p[contains(text(), \"Hello Priyanka! How are you today?\")]"))
				.isDisplayed();
		if (flag)
			System.out.println("Prompt accepted successfully");

		Thread.sleep(2000);
		System.out.println("Step22: Again Click on Prompt button");
		driver.findElement(By.xpath("//button[@onclick=\"callJavaScriptPrompt()\"]")).click();
		System.out.println("Step- Switch to Alert");
		alert5 = driver.switchTo().alert();
		System.out.println("Step: Press Cancel");
		alert5.dismiss();
		System.out.println("Step- Check if Alert handled?");
		flag = driver.findElement(By.xpath("//p[contains(text(), \"User cancelled the prompt.\")]")).isDisplayed();
		if (flag)
			System.out.println("Prompt cancelled successfully");
		driver.close();
	}
}