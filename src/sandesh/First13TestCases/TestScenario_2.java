/*Test Scenario- 2
1. Launch chrome
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

package sandesh.First13TestCases;

import org.openqa.selenium.WebDriver;
import sandesh.base.BaseLaunch;

public class TestScenario_2 {

	public static void main(String[] args) {
		WebDriver driver = BaseLaunch.launchWebPage("https://google.com");
		String expectedTitleGoogle = "Google";
		String expectedTitleKrishna = "Login Signup Demo";

		System.out.println("STEP 1 - Verify Google page title");
		String actualTitleGoogle = driver.getTitle();
		if (actualTitleGoogle.equals(expectedTitleGoogle)) {
			System.out.println("Google title Test Passed");
		} else
			System.out.println("Google title Test Failed");

		System.out.println("STEP 2 - Navigate to automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com");

		System.out.println("STEP 3 - Verify ABK page title");
		String actualTitleKrishna = driver.getTitle();
		System.out.println(actualTitleKrishna);
		if (actualTitleKrishna.equals(expectedTitleKrishna)) {
			System.out.println("Krishna title Test Passed");
		} else
			System.out.println("Krishna title Test Failed");

		System.out.println("STEP 4 - Navigate Back in History");
		driver.navigate().back();
		actualTitleGoogle = driver.getTitle();
		if (actualTitleGoogle.equals(expectedTitleGoogle)) {
			System.out.println("Google title Test Passed");
		} else
			System.out.println("Google title Test Failed");

		System.out.println("STEP 5 - Verify ABK page title");
		driver.navigate().forward();
		actualTitleKrishna = driver.getTitle();
		if (actualTitleKrishna.equals(expectedTitleKrishna)) {
			System.out.println("Krishna title Test Passed");
		} else
			System.out.println("Krishna title Test Failed");

		System.out.println("STEP 6 - Refresh ABK page title");
		actualTitleKrishna = driver.getTitle();
		if (actualTitleKrishna.equals(expectedTitleKrishna)) {
			System.out.println("Krishna title Test Passed");
		} else
			System.out.println("Krishna title Test Failed");

		System.out.println("STEP 7 - Close the browser");
		driver.close();
	}
}
