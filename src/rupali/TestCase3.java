package rupali;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *
 TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.

TC#6
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
Reference URL
https://datatables.net/extensions/autofill/examples/initialisation/focus.html



 */
public class TestCase3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Rupali");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Lahoti");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("technocredits");
		driver.findElement(By.xpath("//button[@onClick='myFunctionPopUp()']")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		System.out.print(actualAlertText);
		String expectedAlertText = "Rupali and Lahoti and technocredits";
		
		if(actualAlertText.equals(expectedAlertText)) 
			System.out.println("Alert Text is correct - PASS");
		else 
			System.out.println("Alert Text is Incorrect - FAIL");
		
		alert.accept();
		driver.close();

		
		
				

	}
}
