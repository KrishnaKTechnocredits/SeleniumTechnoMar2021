package shashank.testcase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium Class\\New folder\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String currentURL = driver.getCurrentUrl();
		if ("https://www.google.com/".equals(currentURL))
			System.out.println("URL is matched");
		System.out.println("Title is " + driver.getTitle());
		System.out.println("Page Source Length is:- " + driver.getPageSource().length());
		driver.close();
	}

}
