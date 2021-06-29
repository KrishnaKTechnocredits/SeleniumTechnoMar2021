package priyanka_Panat.TestCases1_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
		driver.get(url);
		String currentUrl = driver.getCurrentUrl();
		if (url.equals(currentUrl)) {
			System.out.println("The correct url is opened");
		} else {
			System.out.println("Incorrect url");
		}
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println("Tile of page is : " + title + " and length of title is : " + title.length());
		String pagesource = driver.getPageSource();
		System.out.println("Length of pagesource is : " + pagesource.length());
		driver.close();

	}
}
