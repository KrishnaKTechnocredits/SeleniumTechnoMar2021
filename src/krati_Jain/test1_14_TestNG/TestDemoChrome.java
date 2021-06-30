package krati_Jain.test1_14_TestNG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemoChrome {

	public static void main(String[] args) throws InterruptedException {

		System.getProperty("webdriver.chrome.driver", "C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Test");
	
}
}