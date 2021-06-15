package ankit.Test_1_10.Test3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Enter Email ID ");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("Ankit.Malvi");
		
		Thread.sleep(2000);
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Malvi");
		
		Thread.sleep(2000);
		System.out.println("STEP - Click on submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Thread.sleep(2000);
		System.out.println("STEP - Verify message on Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You successfully clicked on it"; 
		
		Thread.sleep(2000);
		System.out.println("VERIFY - Message on Alert");
		if(actualText.equals(expectedText)) 
			System.out.println("Alert Text is correct - PASS");
		else 
			System.out.println("Alert Text is Incorrect - FAIL");

		System.out.println("STEP - Close or Accept Alert");
		alert.accept();

		System.out.println("STEP - Close Browser ");
		driver.close();
	}
}
