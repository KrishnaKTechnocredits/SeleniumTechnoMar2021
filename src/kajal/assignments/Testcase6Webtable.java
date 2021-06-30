package kajal.assignments;

/*
 * TC#6
Problem Statements :
1. How many total entries are there in table?
2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
3. Print Employee First Name of all employees working from London Office.
4. Find all Employees who hold Position as Software Engineer.
5. COunt number of Employee with age More than 25, on first page.
6. Print Employee Start date whose age is 66.
7. Print employee Age whose salary is minimum. 
8. How many rows in Table on first page.
9. Print all text in table
*/
import java.util.List;
import java.util.TreeSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase6Webtable {

	static void tableInfo(WebDriver driver) throws InterruptedException {
		System.out.println("STEP3 How many total entries are there in table?");
		Thread.sleep(5000);
		WebElement totEntries = driver.findElement(By.xpath("//div[@id='example_info']"));
		JavascriptExecutor jeEntries = (JavascriptExecutor) driver;
		jeEntries.executeScript("arguments[0].scrollIntoViews", totEntries);
		String entriesText = totEntries.getText();
		System.out.println(entriesText);
		String[] str = entriesText.split("of");
		String str2 = str[1];
		System.out.println("Removing EXTRA spaces from string");
		str2 = str2.trim();
		System.out.println(str2);
		String[] str3 = str2.split(" ");
		System.out.println("STEP4 Total Number of entries in the table are :" + str3[0]);
		System.out.println(
				"STEP5 On Dynamic table - check age of Employee \"Vaesar Vance\" - write Dynamic Xpath - Print Age");

		WebElement age = driver
				.findElement(By.xpath("//table[@id='example']//tr//td[1][text()='Caesar Vance']//following::td[3]"));
		System.out.println("Age required : " + age.getText());

		System.out.println("STEP6 Print Employee First Name of all employees working from London Office.");
		List<WebElement> name = driver.findElements(
				By.xpath("//table[@id='example']//following::td[3][text()='London']//preceding-sibling::td[2]"));
		for (WebElement temp : name) {
			System.out.println(temp.getText());
		}

		System.out.println("STEP7 Find all Employees who hold Position as Software Engineer.");
		List<WebElement> empName = driver.findElements(
				By.xpath("//table[@id='example']//td[2][text()='Software Engineer']//preceding-sibling::td[1]"));
		for (WebElement temp1 : empName) {
			System.out.println("Employess having position as Software Engineer :" + temp1.getText());
		}

		System.out.println("STEP8 Count number of Employee with age More than 25, on first page.");
		List<WebElement> allAge = driver.findElements(By.xpath("//table[@id='example']//td[4]"));
		int count = 0;
		for (WebElement output : allAge) {
			String temp = output.getText();
			int newTemp = Integer.parseInt(temp);
			if (newTemp > 25) {
				count++;
			}

		}
		System.out.println("STEP9 number of Employee with age More than 25 : " + count);

		System.out.println("STEP10 Print Employee Start date whose age is 66.");
		WebElement startDate = driver
				.findElement(By.xpath("//table[@id='example']//td[4][text()='66']//following-sibling::td[1]"));
		System.out.println("Employee Start date whose age is 66. :" + startDate.getText());

		System.out.println("STEP11 Print employee Age whose salary is minimum.");
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='example']//td[6]"));
		TreeSet<Integer> sortedSalary = new TreeSet<Integer>();

		for (WebElement temp2 : allRows) {
			String allAge1 = temp2.getText();
			String newAllAge = allAge1.replace('$', ' ');
			String newAllAge1 = newAllAge.replaceAll(",", "");
			int output = Integer.parseInt(newAllAge1.trim());
			sortedSalary.add(output);
		}
		for (int sal : sortedSalary) {
			System.out.println(sal);
			break;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.out.println("STEP1 driver initialization");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP2 open given url");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		tableInfo(driver);
		driver.close();
	}

}
