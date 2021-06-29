package kajal.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	public static WebDriver start(String url) {
		System.out.println("STEP 1 -Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("SETP 2 open given url");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		}
	
	public static WebDriver start() {
		return start("http://automationbykrishna.com/");
		 
		}
	
}
