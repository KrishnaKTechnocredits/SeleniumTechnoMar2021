// For name "Maulik", print lastName and UserName
package sangeeta.TestCase14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase_14_10 {
	
	@Test	
	public void getEmpInfoByArrayList() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();
		ArrayList<String> empDetailsList = new ArrayList<String>();
		empDetailsList.add(lName);
		empDetailsList.add(userName);
		System.out.println("Using Array List: " + empDetailsList);
	}
	
	@Test
	public void getEmpInfo() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();
		HashMap<String, String> empDetailsMap = new HashMap<String, String>();
		empDetailsMap.put("LastName", lName);
		empDetailsMap.put("UserName", userName);
		System.out.println("Using HashMap: " + empDetailsMap);
	}
	
	@Test
	public void usingArray() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();

		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();

		String[] empDetailsList = new String[2];
		empDetailsList[0] = lName;
		empDetailsList[1] = userName;
		System.out.println("Using array: " + Arrays.toString(empDetailsList));
	}
}
