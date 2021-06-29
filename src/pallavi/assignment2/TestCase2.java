package pallavi.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String expecteTitleOfFirstWin="Google";
		String expectedTitleOfSecondWin="Login Signup Demo";
		String getTitleOfFirstWin=driver.getTitle();
		if(expecteTitleOfFirstWin.equals(getTitleOfFirstWin)) {
			System.out.println(" 1st Expected title is correct");
		}else {
			System.out.println("1st Expected title is not correct");
		}
		driver.navigate().to("http://automationbykrishna.com/");
		String getTitleOfSecondWin=driver.getTitle();
		if(expectedTitleOfSecondWin.equals(getTitleOfSecondWin)) {
			System.out.println("2nd Title is corrent");
		}else {
			System.out.println("2nd title is not correct");
		}
		driver.navigate().back();
		String getnavigateTitle=driver.getTitle();
		if(getnavigateTitle.equals(expecteTitleOfFirstWin)) {
			System.out.println("1st window is coming");
		}else {
			System.out.println("It is not navigated back");
		}
		driver.navigate().forward();
		String getForwardTitle=driver.getTitle();
		if(getForwardTitle.equals(expectedTitleOfSecondWin)) {
			System.out.println("Forwaded AutomationBy Krishna Page is naviagted ");
		}
		else {
			System.out.println("Not naviagted forward correctly");
			
		}
		driver.navigate().refresh();
		String getRefreshTitle=driver.getTitle();
		if(getRefreshTitle.equals(expectedTitleOfSecondWin)) {
			System.out.println("Refreshed and AutomationByKrishna is coming");
		}
		else {
			System.out.println("Page not refreshed correctly");
		}
		driver.close();
	}


}
