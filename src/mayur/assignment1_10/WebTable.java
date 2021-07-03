package mayur.assignment1_10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();

		String infoFullText = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] infoFullTextArr = infoFullText.split("of");
		System.out.println("Records on Table : " + infoFullTextArr[1].replace(" entries", ""));

		String empName = "Caesar Vance";
		WebElement empAgeWE = driver.findElement(
				By.xpath("//table[@id='example']//tr//td[text()='" + empName + "']//following-sibling::td[3]"));
		String empAge = empAgeWE.getText();
		System.out.println("Age of : " + empName + " is " + empAge);

		List<WebElement> empNameLondonList = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[text()='London']//ancestor::tr//td[1]"));

		for (WebElement empLondon : empNameLondonList) {
			System.out.println(empLondon.getText() + " Lives in London");
		}

		List<WebElement> empNameSEList = driver.findElements(
				By.xpath("//table[@id='example']//tr//td[text()='Software Engineer']//ancestor::tr//td[1]"));
		for (WebElement empSE : empNameSEList) {
			System.out.println(empSE.getText() + " is a Software Engineer");
		}

		List<WebElement> empAgeMoreThan25 = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]"));
		System.out.println("Number of Employee with Age more than 25 :" + empAgeMoreThan25.size());

		List<WebElement> empAgeMoreThan25Names = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]//ancestor::tr//td[1]"));
		for (WebElement empMoreThan25Age : empAgeMoreThan25Names) {
			System.out.println(empMoreThan25Age.getText() + " Age is 25+ Year");
		}

		System.out.println("Employee start date whose age is 66 :"
				+ driver.findElement(By.xpath("//table[@id='example']//tr//td[4][text()=66]//following-sibling::td[1]"))
						.getText());

		List<WebElement> ageList = driver.findElements(By.xpath("//table[@id='example']//tr/td[4]"));
		ageList.sort(new AgeComparator());
		ageList.get(0).getText();
		System.out.println("Salary Whose Age is Min :" + driver.findElement(By.xpath(
				"//table[@id='example']//tr/td[text()='" + ageList.get(0).getText() + "']//following-sibling::td[2]"))
				.getText());

		System.out.println(
				"No of records in table :" + driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());

		System.out.println("Text of Whole table :" + driver.findElement(By.xpath("//table[@id='example']")).getText());

		List<WebElement> salaryList = driver.findElements(By.xpath("//table[@id='example']//tr//td[6]"));
		salaryList.sort(new SalaryComparator());
		salaryList.get(0).getText();
		System.out.println("Age Whose salary is Min :" + driver.findElement(By.xpath(
				"//table[@id='example']//tr/td[text()='" + salaryList.get(0).getText() + "']//ancestor::tr//td[4]"))
				.getText());
		driver.close();
	}

}