package krati_Shukla.Selenium;

import org.openqa.selenium.WebDriver;

import krati_Shukla.Selenium.base.SetURL;

public class Test2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = SetURL.set("http://google.com/"); //Opening Google in chrome
		
		System.out.println("Navigating fowrward to AutomationByKrishna");
		driver.navigate().to("http://automationbykrishna.com/");//navigate to automationbykrishna.com
		
		System.out.println("Navigating back to Google");
		driver.navigate().back();
		String title = driver.getTitle();
		if(title.equals("Google")) //Get page title name and verify with expected title [google]
			System.out.println("Page is as expected");
		else System.out.println("This is incorrect page");
		
		System.out.println("Navigating fowrward to AutomationByKrishna");
		driver.navigate().to("http://automationbykrishna.com/");//navigate to automationbykrishna.com
		String title1 = driver.getTitle();
		if(title1.equals("Login Signup Demo")) //Get page title name and verify with expected title [google]
			System.out.println("Page is as expected");
		else System.out.println("This is incorrect page");
		
		driver.navigate().refresh(); //refresh the page and verify the expected title
		String title2 = driver.getTitle();
		if(title2.equals("Login Signup Demo")) //Get page title name and verify with expected title [google]
			System.out.println("Page is as expected");
		else System.out.println("This is incorrect page");
		
		driver.close();
	}

}
