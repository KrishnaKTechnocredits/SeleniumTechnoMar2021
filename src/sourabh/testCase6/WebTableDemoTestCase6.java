/*
Test Case 6 :
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

package sourabh.testCase6;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTableDemoTestCase6 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Open url on browser");
		//String url1 = "https://datatables.net/";
		String url ="https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		driver.get(url);
		driver.manage().window().maximize();
		
		//1. How many total entries are there in table?
		String findFullText= driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		//Showing 1 to 10 of 57 entries
		String[] splitTest= findFullText.split("of ");
		String[] actualEntries= splitTest[1].split(" ");
		System.out.println("Total entries are there in table is : "+Integer.parseInt(actualEntries[0]));
		
		//2. On Dynamic table - check age of Employee "Caesar Vance" - write Dynamic Xpath - Print Age
		
		String findAge= driver.findElement(By.xpath("//td[text()='Caesar Vance']//following-sibling::td[3]")).getText();
		System.out.println("Age of Employee Caesar Vance is : "+Integer.parseInt(findAge));
		
		//3. Print Employee First Name of all employees working from London Office.
		
		WebElement entries = driver.findElement(By.xpath("//select[@name='example_length']"));
		Select entriesDropDown= new Select(entries);		
		entriesDropDown.selectByValue("100"); // change dropdown value from 10 to 100
		
		System.out.println("Employee working from London Office : ");
		List<WebElement> listName= driver.findElements(By.xpath("//td[text()='London']/parent::tr/td[@class='sorting_1']"));
		for(WebElement newlist: listName) {
			System.out.println(newlist.getText());
		}
		
		//4. Find all Employees who hold Position as Software Engineer.
		System.out.println("Employee hold Position as Software Engineer : ");
		List<WebElement> listNameSE= driver.findElements(By.xpath("//td[text()='Software Engineer']/parent::tr/td[@class='sorting_1']"));
		for(WebElement newlistSE: listNameSE) {			
			System.out.println(newlistSE.getText());
		}
		
		//5. COunt number of Employee with age More than 25, on first page.
		/*WebElement entries1 = driver.findElement(By.xpath("//select[@name='example_length']"));
		Select entriesDropDown1= new Select(entries);*/		
		entriesDropDown.selectByValue("10");
		
		List<WebElement> findNameAge= driver.findElements(By.xpath("//td[text()>25]"));
			System.out.println("Count number of Employee with age More than 25 on first page is : "+findNameAge.size());
		
		//6. Print Employee Start date whose age is 66.
		String startDate= driver.findElement(By.xpath("//td[text()='66']//following::td[1]")).getText();
		System.out.println("Employee Start date whose age is 66 : "+startDate);
		
		//7. Print employee Age whose salary is minimum. 
		
		List<WebElement> listAllAge= driver.findElements(By.xpath("//td[4]"));
		TreeSet<Integer> sortAgeList = new TreeSet<>();
		for(WebElement allAge: listAllAge ) {
			int ageList=Integer.parseInt(allAge.getText());
			sortAgeList.add(ageList);			
		}
		System.out.println("Lowest age: "+sortAgeList.first());
		
		String salary= driver.findElement(By.xpath("//td[text()='21']//following-sibling::td[2]")).getText();
		System.out.println("Salary : "+salary);
				
		//8. How many rows in Table on first page.
		List<WebElement> countRow= driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));
		System.out.println("Count rows in Table on first page is : "+countRow.size());
		
		
		//9. Print all text in table
		String allText= driver.findElement(By.xpath("//table[@id='example']")).getText();
		System.out.println(allText);
		System.out.println("End");
	}

}
