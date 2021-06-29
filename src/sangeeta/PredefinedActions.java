package sangeeta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	public static WebDriver start(String url) {
		System.out.println("Launch a WebBrowser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open a given URL");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver start() {
		return start("http://www.automationbykrishna.com");
	}
}