package ankit.Test_1_10.Test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {


	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP -  Launch a chrome");
		System.out.println("STEP -  Open Google.com");
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		System.out.println("STEP -  Get page title name");
		String actualTitle =  driver.getTitle();
		String expectedTitle = "Google" ;
		System.out.println("VERIFY -  expected title");
		if(actualTitle.equals(expectedTitle)) 
			System.out.println("Title is correct - PASS");
		else 
			System.out.println("Title is Incorrect - FAIL");
	
		System.out.println("STEP -  navigate to automationbykrishna.com");
		driver.navigate().to("http://www.automationbykrishna.com");
		Thread.sleep(2000);
		System.out.println("STEP -  Get page title name ");
		String actualTitleAK = driver.getTitle();
		String expectedTitleAK = "Login Signup Demo";
		System.out.println("VERIFY -  Expected title");
		if(actualTitleAK.equals(expectedTitleAK)) 
			System.out.println("AK Title is correct - PASS");
		else 
			System.out.println("AK Title is Incorrect - FAIL");

		Thread.sleep(2000);
		System.out.println("STEP -  navigate back in history");
		driver.navigate().back();

		System.out.println("STEP -  Get page title name and verify with expected title [google]");
		String actualBackTitle =  driver.getTitle();
		if(actualBackTitle.equals(expectedTitle)) 
			System.out.println("Back Title is correct - PASS");
		else 
			System.out.println("Back Title is Incorrect - FAIL");
		
		Thread.sleep(2000);
		System.out.println("STEP -  navigate forward in the history");
		driver.navigate().forward();

		System.out.println("STEP -  Get page title name and verify with expected title [automationbykrishna]");
		String actualfwdTitleAK =  driver.getTitle();
		if(actualfwdTitleAK.equals(expectedTitleAK)) 
			System.out.println("Forward AK Title is correct - PASS");
		else 
			System.out.println("Forward AK Title is Incorrect - FAIL");
		
		Thread.sleep(2000);
		System.out.println("STEP -  refresh the page and verify the expected title [automationbykrishna]");
		driver.navigate().refresh();

		System.out.println("STEP -  Close the browser.");
		driver.close();


	}
}
