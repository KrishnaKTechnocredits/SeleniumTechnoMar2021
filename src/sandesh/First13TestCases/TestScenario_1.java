package sandesh.First13TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\TechnoCredit\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		System.out.println(" :-- Test Case 1 --: ");
		String title = driver.getTitle();
		int lengthOfTitle = title.length();
		System.out.println("Page title is -: " + title + " and length of title is -: " + lengthOfTitle);

		System.out.println(" :-- Test Case 2 --: ");
		String expectedURL = "https://www.google.com/";
		String actualURL = driver.getCurrentUrl();
		if (expectedURL.equals(actualURL)) {
			System.out.println("Test Case 2 passed as expected URL is equal to actual URL");
		} else
			System.out.println("Test Case 2 failed");

		System.out.println(" :-- Test Case 3 --: ");
		int lengthOfPageSource = driver.getPageSource().length();
		System.out.println("Page source length is -: " + lengthOfPageSource);
	}
}
