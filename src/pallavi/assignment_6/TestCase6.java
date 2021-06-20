package pallavi.assignment_6;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase6 {

	static String getTotalEnteries(WebDriver driver) {
		String text = driver.findElement(By.xpath("//div[text()='Showing 1 to 10 of 57 entries']")).getText();
		String arr[] = text.split("of");
		String getEntry = arr[1].trim().replace("entries", " ");
		System.out.println(getEntry);
		System.out.println("Executing");
		return getEntry;

	}

	static int getAgeOfEmplyee(WebDriver driver) {
		String age = driver.findElement(By.xpath("//td[text()='Caesar Vance']//following-sibling::td[3]")).getText();
		return Integer.parseInt(age);
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 1. How many total entries are there in table?
		String totalEntry = getTotalEnteries(driver);
		System.out.println("Total Entry : " + totalEntry);
		System.out.println();

		// 2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic
		// Xpath - Print Age
		int age = getAgeOfEmplyee(driver);
		System.out.println("Age of Emolyee :" + age);
		System.out.println();

		// 3 Print Employee First Name of all employees working from London Office.
		List<WebElement> listofEmplyee = driver
				.findElements(By.xpath("//td[text()='London']//preceding-sibling::td[2]"));
		System.out.println("Name of Employee working from london :");
		for (WebElement employee : listofEmplyee) {
			System.out.println(employee.getText());
		}
		System.out.println();

		// 4. Find all Employees who hold Position as Software Engineer.
		List<WebElement> listOfSoftwareEng = driver
				.findElements(By.xpath("//td[text()='Software Engineer']//preceding-sibling::td[1]"));
		System.out.println("List of Software Engineer : ");
		for (WebElement softEng : listOfSoftwareEng) {
			System.out.println(softEng.getText());
		}
		System.out.println();

		// 5. COunt number of Employee with age More than 25, on first page.
		List<WebElement> ageMoreThan25 = driver.findElements(By.xpath("//td[text()>'25']"));
		System.out.println("Age More Than 25 count is :" + ageMoreThan25.size());
		System.out.println();

		// 6. Print Employee Start date whose age is 66.
		WebElement startDate = driver.findElement(By.xpath("//td[text()='66']//following-sibling::td[1]"));
		System.out.println("Start Date :" + startDate.getText());
		System.out.println();

		// 7. Print employee Age whose salary is minimum.

		List<WebElement> age1 = driver.findElements(By.xpath("//tr/td[4]"));
		TreeSet<Integer> sortedAge = new TreeSet<Integer>();
		for (WebElement a : age1) {
			int ageConvertedToInt = Integer.parseInt(a.getText());
			sortedAge.add(ageConvertedToInt);
		}
		// System.out.println("Minimum age :" + sortedAge.first());
		String salary = driver.findElement(By.xpath("//td[text()='21']//following-sibling::td[2]")).getText();
		System.out.println("Salary : " + salary);

		// 8. How many rows in Table on first page.
		List<WebElement> row = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));
		System.out.println(row.size());
		System.out.println();

		// 9. Print all text in table

		String text = driver.findElement(By.xpath("//table[@id='example']")).getText();
		System.out.println(text);

		driver.close();

	}

}
