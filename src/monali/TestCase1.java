package monali;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url1 = "https://www.google.com/";
		driver.get(url1);
		String currentUrl = driver.getCurrentUrl();
		if(url1.equals(currentUrl)) {
			System.out.println("correct url is opened");
		}else {
			System.out.println("url is not same");
		}
		
		String pageTitle = driver.getTitle();
		System.out.println("current page title is "+pageTitle);
		System.out.println("current page title length is "+pageTitle.length());
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.length());
		
		driver.manage().window().maximize();
		
		driver.close();
	
	}
}

 
