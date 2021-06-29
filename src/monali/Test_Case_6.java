package monali;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//7. Print employee Age whose salary is minimum. 


public class Test_Case_6 {
	
	 public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html ");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//1. How many total entries are there in table?
		String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arr = text.split("of");
		String temp = arr[1].trim().replace(" entries", "");
		System.out.println("total entries are : "+Integer.parseInt(temp));
		
		
		//2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
		String age = driver.findElement(By.xpath("//td[text()=\"Caesar Vance\"]//following::td[3]")).getText();
			System.out.println("Age of Caesar Vnace is : "+age);
		
		//3. Print Employee First Name of all employees working from London Office.
		List<WebElement> listOfName = driver.findElements(By.xpath("//td[text()='London']//parent::tr//td[1]"));
		for( WebElement e: listOfName) {
			System.out.println("Employee working from london office are : "+e.getText());
		}
		
		//4. Find all Employees who hold Position as Software Engineer.
		List<WebElement> listOfSoftwareEngg = driver.findElements(By.xpath("//td[text()='Software Engineer']//parent::tr//td[1]"));
		for( WebElement e: listOfSoftwareEngg) {
			System.out.println("Employee who the position of software engg are : "+e.getText());
		}
		
		//5. COunt number of Employee with age More than 25, on first page.
		List<WebElement> employeeList = driver.findElements(By.xpath("//td[text()>22]"));
			System.out.println("number of employee having age more than 22 are : "+employeeList.size());
			
		//6. Print Employee Start date whose age is 66.
			String date = driver.findElement(By.xpath("//td[text()='66']/following-sibling::td[1]")).getText();
				System.out.println("employee start date whose age is 66 is : "+date);
				
				//8. How many rows in Table on first page.
				List<WebElement> listOfRow = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
				System.out.println("number of rows on first page are : "+listOfRow.size());
				
				//9. Print all text in table
				System.out.println(driver.findElement(By.id("example")).getText());

	 }

}
