package amrutaM.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	static WebDriver driver;
	public static WebDriver setUp() {
		
		return setUp("http://automationbykrishna.com/");
	}
	public static WebDriver setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
	}
	
}
