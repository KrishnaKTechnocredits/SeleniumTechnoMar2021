package upasana.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class TestCase2 {
	public static void main(String[] args) {

		String titleExpectedG = "Google";
		String titleExpectedK = "Login Signup Demo";

		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");

		System.out.println("Step 1: Launch a chrome");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step 2: Open Google.com");
		driver.get("https://google.com/");

		System.out.println("Step 3: Get page title name and verify with expected title");
		String titleActualG = driver.getTitle();
		if (titleExpectedG.equals(titleActualG)) {
			System.out.println("title : " + titleActualG + " is same");
		} else
			System.out.println("different");

		System.out.println("Step 4: navigate to \"http://automationbykrishna.com\"");
		driver.navigate().to("http://automationbykrishna.com");

		System.out.println("Step 5: Get page title name and verify with expected title");
		String titleActualK = driver.getTitle();
		if (titleExpectedK.equals(titleActualK)) {
			System.out.println("title : " + titleActualK + " is same");
		} else
			System.out.println("different");
		
		System.out.println("Step 6: navigate back in history");
		driver.navigate().back();
		
		System.out.println("Step 7: Get page title name and verify with expected title [google]");
		String titleActualG1 = driver.getTitle();
		if (titleExpectedG.equals(titleActualG1)) {
			System.out.println("title : " + titleActualG1 + " is same");
		} else
			System.out.println("different");
		
		System.out.println("Step 8: navigate forward in the history");
		driver.navigate().forward();
		
		System.out.println("Step 9: Get page title name and verify with expected title [automationbykrishna]");
		String titleActualK1 = driver.getTitle();
		if (titleExpectedK.equals(titleActualK1)) {
			System.out.println("title : " + titleActualK1 + " is same");
		} else
			System.out.println("different");
		
		System.out.println("Step 10: refresh the page and verify the expected title [automationbykrishna]");
		driver.navigate().refresh();
		String titleActualK2 = driver.getTitle();
		if (titleExpectedK.equals(titleActualK2)) {
			System.out.println("title : " + titleActualK2 + " is same");
		} else
			System.out.println("different");
		
		System.out.println("Step 11: Close the browser.");
		driver.quit();

	}

}
