package trupti.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println("Title of the page "+title);
		int length=driver.getTitle().length();
		System.out.println("Length of the Title "+length);

		String actualUrl=driver.getCurrentUrl();
		if(actualUrl.equals("https://www.google.com/")) {
			System.out.println("Url matches with Actual url");
		}
		else {
			System.out.println("Url not matched");
		}
		driver.getPageSource();
		int srcLength=driver.getPageSource().length();
		System.out.println("Page Source length "+srcLength);
		driver.close();
	}

}


