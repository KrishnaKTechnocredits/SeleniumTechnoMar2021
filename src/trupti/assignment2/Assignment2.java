package trupti.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step 1-Launch a chrome");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step 2-Open Google.com");
		driver.get("https://www.google.com/");
		System.out.println("Step 3-Get and Verify Page Title");
		String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Page Title is correct");
		}
		else {
			System.out.println("Page Title not matching");
		}
		Thread.sleep(2000);
		System.out.println("Step 4-Navigate to automationbykrishna.com ");
		driver.navigate().to("http://automationbykrishna.com/");
		System.out.println("Step 5-Get and Verify page title ");
		String expectedTitle1="Login Signup Demo";
		String actualTitle1=driver.getTitle();
		if(expectedTitle1.equals(actualTitle1)) {
			System.out.println("For AutomationByKrishna site Page Title is correct");
		}
		else {
			System.out.println("For AutomationByKrishna site Page Title not matching");
		}
		System.out.println("Step 6-Navigate back in History");
		driver.navigate().back();
		System.out.println("Step 7-Get and Verify Page Title");
		if(expectedTitle.equals(driver.getTitle())) {
			System.out.println("Page Title is correct");
		}
		else {
			System.out.println("Page Title not matching");
		}
		System.out.println("Step 8-Navigate Forward in the History");
		driver.navigate().forward();
		System.out.println("\"Step 9-Get and Verify Page Title\"");
		if(expectedTitle1.equals(driver.getTitle())) {
			System.out.println("For AutomationByKrishna site Page Title is correct");
		}
		else {
			System.out.println("For AutomationByKrishna site Page Title not matching");
		}
		System.out.println("Step 10-Refresh page and verify page title ");
		driver.navigate().refresh();
		if(expectedTitle1.equals(driver.getTitle())) {
			System.out.println("For AutomationByKrishna site Page Title is correct");
		}
		else {
			System.out.println("For AutomationByKrishna site Page Title not matching");
		}
		driver.close();
	}

}
