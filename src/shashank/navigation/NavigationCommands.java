package shashank.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\New folder\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String str1="https://www.google.com/", str2="http://automationbykrishna.com/";
		driver.get("https://www.google.com/");
		String currentURL = driver.getCurrentUrl();
		if (str1.equals(currentURL))
			System.out.println("URL is matched");
		driver.navigate().to("http://automationbykrishna.com/");
		String nextURL = driver.getCurrentUrl();
		if (str2.equals(nextURL))
			System.out.println("URL is matched");
		driver.navigate().back();
		if (str1.equals(currentURL))
			System.out.println("URL is matched");
		driver.navigate().forward();
		if (str2.equals(nextURL))
			System.out.println("URL is matched");
		driver.navigate().refresh();
		if (str2.equals(nextURL))
			System.out.println("URL is matched");
		driver.close();
	}

}
