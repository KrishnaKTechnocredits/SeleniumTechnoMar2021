/*TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.*/

package sangeeta.TestCase14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_14_3 {
	
	@Test
	public void loginTest(){
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://www.automationbykrishna.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP 1 :- Click on Basic Element link");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();

		System.out.println("STEP 2 :- Enter first name");
		driver.findElement(By.xpath("//*[@id='UserFirstName']")).sendKeys("Sangeeta");

		System.out.println("STEP 3 :- Enter last name");
		driver.findElement(By.xpath("//*[@id='UserLastName']")).sendKeys("Bhandarkar");

		System.out.println("STEP 4 :- Enter Company name");
		driver.findElement(By.xpath("//*[@id='UserCompanyName']")).sendKeys("Gallagher");

		System.out.println("STEP 5 :- Click on submit button");
		WebElement element = driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']"));
		element.click();

		String ExpectedString = "Sangeeta and Bhandarkar and Gallagher";
		Alert alert = driver.switchTo().alert();

		String msg = alert.getText();
		System.out.println(msg);
		Assert.assertEquals(msg, ExpectedString);
		alert.accept();
	}
}
