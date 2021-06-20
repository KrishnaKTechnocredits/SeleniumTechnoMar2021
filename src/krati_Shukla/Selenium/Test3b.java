package krati_Shukla.Selenium.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3b {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		scriptConfirmation(driver);
		scriptPrompt(driver);
		Thread.sleep(1000);
		driver.close();
	}

	static void scriptConfirmation(WebDriver driver) throws InterruptedException {

		String cancel = "You pressed Cancel!";
		String Ok = "You pressed OK!";
		System.out.println("Clicking Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")); // Finding element
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element); // scrolling down page
		element.click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		Thread.sleep(1000);
		// If user hits OK
		alert.accept();
		String acceptMesg = driver.findElement(By.id("pgraphdemo")).getText();
		String rejectMesg = driver.findElement(By.id("pgraphdemo")).getText();

		if (Ok.equals(acceptMesg))
			System.out.println("User pressed OK");
		else
			System.out.println("Wrong message");
	

	}
	
	static void scriptPrompt(WebDriver driver) throws InterruptedException {
		
		String input = "Hello Krati! How are you today?";
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.id("javascriptPromp"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click(); //Clicking on Javascript prompt
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Krati");
		alert.accept();
		String alertText = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(alertText);
		
		if (input.equals(alertText))
			System.out.println("Message verified successfully");
	}

}
