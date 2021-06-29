/*
Test case - 1

1. Launch a chrome ---- done
2. Open Google.com ---- done
3. Get page title name and length and print on console ---- done
4. Get page URL and verify if it is a correct or not. ---- done
5. Get page source and page source length and print on console ----done
6. Close the browser.--- done
 */
package sourabh.testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String url= "https://www.google.co.in/";
		driver.get(url);
		String currentUrl= driver.getCurrentUrl();
		if(url.equals(currentUrl))
			System.out.println("Url matched !!");
		else
			System.out.println("Url not matched !!");
		String currentPageTitle= driver.getTitle();	
			System.out.println("Current Page Title is :"+currentPageTitle);
			System.out.println("Current Page length is :"+currentPageTitle.length());
		String pageSource= driver.getPageSource();
			System.out.println("PageSource length is :"+pageSource.length());
		driver.close();	
	}
}

