package ankit.AM_base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedMethods {
	
	public static WebDriver launchBrowser(String URL) {
		System.setProperty("webdriver.chrome.driver", "F:\\New Beginning\\Eclipse Workspace\\SeleniumBasics\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);	
		driver.manage().window().maximize();
		return driver;
	}
	public static void main(String[] a) {
		launchBrowser("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
	}
}
