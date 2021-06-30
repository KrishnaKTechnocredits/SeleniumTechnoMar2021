package ankit.Test_1_10.Test3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Enter Fname");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Ankit");

		System.out.println("STEP - Enter Lname");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Malvi");

		System.out.println("STEP - Company name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("TechnoCredits");

		System.out.println("STEP - click submit");
		driver.findElement(By.xpath("//button[@onClick='myFunctionPopUp()']")).click();

		System.out.println("STEP - get alert, get that text");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "Ankit and Malvi and TechnoCredits";

		System.out.println("VERIFY - Alert Text");
		if(actualAlertText.equals(expectedAlertText)) 
			System.out.println("Alert Text is correct - PASS");
		else 
			System.out.println("Alert Text is Incorrect - FAIL");
		
		System.out.println("STEP - Close or Accept Alert");
		alert.accept();
		
		System.out.println("STEP - Close Browser ");
		driver.close();

	}

}
