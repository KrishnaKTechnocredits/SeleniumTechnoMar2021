package amrutaM.testcases;

/*TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import amrutaM.base.PredefinedActions;

public class TC3AlertDemoForm1 {
	static WebDriver driver;

	static void verifyAlertMessage(String fName, String lName, String companyName) {
		System.out.println("verifyAlertMessage method ");
		System.out.println("First Name received is --> " + fName);
		String expectedMessage =  fName + " and " + lName + " and " + companyName ;
		System.out.println(expectedMessage);
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();

		if (expectedMessage.equals(actualAlertMessage)) {
			System.out.println("Verification Passed - Alert message text matched!!");
		} else {
			System.out.println("Verification failed - Alert message text do not matched!!");
		}
		alert.dismiss();
	}

	public static void main(String[] args) throws InterruptedException {
		
		driver = PredefinedActions.setUp();
		System.out.println("Step 1: Clicking on the Basic Elements menu link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(1000);
		System.out.println("Step 2: Entering the first name");
		WebElement firstName = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		firstName.sendKeys("Amruta");
		String fName = firstName.getAttribute("value");
		System.out.println("First Name  is --> " + fName);

		System.out.println("Step 3: Entering the last name");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='UserLastName']"));
		lastName.sendKeys("Markhedkar");
		String lName = lastName.getAttribute("value");

		System.out.println("Step 4: Entering company name");
		WebElement company = driver.findElement(By.xpath("//input[@id='UserCompanyName']"));
		company.sendKeys("ST Pune");
		String companyName = company.getAttribute("value");

		System.out.println("Step 5: Clicking the Submit button");
		driver.findElement(By.xpath("//div[@id='firstRow']/div//div[4]/button")).click();

		//verifyAlertMessage(fName+" and "+ lastName+" and "company);
		verifyAlertMessage(fName, lName, companyName);
		PredefinedActions.tearDown();

	}
}
