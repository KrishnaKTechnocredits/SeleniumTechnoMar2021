package shilpa.Assignment_1_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class LaunchBrowser {
	public WebDriver start(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Open "+url);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
