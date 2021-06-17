// For name "Maulik", print lastName and UserName

package sangeeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase10 {

	static ArrayList<String> getEmpInfoByArrayList(WebDriver driver) {
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();
		ArrayList<String> empDetailsList = new ArrayList<String>();
		empDetailsList.add(lName);
		empDetailsList.add(userName);
		return empDetailsList;
	}

	static HashMap<String, String> getEmpInfo(WebDriver driver) {
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();
		HashMap<String, String> empDetailsMap = new HashMap<String, String>();
		empDetailsMap.put("LastName", lName);
		empDetailsMap.put("UserName", userName);
		return empDetailsMap;
	}

	static String[] usingArray(WebDriver driver) {
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();

		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();

		String[] empDetailsList = new String[2];
		empDetailsList[0] = lName;
		empDetailsList[1] = userName;
		return empDetailsList;
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> employeeDetailsByList = getEmpInfoByArrayList(driver);
		System.out.println("Using Array List: " + employeeDetailsByList);
		HashMap<String, String> employeeDetails = getEmpInfo(driver);
		System.out.println("Using HashMap: " + employeeDetails);
		String[] employeeDetailsByArray = usingArray(driver);
		System.out.println("Using array: " + Arrays.toString(employeeDetailsByArray));
	}
}
