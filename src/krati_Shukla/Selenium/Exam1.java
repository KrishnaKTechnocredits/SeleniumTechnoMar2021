package krati_Shukla.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		//Get page title name and length and print on console
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title+" & Length is :"+title.length());
		//Get page URL and verify if it is a correct or not.
		String newURL = driver.getCurrentUrl(); //capturing current URL
		System.out.println(newURL);
		if (url.equals(newURL))
			System.out.println("This is correct URL :"+newURL);
		else
			System.out.println("URL is incorrect");
		//Get page source and page source length and print on console
		String source = driver.getPageSource();
		System.out.println("Source of the page is :"+source+" & Length is :"+source.length());
		driver.close();
	}

}

