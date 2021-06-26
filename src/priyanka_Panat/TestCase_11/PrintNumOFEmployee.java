package priyanka_Panat.TestCase_11;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class PrintNumOFEmployee {

	static void WaitForElement(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}

	static int getUniqueEmployeeName(WebDriver driver) { // option2
		List<WebElement> empList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
		HashSet<String> uniqueEmp = new HashSet<String>();
		for (WebElement element : empList) {
			uniqueEmp.add(element.getText());
		}
		return uniqueEmp.size();

	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.partialLinkText("Tables")).click();
		;
		WaitForElement(driver, "//a[contains(text(),'Tables')]");
		int count = getUniqueEmployeeName(driver);
		System.out.println("Total no of employees : " + count);
		driver.close();

	}
}
