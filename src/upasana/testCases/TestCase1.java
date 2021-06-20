package upasana.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import base.PredefinedActions;

public class TestCase1 {
	public static void main(String[] args) {
		
		

		WebDriver driver = PredefinedActions.start();

		String title = driver.getTitle();

		System.out.println(title + " " + title.length());

		String currentUrl = driver.getCurrentUrl();
		String url = "http://automationbykrishna.com/";
		System.out.println(currentUrl);

		if (url.equals(currentUrl)) {
			System.out.println("same");
		} else
			System.out.println("different");
		String source = driver.getPageSource();
		System.out.println(source.length());
		driver.quit();
	}

}
