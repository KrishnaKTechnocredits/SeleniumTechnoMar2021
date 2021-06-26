package technocredits.basics;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	static HashMap<String,String> getMap() {
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("chrome.driver", "Vaibhav");
		return hm;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\TechnoCredits\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://naukri.com/";
		driver.get(url);
		String currentURL = driver.getCurrentUrl();
		if(url.equals(currentURL)) {
			System.out.println("The correct url is opened.");
		}else {
			System.out.println("URL is not same.");
		}
		String pageTitle = driver.getTitle();
		System.out.println("Current page title is: "+pageTitle);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.contains(""));
		
		driver.close(); // current browser
		//driver.quit();
		System.out.println(driver.getTitle());
	}
}
