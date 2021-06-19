/*
Test case - 11: 16th Jun'2021

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8
		 
 */

package sourabh.testCase11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase11 {
	static int getDeptCount(WebDriver driver) {
		List<WebElement> listOfDepts = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		List<String> depts = new ArrayList<String>();
		for (WebElement elements : listOfDepts) {
			depts.add(elements.getText());
		}
		HashSet<String> setOfDepts = new HashSet<String>(depts);
		return setOfDepts.size();
	}

	static int getCountOfManager(WebDriver driver) {
		List<WebElement> listOfManagerID = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashSet<String> setOfManagerID = new HashSet<String>();
		for (WebElement element : listOfManagerID) {
			setOfManagerID.add(element.getText());
		}
		
		return setOfManagerID.size();
	}
	
	static int getCountOfEmplyee(WebDriver driver) {
		HashSet<String> setOfEmplyee= new HashSet<String>();
		int countRows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1; index<=countRows; index++) {
			setOfEmplyee.add(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText());
		}
		return setOfEmplyee.size();
		
	}
	
	public static void main(String[] args) {
		System.out.println("STEP1 : Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP2 : Open URL ");
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		// ----------------------------------------------------------------------------------
		System.out.println("STEP3 : Wait for Demo Tables page to load  ");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		
		int deptCount = getDeptCount(driver);
		System.out.println("Number Depts we have : " + deptCount);

		int managerIDCount = getCountOfManager(driver);
		System.out.println("Number managers we have : " + managerIDCount);
		
		int employeesCount = getCountOfEmplyee(driver);
		System.out.println("Number employees we have : " + employeesCount);
		
		driver.close();
	}

}
