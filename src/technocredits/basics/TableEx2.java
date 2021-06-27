package technocredits.basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class TableEx2 {

	static void waitForElement(WebDriver driver,String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	static int getUniqueDeptCount(WebDriver driver) {
		List<WebElement> deptList = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		List<String> deptListNames = new ArrayList<String>();
		for(WebElement element : deptList) {
			deptListNames.add(element.getText());
		}
		HashSet<String> uniqueDept = new HashSet<String>(deptListNames);
		return uniqueDept.size();
	}
	
	static int getUniqueDeptCount1(WebDriver driver) {
		List<WebElement> deptList = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> uniqueDept = new HashSet<String>();
		for(WebElement element : deptList) {
			uniqueDept.add(element.getText());
		}
		return uniqueDept.size();
	}
	
	static int getUniqueDeptCount2(WebDriver driver) {
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> uniqueDept = new HashSet<String>();
		
		for(int rowItem=1;rowItem<=totalRows;rowItem++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowItem+"]/td[5]")).getText();
			uniqueDept.add(deptName);
		}
		return uniqueDept.size();
	}
	
	public static void main(String[] args) {
		System.out.println("STEP - Launch browser & hit AutomationBykrishna.com");
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP - Navigate to Demo Tables");
		driver.findElement(By.partialLinkText("Tables")).click();
		System.out.println("Wait for DemoTable page to load");
		waitForElement(driver,"//a[contains(text(),'Tables')]");
		System.out.println("Get UniqueDept count");
		int count = getUniqueDeptCount(driver);
		System.out.println("UniqueDept count is " + count);
		PredefinedActions.tearDown();
	}
}
