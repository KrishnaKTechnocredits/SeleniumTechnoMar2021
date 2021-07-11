package vaibhav.TestCase_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_1_Extra {

	public static void main(String[] args) throws InterruptedException {

		String expectedSuccessMessage = "Success!";
		String expectedFailedMessage = "Failed! please enter strong password";
		
		System.out.println("Step 1 : Open http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		
		System.out.println("Step 2 : click on registraion tab");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(2000);
		System.out.println("Step 3 : Enter user name");
		driver.findElement(By.id("unameSignin")).sendKeys("Vaibhav Tati");
		
		System.out.println("Step 4 : Enter password");
		String password = "Vaibhav123";
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		
		System.out.println("Step 5 : Click on Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		System.out.println("Step 6 : Verify Alert");
		Alert alert = driver.switchTo().alert();
		String alertActualText = alert.getText();
		
		if (password.length()>8) {
			if (alertActualText.equals(expectedSuccessMessage)) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}			
		}else {
			if (alertActualText.equals(expectedFailedMessage)) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}
			
		}
		
		alert.accept();
		

		
	}

}
