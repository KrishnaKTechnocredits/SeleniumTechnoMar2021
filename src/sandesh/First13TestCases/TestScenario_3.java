/*Test - 3
Launch automationbykrishna.com 
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

TC#4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK" 
based on Cancel -  "You pressed Cancel!"

TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.*/

package sandesh.First13TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sandesh.base.BaseLaunch;

public class TestScenario_3 {

	public static void main(String[] args) {
		WebDriver driver = BaseLaunch.launchWebPage("http://automationbykrishna.com");
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();

		System.out.println("Starting...Test Case #1 - First Box");
		// Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		// driver.findElement(By.id("basicelements")).click();

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basicelements"))).click();

		driver.findElement(By.name("ufname")).sendKeys("Sandesh");
		String name = driver.findElement(By.name("ufname")).getAttribute("value");
		System.out.println(name);
		driver.findElement(By.cssSelector("input#UserLastName")).sendKeys("Molane");
		driver.findElement(By.xpath("//input[contains(@id,'UserCompany')]")).sendKeys("Netcracker");
		driver.findElement(By.xpath("//header[text()=' Alert Demo ']/..//button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertDomoText = alert.getText();
		if (actualAlertDomoText.equals("Sandesh and Molane and Netcracker")) {
			System.out.println("Test Case #1 passed");
		} else
			System.out.println("Test Case #1 failed");
		alert.accept(); // alert1.dismiss() also works here

		System.out.println();
		System.out.println("Starting...Test Case #2 - Second Box");
		// Thread.sleep(1000);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Sandesh");
		driver.findElement(By.xpath("//input[@type='password'][@id='pwd']")).sendKeys("KnockKnock");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		alert = driver.switchTo().alert();
		String actualAlertDomoText2 = alert.getText();
		if (actualAlertDomoText2.equals("You successfully clicked on it")) {
			System.out.println("Test Case #2 passed -- You successfully clicked on it");
		} else
			System.out.println("Test Case #2 failed");
		alert.accept(); // alert1.dismiss() also works here

		System.out.println();
		System.out.println("Starting...Test Case #3 - Alert");
		// Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		Alert alert3 = driver.switchTo().alert();
		String actualAlertDomoText3 = alert3.getText();
		if (actualAlertDomoText3.equals("You must be TechnoCredits student!!")) {
			System.out.println("Test Case #3 passed -- You must be TechnoCredits student!!");
		} else
			System.out.println("Test Case #3 failed");
		alert.dismiss(); // alert1.dismiss() also works here

		System.out.println();
		System.out.println("Starting...Test Case #4 - Javascript Confirmation");
		// Thread.sleep(1000);
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert4 = driver.switchTo().alert();
		alert4.accept();
		// alert4.dismiss();
		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed OK!")) {
			System.out.println("Test Case #4 passed -- You pressed OK!");
		} else if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed Cancel!")) {
			System.out.println("Test Case #4 passed -- You pressed Cancel!");
		} else
			System.out.println("Test Case #4 failed -- Something went wrong...need to check");

		System.out.println();
		System.out.println("Starting...Test Case #5 - Javascript Prompt");
		// Thread.sleep(1000);
		driver.findElement(By.id("javascriptPromp")).click();
		Alert alert5 = driver.switchTo().alert();
		alert5.sendKeys("Sachin");
		alert5.accept();
		// alert5.dismiss();
		if (driver.findElement(By.id("pgraphdemo")).getText().contains("Sachin")) {
			System.out.println("Test Case #5 passed -- User accepted the prompt and given name is present");
		} else if (driver.findElement(By.id("pgraphdemo")).getText().equals("User cancelled the prompt.")) {
			System.out.println("Test Case #5 passed -- User Cancelled the prompt.");
		} else
			System.out.println("Test Case #5 failed -- Something went wrong...need to check");
	}
}
