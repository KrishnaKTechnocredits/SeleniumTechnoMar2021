package priyanka_Panat.TestCases1_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");

		System.out.println("1. Launch a chrome");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";

		System.out.println("2. Open Google.com");
		driver.get(url);

		System.out.println("3. Get page title name and verify with expected title");
		String title = driver.getTitle();
		String expectedTitle = "Google";
		if (title.equals(expectedTitle))
			System.out.println("Test Passed");
		else
			System.out.println("Test failed");

		System.out.println("4.navigate to automationbykrishna.com");
		Thread.sleep(2000);
		driver.navigate().to("http://automationbykrishna.com/");

		System.out.println("5. Get page title name and verify with expected title");
		title = driver.getTitle();
		expectedTitle = "Login Signup Demo";
		if (title.equals(expectedTitle))
			System.out.println("After navigating to automationbykrishna title is equal");
		else
			System.out.println("Test failed");

		System.out.println("6. navigate back in history");
		Thread.sleep(2000);
		driver.navigate().back();

		System.out.println("7. Get page title name and verify with expected title [google]");
		title = driver.getTitle();
		expectedTitle = "Google";
		if (title.equals(expectedTitle))
			System.out.println("After navigating back to Google.com title is same");
		else
			System.out.println("Test failed");

		System.out.println("8. navigate forward in the history");
		Thread.sleep(2000);
		driver.navigate().forward();

		System.out.println("9. Get page title name and verify with expected title [automationbykrishna]");
		title = driver.getTitle();
		expectedTitle = "Login Signup Demo";
		if (title.equals(expectedTitle))
			System.out.println("After navigating again to automationbykrishna from google.com title is equal");
		else
			System.out.println("Test failed");

		System.out.println("10. refresh the page and verify the expected title [automationbykrishna]");
		Thread.sleep(2000);
		driver.navigate().refresh();
		title = driver.getTitle();
		expectedTitle = "Login Signup Demo";
		if (title.equals(expectedTitle))
			System.out.println("After refereshing the page to automationbykrishna title is equal");
		else
			System.out.println("Test failed");

		System.out.println("11. Close the browser.");
		Thread.sleep(2000);
		driver.close();

	}

}
