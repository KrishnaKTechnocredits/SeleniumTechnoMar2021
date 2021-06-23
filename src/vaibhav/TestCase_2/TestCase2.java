/*Test case - 2 [6th June 2021]

1. Launch a chrome
2. Open Google.com
3. Get page title name and verify with expected title
4. navigate to automationbykrishna.com
5. Get page title name and verify with expected title
6. navigate back in history
7. Get page title name and verify with expected title [google]
8. navigate forward in the history
9. Get page title name and verify with expected title [automationbykrishna]
10. refresh the page and verify the expected title [automationbykrishna]
11. Close the browser.

*/

package vaibhav.TestCase_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) {

		System.out.println("Step 1 : Launch a chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		System.out.println("Step 2 : Open Google.com");
		String targetedURL_1 = "https://www.google.com/";
		driver.get(targetedURL_1);

		
		System.out.println("Step 3 : Get page title name and verify with expected title");
		String currentTitle1 = driver.getTitle();
		String expectedTitle1 = "Google";
		System.out.println("Current page title is : " + currentTitle1);
		if (currentTitle1.equals(expectedTitle1))
			System.out.println("Test Pass : Current Title is same as expected Title");
		else
			System.out.println("Test fail : Current Title is differnt than expected Title");
		
		
		
		System.out.println("Step 4 : Navigate to automationbykrishna.com");
		String targetedURL_2 = "http://automationbykrishna.com";
		driver.navigate().to(targetedURL_2);
		
		
		System.out.println("Step 5 : Get page title name and verify with expected title");
		String currentTitle2 = driver.getTitle();
		String expectedTitle2 = "Login Signup Demo";
		if (currentTitle2.equals(expectedTitle2))
			System.out.println("Test Pass : Current Title is same as expected Title");
		else
			System.out.println("Test fail : Current Title is differnt than expected Title");
		
		
		System.out.println("Step 6 : Navigate back in history");
		driver.navigate().back();
		
		
		System.out.println("Step 7 : Get page title name and verify with expected title [google]");
		if (driver.getTitle().equals(expectedTitle1))
			System.out.println("Test Pass : Current Title is same as expected Title");
		else
			System.out.println("Test fail : Current Title is differnt than expected Title");
		
		
		System.out.println("Step 8 : Navigate forward in the history");
		driver.navigate().forward();
				
		
		System.out.println("Step 9 : Get page title name and verify with expected title [automationbykrishna]");
		if (driver.getTitle().equals(expectedTitle2))
			System.out.println("Test Pass : Current Title is same as expected Title");
		else
			System.out.println("Test fail : Current Title is differnt than expected Title");
		
		
		System.out.println("Step 10 : Refresh the page and verify the expected title [automationbykrishna]");
		driver.navigate().refresh();
		if (driver.getTitle().equals(expectedTitle2))
			System.out.println("Test Pass : Current Title is same as expected Title");
		else
			System.out.println("Test fail : Current Title is differnt than expected Title");
		
		
		System.out.println("Step 11 : Close Browser");
		driver.close();

	}

}
