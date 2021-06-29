package priyanka_Panat.TestCase_11;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class PrintNumOfManagers {
	static void WaitForElement(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}

	static int getUniqueManagerName(WebDriver driver) { // option2
		List<WebElement> managerList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashSet<String> uniqueManager = new HashSet<String>();
		for (WebElement element : managerList) {
			uniqueManager.add(element.getText());
		}
		return uniqueManager.size();

	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.partialLinkText("Tables")).click();
		;
		WaitForElement(driver, "//a[contains(text(),'Tables')]");
		int count1 = getUniqueManagerName(driver);
		System.out.println("Total no of managers are : " + count1);
		driver.close();

	}

}
