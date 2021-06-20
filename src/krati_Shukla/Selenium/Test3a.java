package krati_Shukla.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import krati_Shukla.Selenium.base.SetURL;

public class Test3a {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		alert(driver);
		Thread.sleep(3000);
		driver.close();
	}

	static void alert(WebDriver driver) throws InterruptedException {

		String input = "You must be TechnoCredits student!!";

		System.out.println("Clicking Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.id("javascriptAlert")); // finding the element
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element); //scrolling down the page
		System.out.println("Click Alert button");
		element.click();
		//driver.findElement(By.xpath("//button[@id='javascriptAlert'][@onclick='callJavaScriptAlert()']")).click();
		Thread.sleep(1000);

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		if (input.equals(alertText))
			System.out.println("Alert text is same");
		else
			System.out.println("Alert text is different");
		alert.accept();
	}

}
