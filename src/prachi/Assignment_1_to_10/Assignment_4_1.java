package prachi.Assignment_1_to_10;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4_1 {

	public static void main(String[] args) throws InterruptedException{

		System.out.println("STEP - Open Facebook");
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='https://en-gb.facebook.com/']")).click();
		Thread.sleep(2000);

		System.out.println("STEP - Click on Create Account button"); 
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		Thread.sleep(2000);
		System.out.println("STEP - Enter FirstName "); 
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Prachi");

		System.out.println("STEP - Enter LastName");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lonkar");

		System.out.println("STEP - Enter Mobile Number"); 
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9999999999");

		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("prachi@123");

		System.out.println("STEP - Select DOB ");
		Select dayDD = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		dayDD.selectByValue("14");

		System.out.println("STEP - Select Month");
		Select monthDD = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		monthDD.selectByVisibleText("Aug");

		System.out.println("STEP - Select birth year");
		Select yearDD = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		yearDD.selectByValue("1991");

		System.out.println("STEP - Select Gender as Female");
		driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).click();;

		int size = driver.findElements(By.xpath("//input[@name='sex']")).size();
		System.out.println("Radio Button count is :"+size);

		driver.close();
	}
}