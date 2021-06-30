package upasana.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class TestCase3_2 {
	public static void main(String[] args) throws InterruptedException {

		String alertMsgExpected2 = "You successfully clicked on it";

		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");

		System.out.println("Step 1: Launch a chrome");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();   //Maximize window

		System.out.println("Step 2: Open Google.com");
		driver.get("https://google.com/");

		System.out.println("Step 3: navigate to \"http://automationbykrishna.com\"");
		driver.navigate().to("http://automationbykrishna.com");
		
		driver.manage().window().maximize();

		System.out.println("Step 4: Click on BasicElements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		System.out.println("Step 5: Enter Email and Password");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("Upasana");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Anand");
		System.out.println("Step 6: Click Submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("Step 7: Switch to Alert, get that text and verify.");
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		
		System.out.print("Step 8: ");
		if (alertMsgExpected2.equals(alertMsg))
			System.out.println("actual msg is same as expected : "+alertMsg);
		else
			System.out.println("actual msg is not same as expected");

		alert.accept();

		driver.close();
 
	}

}
