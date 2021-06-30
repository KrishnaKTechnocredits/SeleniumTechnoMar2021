package krati_Shukla.Selenium;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		readingTable(driver);
		driver.close();
	}

	static void readingTable(WebDriver driver) throws InterruptedException {
		// How many total entries are there in table?
		Thread.sleep(5000);
		WebElement totEntries = driver.findElement(By.xpath("//div[@id='example_info']"));
		JavascriptExecutor jeEntries = (JavascriptExecutor) driver;
		jeEntries.executeScript("arguments[0].scrollIntoViews", totEntries);
		String entriesText = totEntries.getText();
		System.out.println(entriesText);
		String[] str = entriesText.split("of"); // Splitter the string
		String str2 = str[1];
		str2 = str2.trim(); // Removing first & last spaces from string
		System.out.println(str2);
		String[] str3 = str2.split(" ");
		System.out.println("Total Number of entries in the table are :" + str3[0]);

		// On Dynamic table - check age of Employee "Caesar Vance" - write Dynamic Xpath
		// - Print Age
		WebElement age = driver.findElement(By.xpath("//table[@id='example']//tr//td[1][text()='Caesar Vance']//following::td[3]"));
		System.out.println("Age required : " + age.getText());

		// Print Employee First Name of all employees working from London Office.
		List<WebElement> name = driver.findElements(
				By.xpath("//table[@id='example']//following::td[3][text()='London']//preceding-sibling::td[2]"));
		for (WebElement temp : name) {
			System.out.println(temp.getText());
		}

		// Find all Employees who hold Position as Software Engineer.
		List<WebElement> empName = driver.findElements(
				By.xpath("//table[@id='example']//td[2][text()='Software Engineer']//preceding-sibling::td[1]"));
		for (WebElement temp1 : empName) {
			System.out.println("Employess having position as Software Engineer :" + temp1.getText());
		}

		// Count number of Employee with age More than 25, on first page.
		List<WebElement> allAge = driver.findElements(By.xpath("//table[@id='example']//td[4]"));
		int count = 0;
		for (WebElement output : allAge) {
			String temp = output.getText();
			int newTemp = Integer.parseInt(temp);
			if (newTemp > 25) {
				count++;
			}

		}
		System.out.println("number of Employee with age More than 25 : " + count);
		
		//Print Employee Start date whose age is 66.
		WebElement startDate = driver.findElement(By.xpath("//table[@id='example']//td[4][text()='66']//following-sibling::td[1]"));
		System.out.println("Employee Start date whose age is 66. :"+startDate.getText());
		
		//Print employee Age whose salary is minimum.
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='example']//td[6]"));
		TreeSet<Integer> sortedSalary = new TreeSet<Integer>();
		int minSal=0;
		for(WebElement temp2 : allRows) {
			String allAge1 = temp2.getText();
			String newAllAge = allAge1.replace('$', ' ');
			String newAllAge1 = newAllAge.replaceAll(",", "");
			int output = Integer.parseInt(newAllAge1.trim());
			sortedSalary.add(output);			
		}
		for(int sal : sortedSalary) {
			minSal = sal;
			System.out.println(sal);
			break;
		}
	}

}
