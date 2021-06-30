package prachi.Assignment_17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Predefined_Actions {
	public static WebDriver launchBrowser(String URL) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);	
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void main(String[] a) {
		Predefined_Actions pda=new Predefined_Actions();
		pda.launchBrowser("https://flipkart.com");
	}
}
