package shivani.Assignment_1_10;


/*1. Launch a chrome

2.  Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.


.*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrom.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String title =driver.getTitle();
		int titleLength=title.length();
		System.out.println("Page title is"+title+"Title Length is "+titleLength);
		String url =driver.getCurrentUrl();
		String ExpectedUrl ="https://www.google.com/";
		String pageSouces=driver.getPageSource();
		int pageSourceLength =pageSouces.length();
		System.out.println("PgaeSource"+pageSouces+"/n"+"PageSourceLength"+pageSourceLength);
		if(url.equals(ExpectedUrl)) {
			System.out.println("Url is correct");
		}
		else {
			System.out.println("Url is not correct");
		}
		String expecedTitle="Google";
		if(title.equals(expecedTitle)) {
			System.out.println("title matched");
		}
		
		driver.close();
		
	}

}



