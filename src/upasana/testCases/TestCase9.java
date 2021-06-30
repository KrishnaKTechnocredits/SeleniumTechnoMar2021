/*
verify username from table "EMPLOYEE BASIC INFORMATION"
 */

package upasana.testCases;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class TestCase9 {

	static ArrayList<String> getFNameList(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		ArrayList<String> getFNameList = new ArrayList<String>();
		List<WebElement> list1 = driver.findElements(By.xpath("// table[@class='table']/tbody/tr/td[2]"));
		for (WebElement element : list1) {
			getFNameList.add(element.getText());
		}
		return getFNameList;
	}

	static ArrayList<String> getLNameList(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		ArrayList<String> getLNameList = new ArrayList<String>();
		List<WebElement> list1 = driver.findElements(By.xpath("// table[@class='table']/tbody/tr/td[3]"));
		for (WebElement element : list1) {
			getLNameList.add(element.getText());
		}
		return getLNameList;
	}

	static ArrayList<String> getUNameList(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		ArrayList<String> getUNameList = new ArrayList<String>();
		List<WebElement> list1 = driver.findElements(By.xpath("// table[@class='table']/tbody/tr/td[4]"));
		for (WebElement element : list1) {
			getUNameList.add(element.getText());

		}
		return getUNameList;
	}

	static void verifyUNameList(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		ArrayList<String> getFNameList = getFNameList(driver);
		ArrayList<String> getLNameList = getLNameList(driver);
		ArrayList<String> getUNameList = getUNameList(driver);

		int size = driver.findElements(By.xpath("// table[@class='table']/tbody/tr")).size();
		String expected = "";
		String actual = "";
		for (int index = 0; index < size; index++) {
			actual = (getFNameList.get(index).charAt(0) + getLNameList.get(index)).toLowerCase();
			expected = getUNameList.get(index);
			if (actual.equals(expected))
				System.out.println("username " + actual + " is as expected");
			else
				System.out.println("different");

		}
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		verifyUNameList(driver);
		driver.close();
	}
}