package sandesh.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseLaunch {
	
	public static WebDriver launchWebPage(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\TechnoCredit\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get(url);
		return wd;
	}
}
