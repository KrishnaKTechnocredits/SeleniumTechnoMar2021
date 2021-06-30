package pallavi.assignment4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pallavi.base.Predefined;

public class TestCase4 {
	public static void main(String[] args) throws InterruptedException {
		String successMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String okMsz = "You pressed OK!";
		String cancelMsz = "You pressed Cancel!";

		WebDriver driver = Predefined.setUp();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(300);
		WebElement element = driver.findElement(By.id("exampleInputEmail2"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP 1- Click on Javascript Confirmation");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		Alert alert = driver.switchTo().alert();
		String receivedMgs = alert.getText();

		if (successMsg.equals(receivedMgs)) {
			System.out.println("Success message is coming ");
		} else {
			System.out.println("Testcae failed");
		}

		/*
		 * alert.accept(); String actualOkMsz =
		 * driver.findElement(By.id("pgraphdemo")).getText(); if
		 * (actualOkMsz.equals(okMsz)) System.out.println("Ok is working good"); else
		 * System.out.println("Ok is not woking properly");
		 */

		alert.dismiss();
		String actualCancelMsz = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualCancelMsz.equals(cancelMsz))
			System.out.println("Cancel is working Properly");
		else {
			System.out.println("Canncel is not working properly");
		}

		driver.close();

	}

}
