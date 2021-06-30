/*1. How many total entries are there in table?
2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
3. Print Employee First Name of all employees working from London Office.
4. Find all Employees who hold Position as Software Engineer.
5. COunt number of Employee with age More than 25, on first page.
6. Print Employee Start date whose age is 66.
7. Print employee Age whose salary is minimum. 
8. How many rows in Table on first page.
9. Print all text in table*/

package sangeeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataTableProblems {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Que 1: How many total entries are there in table?");
		String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String [] textArr = text.split("of ");
		String temp = textArr[1].trim().replace(" entries","");
		System.out.println("Total entries are: "+Integer.parseInt(temp));
		System.out.println("");
		
		System.out.println("Que 2: Print age of Employee Caesar Vance");
		String ageCV = driver.findElement(By.xpath("//table[@id='example']//tr//td[text()='Caesar Vance']//following-sibling::td[3]")).getText();
		System.out.println("Age of Caesar Vance is: "+Integer.parseInt(ageCV));
		System.out.println("");
		
		System.out.println("Que 3: Print employee First Name of all employees working from London Office");
		List<WebElement> listOfFirstName = driver.findElements(By.xpath("//td[text()='London']//parent::tr//td[1]"));
			for(WebElement e : listOfFirstName){
				System.out.println(e.getText());
			}
		System.out.println("");
			
		System.out.println("Que 4: Find all Employees who hold Position as Software Engineer");	
		List<WebElement> listOfSoftEngg = driver.findElements(By.xpath("//td[text()='Software Engineer']//parent::tr//td[1]"));
		for(WebElement e : listOfSoftEngg){
			System.out.println(e.getText());
		}
		System.out.println("");
		
		System.out.println("Que 5: Count number of Employee with age More than 25");
		List<WebElement> countOfEmpAgeAbove25 = driver.findElements(By.xpath("//table[@id='example']//tr//td[text()>'25']"));
		System.out.println("Count of empoloyees having age more than 25 is: "+countOfEmpAgeAbove25.size());
		System.out.println("");
		
		System.out.println("Que 6: Print Employee Start date whose age is 66");
		String empStrtDate = driver.findElement(By.xpath("//table[@id='example']//tr//td[text()='66']//following-sibling::td[1]")).getText();
		System.out.println("Employee Start date whose age is 66 is: "+empStrtDate);
		System.out.println("");
		
		System.out.println("Que 7: Print employee Age whose salary is minimum");
		List<WebElement> elementOfSalary = driver.findElements(By.xpath("//table[@id='example']//tr//td[6]"));
		ArrayList<String> listOfSalary = new ArrayList<String>();
		for(WebElement e : elementOfSalary){
			listOfSalary.add(e.getText().replace("$", "").replace(",", ""));
			
		}
		ArrayList<Integer> salaryList = new ArrayList<Integer>();
		for(String str : listOfSalary) {
			salaryList.add(Integer.valueOf(str));
		}
		Collections.sort(salaryList);
		int minSalary = salaryList.get(0);
		System.out.println("Minimim salary is:"+minSalary);
		String age = driver.findElement(By.xpath("//table[@id='example']//tbody//tr//td[text() = '$86,000']//preceding-sibling::td[2]")).getText();
		System.out.println("employee Age whose salary is minimum: "+age);
		System.out.println("");
		
		System.out.println("Que 8: How many rows in Table on first page.");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));
		System.out.println("Number of rows in Table on first page is: "+rows.size());
		System.out.println("");
		
		System.out.println("Que 9: Print all text in table");
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='example']"));
			for(WebElement e : tableData) {
				System.out.println(e.getText());
			}
	}

}
