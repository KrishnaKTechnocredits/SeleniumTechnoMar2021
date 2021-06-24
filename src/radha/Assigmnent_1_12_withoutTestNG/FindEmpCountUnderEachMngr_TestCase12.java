package radha.Assigmnent_1_12_withoutTestNG;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class FindEmpCountUnderEachMngr_TestCase12 {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String, Integer> empID = findEmpCount(driver);
		System.out.println("Employee count under each Manager is: " + empID);
		driver.close();
	}

	static HashMap<String, Integer> findEmpCount(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		int rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody//tr"))).size();
		HashMap<String, Integer> managerCount = new HashMap<String, Integer>();
		for (int index = 1; index <= rows; index++) {
			String managerID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody//tr[" + index + "]/td[4]")).getText();
			if (managerCount.containsKey(managerID))
				managerCount.put(managerID, managerCount.get(managerID) + 1);
			else
				managerCount.put(managerID, 1);
		}
		return managerCount;
	}
}
