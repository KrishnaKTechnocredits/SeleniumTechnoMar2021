/*
 rows and cols are dynamic, get the lastname of the emp whose firstname is "Abhishek".
 */

package upasana.testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class TestCase7 {

	static ArrayList<String> getHeaderNames(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement element : elementList) {
			headerList.add(element.getText());
		}
		return headerList;
	}

	static String getLname(WebDriver driver, String fName, int index) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		String lName = driver.findElement(By.xpath("//td[text()='" + fName + "']//parent::tr/td[" + index + "]"))
				.getText();
		return lName;

	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> headerList = getHeaderNames(driver);
		System.out.println(headerList);
		int index = headerList.indexOf("Last Name") + 1;
		String fName = "Abhishek";
		String lName = getLname(driver, fName, index);
		System.out.println("lastname of the emp whose firstname is " + fName + " is " + lName);
		driver.close();
	}
}