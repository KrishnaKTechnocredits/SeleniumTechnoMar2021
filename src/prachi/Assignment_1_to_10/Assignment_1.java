package prachi.Assignment_1_to_10;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*Test case - 1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/

public class Assignment_1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
	
		driver.get(url);
		String title = driver.getTitle();
		int titleLength = title.length();
		String URL = driver.getCurrentUrl();
		if(url.equals(URL)){
			System.out.println("URL is correct");
		}else{
			System.out.println("URL is wrong");
		}
		System.out.println("Title of the page is : "+title);
		System.out.println("Length of the title is : "+titleLength);
		System.out.println("URL of the page is : "+URL);
		
		//--------------------------------------------------//

		driver.navigate().to("http://automationbykrishna.com/");
		String navigate1 = driver.getTitle();
		if(URL!=navigate1) {
			System.out.println("Navigation is successful");
		}else{
			System.out.println("Navigation failed");
		}
		driver.close();
	}
}