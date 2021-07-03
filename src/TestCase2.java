import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1. Launch a chrome
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

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		String expectedPage1URL="https://www.google.com/";
		String expectedPage2URL="http://automationbykrishna.com/";
		String expectedPage1Title="Google";
		String expectedPage2Title="Login Signup Demo";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(expectedPage1URL);
		if (validateURL(expectedPage1URL, driver.getCurrentUrl())) {
			if (validatePageTitle(expectedPage1Title, driver.getTitle())) {
				driver.navigate().to(expectedPage2URL);
				if (validatePageTitle(expectedPage2Title, driver.getTitle())) {
					Thread.sleep(2000);
					driver.navigate().back();
					if (validatePageTitle(expectedPage1Title, driver.getTitle())) {	
						Thread.sleep(2000);
						driver.navigate().forward();
						if (validatePageTitle(expectedPage2Title, driver.getTitle())) {
							driver.navigate().refresh();
							if (validatePageTitle(expectedPage2Title, driver.getTitle())) {
								System.out.println(driver.getTitle());
							}
						}
					}
				}
			}
		}
		driver.close();
	}

	static boolean validateURL(String expectedURL, String currentURL) {
		boolean isCurrentUrl = false;
		if (expectedURL.equals(currentURL)) {
			isCurrentUrl = true;
		}
		return isCurrentUrl;
	}

	static boolean validatePageTitle(String expectedTitle, String currentPageTitle) {
		boolean isCurrentTitle = false;
		if (expectedTitle.equals(currentPageTitle)) {
			isCurrentTitle = true;
		}
		return isCurrentTitle;
	}

}
