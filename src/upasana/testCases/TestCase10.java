/*
Name -> "Maulik", print lastName and UserName
 */

package upasana.testCases;

import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase10 {

	static HashMap<String, String> getOutput(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		HashMap<String, String> map = new HashMap<String, String>();
		String lName = driver
				.findElement(By.xpath("//table[@class='table']/tbody/tr/td[text()='Maulik']/following-sibling::td[1]"))
				.getText();
		String uName = driver
				.findElement(By.xpath("//table[@class='table']/tbody/tr/td[text()='Maulik']/following-sibling::td[2]"))
				.getText();
		map.put(lName, uName);
		return map;
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		HashMap<String, String> mapOutput = getOutput(driver);
		System.out.println(mapOutput);
		driver.close();
	}
}