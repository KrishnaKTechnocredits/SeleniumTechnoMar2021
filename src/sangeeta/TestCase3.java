/*Test - 3
 
TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.
C#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it" 
Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"
*/
package sangeeta;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://www.automationbykrishna.com";
		driver.get(url);
		Thread.sleep(2000);
		System.out.println("STEP 1 :- Click on Basic Element link");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		
		Thread.sleep(5000);
		
		System.out.println("STEP 2 :- Enter first name");
		driver.findElement(By.xpath("//*[@id='UserFirstName']")).sendKeys("Sangeeta");
		
		System.out.println("STEP 3 :- Enter last name");
		driver.findElement(By.xpath("//*[@id='UserLastName']")).sendKeys("Bhandarkar");
		
		System.out.println("STEP 4 :- Enter Company name");
		driver.findElement(By.xpath("//*[@id='UserCompanyName']")).sendKeys("Gallagher");

		
		Thread.sleep(5000);
		System.out.println("STEP 5 :- Click on submit button");
		WebElement element = driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']"));
		element.click();
		//String actualString = element.getText();
		//System.out.println(actualString);
		
		//String ExpectedString = "Sangeeta and Bhandarkar and Gallagher";
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String msg = alert.getText();
		System.out.println(msg);
		
	/*	if(actualString.equals(ExpectedString))
			System.out.println("Button verified");*/
		
		
	}

}
