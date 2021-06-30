package upasana.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class TestCase3_1 {
	public static void main(String[] args) throws InterruptedException {

		String alertMsgExpected = "Upasana and Anand and TCS";

		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");

		System.out.println("Step 1: Launch a chrome");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		System.out.println("Step 2: Open Google.com");
		driver.get("https://google.com/");

		System.out.println("Step 3: navigate to \"http://automationbykrishna.com\"");
		driver.navigate().to("http://automationbykrishna.com");

		System.out.println("Step 4: Click on BasicElements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
		System.out.println("Step 5: Enter Fname, Lname and Company name");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys("Upasana");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys("Anand");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys("TCS");

		System.out.println("Step 6: Click Submit");
		driver.findElement(By.xpath("//button[@type='submit' and @onclick='myFunctionPopUp()']")).click();

		System.out.println("Step 7: Switch to Alert, get that text and verify.");
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		if (alertMsgExpected.equals(alertMsg))
			System.out.println("title : " + alertMsg + " is same");
		else
			System.out.println("title " + alertMsg + " is different");

		alert.accept();
		driver.close();

	}

}
