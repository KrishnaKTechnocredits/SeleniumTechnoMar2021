package pallavi.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String titleName = driver.getTitle();
		System.out.println("Title is :" + titleName + "  length is :" + titleName.length());
		String CurrentURL = driver.getCurrentUrl();

		if (CurrentURL.equals("https://www.google.com/")) {
			System.out.println("This is correct URL");
		} else
			System.out.println("Incorrect URl");
		String sourcePage = driver.getPageSource();
		System.out.println("sourcePage length is :" + sourcePage.length());
		driver.close();
	}

}
