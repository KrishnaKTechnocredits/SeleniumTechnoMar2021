package shivani.Assignment_1_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*1. Launch a chrome
2. Open Google.com
3. Get page title name and verify with expected title
4. navigate to automationbykrishna.com
5. Get page title name and verify with expected title
6. navigate back in history
7. Get page title name and verify with expected title [google]
8. navigate forward in the history
9. Get page title name and verify with expected title [automationbykrishna]
10. refresh the page and verify the expected title [automationbykrishna]
11. Close the browser.*/
public class SeleniumTest2 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrom.driver","./resources/chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://www.google.com/");
	    driver.manage().window().maximize();
	    String firstPage=driver.getTitle();
	    driver.navigate().to("http://automationbykrishna.com/");
	   String pageTitle= driver.getTitle();
	   System.out.println("pageTitle"+pageTitle);
	   String expectedPageTitle ="Login Signup Demo";
	   if(pageTitle.equals(expectedPageTitle)) {
		   System.out.println("Page title is correct");
	   }
	   else
	   {
		   System.out.println("Page title is not correct");
	   }
	   driver.navigate().back();
	   String title= driver.getTitle();
	   if(title.equals(firstPage)) {
		   System.out.println("titleMatch");
	   }
	driver.navigate().forward();
	driver.getTitle().equals(pageTitle);
	driver.navigate().refresh();
	System.out.println(driver.getTitle());
	driver.close();

}
}

