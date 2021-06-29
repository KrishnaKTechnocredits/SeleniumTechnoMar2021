package shilpa.Assignment_1_10;

/*TC-6 - 3.Print Employee First Name of all employees working from London Office.*/
import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC6_3_PrintALlEmpFname {
	void PrintALlFNAme(String empCity) {
		WebDriver driver = new LaunchBrowser().start("https://datatables.net/");

		int size = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> fNameList = new ArrayList<String>();
		System.out.println("STEP - Find Employee working from Landon office");
		for (int index = 1; index <= size; index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empList = driver.findElements(By.xpath(
					"//table[@id='example']/tbody/tr/td[3][text()='" + empCity + "']//preceding-sibling::td[2]"));
			for (WebElement webElement : empList) {
				nameList.add(webElement.getText());
			}
		}
		Object[] namesArr = nameList.toArray();
		for (int innerIndex = 0; innerIndex < namesArr.length; innerIndex++) {
			fNameList.add(namesArr[innerIndex].toString().replaceAll("\\s[a-zA-Z]*", ""));
		}
		System.out.println("Below is the first name of Employee working at loction: " + empCity + "\n" + fNameList);
		driver.close();
	}

	public static void main(String[] args) {
		TC6_3_PrintALlEmpFname test = new TC6_3_PrintALlEmpFname();
		test.PrintALlFNAme("London");
	}
}
