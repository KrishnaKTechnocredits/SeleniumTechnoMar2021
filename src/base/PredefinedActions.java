package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	private static WebDriver driver;
	public static WebDriver start() {
		return start("http://automationbykrishna.com");
	}
	
	public static WebDriver start(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP - Open given url");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
	}
}
