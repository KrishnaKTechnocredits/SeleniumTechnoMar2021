package priyanka_Panat.TestCase_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class PrintNumOfDept {
	static void WaitForElement(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}

	static int getUniqueDeptCount(WebDriver driver) { // option1
		List<WebElement> deptList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> uniqueDept = new HashSet<String>();
		for (WebElement element : deptList) {
			uniqueDept.add(element.getText());
		}
		return uniqueDept.size();

	}

	static int getUniqueDeptCount1(WebDriver driver) { // option2
		List<WebElement> deptList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		List<String> deptListName = new ArrayList<String>();
		for (WebElement element : deptList) {
			deptListName.add(element.getText());
		}
		HashSet<String> uniqueDept = new HashSet<String>(deptListName);
		return uniqueDept.size();

	}

	static int getUniqueDeptCount2(WebDriver driver) { // option3
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> uniqueDept = new HashSet<String>();
		for (int rowItem = 1; rowItem <= totalRows; rowItem++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowItem + "]/td[5]"))
					.getText();
			uniqueDept.add(deptName);
		}

		return uniqueDept.size();
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.partialLinkText("Tables")).click();
		;
		WaitForElement(driver, "//a[contains(text(),'Tables')]");
		int result = getUniqueDeptCount2(driver);
		System.out.println("Unique dept count is:" + result);
		driver.close();
	}
}
