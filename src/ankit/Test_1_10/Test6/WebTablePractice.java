package ankit.Test_1_10.Test6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();

		//		1. How many total entries are there in table?
		String infoFullText = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] infoFullTextArr = infoFullText.split("of");
		System.out.println("Records on Table : "+infoFullTextArr[1].replace(" entries", ""));

		//		2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
		String empName = "Caesar Vance";
		WebElement empAgeWE = driver.findElement(By.xpath("//table[@id='example']//tr//td[text()='"+empName+"']//following-sibling::td[3]"));
		String empAge = empAgeWE.getText();
		System.out.println("Age of : "+empName+" is "+empAge);

		//		3. Print Employee First Name of all employees working from London Office.
		List<WebElement> empNameLondonList = driver.findElements(By.xpath("//table[@id='example']//tr//td[text()='London']//ancestor::tr//td[1]"));
		//List<WebElement> empNameLondonList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3][text()='London']/preceding-sibling::td[2]"));
		for(WebElement empLondon :empNameLondonList ) {
			System.out.println(empLondon.getText()+" Lives in London");
		}
		//		4. Find all Employees who hold Position as Software Engineer.
		List<WebElement> empNameSEList = driver.findElements(By.xpath("//table[@id='example']//tr//td[text()='Software Engineer']//ancestor::tr//td[1]"));
		for(WebElement empSE :empNameSEList ) {
			System.out.println(empSE.getText()+" is a Software Engineer");
		}
		//		5. COunt number of Employee with age More than 25, on first page. 
		List<WebElement> empAgeMoreThan25 = driver.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]"));
		System.out.println("Number of Employee with Age more than 25 :"+empAgeMoreThan25.size());

		List<WebElement> empAgeMoreThan25Names = driver.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]//ancestor::tr//td[1]"));
		for(WebElement empMoreThan25Age :empAgeMoreThan25Names ) {
			System.out.println(empMoreThan25Age.getText()+" Age is 25+ Year");
		}
		//		6. Print Employee Start date whose age is 66.
		System.out.println("Employee start date whose age is 66 :"+driver.findElement(By.xpath("//table[@id='example']//tr//td[4][text()=66]//following-sibling::td[1]")).getText());

		//		7.1 Print employee Salary whose Age is minimum. 

		List<WebElement> ageList= driver.findElements(By.xpath("//table[@id='example']//tr/td[4]"));
		ageList.sort(new Age_Comparator());
		ageList.get(0).getText();
		System.out.println("Salary Whose Age is Min :"+driver.findElement(By.xpath("//table[@id='example']//tr/td[text()='"+ageList.get(0).getText()+"']//following-sibling::td[2]")).getText());

		//		8. How many rows in Table on first page.
		System.out.println("No of records in table :"+driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());

		//		9. Print all text in table. - on automation by Krishna 
		System.out.println("Text of Whole table :"+driver.findElement(By.xpath("//table[@id='example']")).getText());

		//		7.1 Print employee Age whose salary is minimum. 

		List<WebElement> salaryList= driver.findElements(By.xpath("//table[@id='example']//tr//td[6]"));
		salaryList.sort(new Salary_Comparator());
		salaryList.get(0).getText();
		System.out.println("Age Whose salary is Min :"+driver.findElement(By.xpath("//table[@id='example']//tr/td[text()='"+salaryList.get(0).getText()+"']//ancestor::tr//td[4]")).getText());
		driver.close();
	}

}
