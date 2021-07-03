package mayur.assignment1_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox"; 
		driver.get(url);
		String currentUrl = driver.getCurrentUrl();
		if(url.equals(currentUrl)) {
			System.out.println("Url opened is correct Url");
		}else {
			System.out.println("Invalid Url");
		}
		String pageTitle = driver.getTitle();
		System.out.println("Current page title is " +pageTitle);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.length());
	}
}

