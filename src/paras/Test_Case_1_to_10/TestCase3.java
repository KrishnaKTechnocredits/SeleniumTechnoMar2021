/*
Test - 3

TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.

TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"

Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"

Observations: we need to scroll the window in order to click on the alert as the alert button is not visible so receiving - org.openqa.selenium.ElementClickInterceptedException


TC#4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK"
based on Cancel - "You pressed Cancel!"

TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.
 */
package paras.Test_Case_1_to_10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open automationbykrishna.com
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("Test Case - 1");
		String actualAlertMessage = "";
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.id("UserFirstName"));
		firstName.sendKeys("Paras");
		String fName = firstName.getAttribute("value");
		actualAlertMessage += fName + " " + "and" + " ";
		WebElement lastName = driver.findElement(By.id("UserLastName"));
		lastName.sendKeys("Rokad");
		String lName = lastName.getAttribute("value");
		actualAlertMessage += lName + " " + "and" + " ";
		WebElement companyName = driver.findElement(By.id("UserCompanyName"));
		companyName.sendKeys("TechnoCredits");
		String cName = companyName.getAttribute("value");
		actualAlertMessage += cName;
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Alert alert = driver.switchTo().alert();
		String alertActualText = alert.getText();
		if (alertActualText.equals(actualAlertMessage)) {
			System.out.println("\nTest Case 1 - Test Pass");
		} else {
			System.out.println("\nTest Case 1 - Test Fail");
		}
		alert.accept();
		Thread.sleep(3000);
		System.out.println("\nTest Case - 2");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("parasrokad@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		String actualMessage = "You successfully clicked on it";
		Alert alert1 = driver.switchTo().alert();
		String alert1ActualText = alert1.getText();
		if (alert1ActualText.equals(actualMessage)) {
			System.out.println("\nTest Case2 - Test Pass");
		} else {
			System.out.println("\nTest Case2 - Test Fail");
		}
		alert.accept();
		Thread.sleep(3000);
		System.out.println("\nTest Case - 3");
		driver.findElement(By.id("javascriptAlert")).click();
		String jsAlertMsg = "You must be TechnoCredits student!!1";
		Alert alert2 = driver.switchTo().alert();
		String jsActualAlertText = alert2.getText();
		if (jsActualAlertText.equals(jsAlertMsg)) {
			System.out.println("\nTest Case3 - Test Pass");
		} else {
			System.out.println("\nTest Case3 - Test Fail");
		}
		alert.accept();
		Thread.sleep(3000);
		System.out.println("\nTest Case - 4");
		Thread.sleep(3000);
		String okClickText = "You pressed OK!";
		String cancelClickText = "You pressed Cancel!";
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		WebElement okText = driver.findElement(By.id("pgraphdemo"));
		String okActualText = okText.getText();
		if (okActualText.equals(okActualText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert4 = driver.switchTo().alert();
		alert4.dismiss();
		WebElement cancelText = driver.findElement(By.id("pgraphdemo"));
		String cancelActualText = cancelText.getText();
		if (cancelActualText.equals(cancelClickText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		Thread.sleep(3000);
		System.out.println("\nTest Case - 5");
		Thread.sleep(3000);

		driver.findElement(By.id("javascriptPromp")).click();
		Thread.sleep(2000);
		Alert alert5 = driver.switchTo().alert();
		String alertText = "Paras";
		alert5.sendKeys(alertText);
		alert.accept();

		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().contains(alertText))
			System.out.println("Test PASS");
		else
			System.out.println("Test FAIL");
		driver.close();
	}
}