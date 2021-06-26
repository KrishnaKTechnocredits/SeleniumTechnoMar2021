package kajal.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testcase4JSconfirmation {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP 3 cllcik on basci elements");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		WebElement jsconfirm = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		System.out.println("STEP4 scroll to the particular element");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", jsconfirm);
		System.out.println("STEP5 clcik on element");
		jsconfirm.click();

		System.out.println("STEP6 switch on alert");
		Alert alert = driver.switchTo().alert();

		alert.accept();
		// alert.dismiss();

		String msgonParagraph = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(msgonParagraph);
		System.out.println("STEP7 verify you pressed ok or cancel");
		if (msgonParagraph.equals("You pressed OK!")) {
			System.out.println("You pressed OK!");
		} else {
			System.out.println("You pressed Cancel!");
		}
		driver.close();
	}
}