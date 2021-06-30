package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle_TestCase1 {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("1. Launch chrome");
		String url = "https://www.google.com/";
		System.out.println("2. Open Google.com");
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("3. Get page title name and length and print on console");
		System.out.println(driver.getTitle()+" & its length - "+driver.getTitle().length());
		System.out.println("4. Get page URL and verify if it is a correct or not.");
		String currentUrl = driver.getCurrentUrl();
		if(url.equals(currentUrl))
			System.out.println("URL is correct");
		else
			System.out.println("URL is incorrect");
		Thread.sleep(2000);
		System.out.println("5. Get page source and page source length and print on console");
		String source = driver.getPageSource();
		System.out.println(source);
		System.out.println(source.length());
		System.out.println("6. Close the browser.");
		driver.close();		
	}
}
