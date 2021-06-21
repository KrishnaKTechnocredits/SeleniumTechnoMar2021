package rupali;
/*
 * Test Case 2

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class TestCase2{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String expectedtitle="Login Signup Demo";
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		String str=driver.getTitle();
		if(expectedtitle.equals(str))
			System.out.println("Title is matched"+str);
		else
			System.out.println("wrong title");
		
		
		
		driver.navigate().to("http://www.automationbykrishna.com");
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login Signup Demo";
		System.out.println("VERIFY -  Expected title");
		if(actualTitle.equals(expectedTitle)) 
			System.out.println("Title is correct - PASS");
		else 
			System.out.println("Title is Incorrect - FAIL");

		Thread.sleep(2000);
		driver.navigate().back();
		String actualBackTitle =  driver.getTitle();
		if(actualBackTitle.equals(expectedtitle)) 
			System.out.println("Back Title is correct - PASS");
		else 
			System.out.println("Back Title is Incorrect - FAIL");

		Thread.sleep(2000);
		driver.navigate().forward();
		String actualfwdTitle =  driver.getTitle();
		if(actualfwdTitle.equals(expectedTitle)) 
			System.out.println("Forward  Title is correct - PASS");
		else 
			System.out.println("Forward  Title is Incorrect - FAIL");

		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.close();

		
	}

}
