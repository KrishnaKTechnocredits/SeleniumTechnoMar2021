package krati_Shukla.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		signUp(driver);
		driver.close();
	}
	
	
		static void signUp(WebDriver driver) throws InterruptedException {
			//Clicking on 'Create New Account'
			
			driver.findElement(By.xpath("//a[@role='button'][@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'][@ajaxify='/reg/spotlight/']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			//Filling up First details
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Krati");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Chaturvedi");
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9167255878");
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Krati");
			//selecting selectors
			
			WebElement dayElement = driver.findElement(By.xpath("//select[@name='birthday_day']"));//select Birth Date
			Select bdayDropDown = new Select(dayElement);
			bdayDropDown.selectByValue("12");
			
			WebElement monthElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));//select Birth month
			Select monthDropDown = new Select(monthElement);
			monthDropDown.selectByValue("6");
			
			WebElement yearElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));//select Birth Year
			Select yearDropDown = new Select(yearElement);
			yearDropDown.selectByValue("1989");
			
			//Selecting gender
			WebElement fGender = driver.findElement(By.xpath("//input[@id='u_6_2_Uw']"));
			fGender.click();
		}

}
