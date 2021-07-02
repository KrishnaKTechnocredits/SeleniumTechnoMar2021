package monika;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonBrowser {
	
	public static WebDriver browserCmds(String url) {
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Enter URL
		driver.get(url);
		
		//Maximize the current window
		driver.manage().window().maximize();
		return driver;
	}

}
