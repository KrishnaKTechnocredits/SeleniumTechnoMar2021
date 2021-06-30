package surabhi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://www.google.com/";
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		String title=driver.getTitle();
		System.out.println("page title is "+title+" and length is "+title.length());
		
		if(url.equals(driver.getCurrentUrl())) {
			System.out.println("Correct URL is opened");
		}else {
			System.out.println("Wrong Url got opened");
		}
		
		String source=driver.getPageSource();
		System.out.println(source.length());
		driver.close();
	}

}
