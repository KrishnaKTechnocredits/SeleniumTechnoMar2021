package prachi.Assignment_1_to_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");


		System.out.println("Step1-Launch a browser");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step2-Open Google");
		driver.get("https://www.google.com/");

		System.out.println("Step3-Get page title name and verify with expected title");
		String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("The Title matched");
		}else {
			System.out.println("Title mismatched");
		}
		System.out.println("Step4-navigate to automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");

		System.out.println("Step5-Get page title name and verify with expected titleof navigated URL");
		String expectedTitle2="Login Signup Demo";
		String actualTitle2=driver.getTitle();
		if(expectedTitle2.equals(actualTitle2)) {
			System.out.println("The Title matched");
		}else {
			System.out.println("Title mismatched");
		}

		System.out.println("Step6-navigate back in history");
		driver.navigate().back();

		System.out.println("Step7-Get page title name and verify with expected title [google]");
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("The Title matched");
		}else {
			System.out.println("Title mismatched");
		}

		System.out.println("Step8-navigate forward in the history");
		driver.navigate().forward();

		System.out.println("Step9-Get page title name and verify with expected title [automationbykrishna]");
		if(expectedTitle2.equals(actualTitle2)) {
			System.out.println("The Title matched");
		}else {
			System.out.println("Title mismatched");
		}

		System.out.println("Step10-refresh the page and verify the expected title [automationbykrishna]");
		if(expectedTitle2.equals(actualTitle2)) {
			System.out.println("The Title matched");
		}else {
			System.out.println("Title mismatched");
		}

		System.out.println("Step11-Close the browser");
		driver.close();
	}
}
