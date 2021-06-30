/*
 * Test Case 2
1. Launch chrome browser
2. Open automationbykrishna.com
3. click on registration link
4. enter username
5. enter password
6. click on submit button
7. verify alert message
 */

package sourabh.testCase2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		String exceptedMsgPass = "Success!";
		String exceptedMsgFail = "Failed! please enter strong password";
		System.out.println("STEP 1: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP 2: Open automationbykrishna.com");
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();

		System.out.println("STEP 3: Click on registration link ");
		driver.findElement(By.id("registration2")).click();

		Thread.sleep(2000);
		System.out.println("STEP 4: Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("mkanani");

		String pwd = "mkanani123";
		System.out.println("STEP 5: Enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(pwd);

		System.out.println("STEP 6: Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("STEP 7: Verify alert message");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		if (pwd.length() > 8) {
			if (actualAlertText.equals(exceptedMsgPass))
				System.out.println("Test Pass!!");
			else
				System.out.println("Test Fail!!");
		} else {
			if (actualAlertText.equals(exceptedMsgFail))
				System.out.println("Test Pass!!");
			else
				System.out.println("Test Fail!!");
		}
		alert.accept();
	}
}

