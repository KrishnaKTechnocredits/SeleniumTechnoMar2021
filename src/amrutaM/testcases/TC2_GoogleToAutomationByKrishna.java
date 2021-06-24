package amrutaM.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 2
1. Open the chrome browser
2. Go to Google.com
3. Get page title name and verify with expected title.
4. Navigate to AutomationByKrishna'
5. Get page title name and verify with expected title.
6. Navigate back  in history.
7. Get page title name and verify with expected title.
8. Navigate forward in the history
9. Get page title name and verify with expected title.
10. Refresh the page and verify the expected title.
11. Close the browser*/


public class TC2_GoogleToAutomationByKrishna {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		String googleUrl = "https://www.google.com/";
		String automationByKrishnaUrl = "http://automationbykrishna.com";
		String expectedGoogleTitle = "Google";
		String expectedKrishnaTitle = "Login Signup Demo";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(googleUrl);
		String actualGoogleTitle = driver.getTitle();
		if(actualGoogleTitle.equals(expectedGoogleTitle)) {
			System.out.println("Google - Titles matched!!!");
		}else {
			System.out.println("Google - incorrect page title!!");
		}
		
		driver.navigate().to(automationByKrishnaUrl);
		//Thread.sleep(5000);
		String actualKrishnaTitle = driver.getTitle();
		if(actualKrishnaTitle.equals(expectedKrishnaTitle)) {
			System.out.println("Automation By Krishna - Titles matched!!!");
		}else {
			System.out.println("Automation By Krishna - incorrect page title!!");
		}
		
		driver.navigate().back();
		String titlePostNavigatingback = driver.getTitle();
		if(titlePostNavigatingback.equals(expectedGoogleTitle)) {
			System.out.println("Google - Titles matched!!!");
		}else {
			System.out.println("Google - incorrect page title!!");
		}
		
		driver.navigate().forward();
		String pageTitlePostNavigatingFwd = driver.getTitle();
		if(pageTitlePostNavigatingFwd.equals(expectedKrishnaTitle)) {
			System.out.println("Automation By Krishna - Titles matched!!!");
		}else {
			System.out.println("Automation By Krishna - incorrect page title!!");
		}
		
		driver.navigate().refresh();
		driver.getTitle().equals(actualKrishnaTitle);
		driver.close();
	}
}
