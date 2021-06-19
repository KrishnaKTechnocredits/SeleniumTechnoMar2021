package pallavi.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Predefined {
	
	public static WebDriver setUp() {
		return setUp("http://automationbykrishna.com/");
	}
	

	static public WebDriver setUp(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}
}
