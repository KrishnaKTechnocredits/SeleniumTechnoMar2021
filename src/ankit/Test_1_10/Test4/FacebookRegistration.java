package ankit.Test_1_10.Test4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("STEP -Navigate to facebook.com");
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='https://en-gb.facebook.com/']")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP -Click on Create Account "); 
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP -Enter First name "); 
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Techno");
		
		System.out.println("STEP -Enter Surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Credits");
		
		System.out.println("STEP -Enter Mobile Number or Email Address"); 
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");
		
		System.out.println("STEP -Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("abc1234");
	
		System.out.println("STEP -Select Date of Birth ");
		Select dayDD = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		dayDD.selectByValue("18");
		
		System.out.println("STEP -Select Month of Birth");
		Select monthDD = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		monthDD.selectByVisibleText("May");
		
		System.out.println("STEP -Select Year of Birth");
		Select yearDD = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		yearDD.selectByValue("1989");
		
		System.out.println("STEP -Select Gender as Male");
		driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).click();;

		int size = driver.findElements(By.xpath("//input[@name='sex']")).size();
		System.out.println("Radio Button group element counts :"+size);
		
		Thread.sleep(5000);
		driver.close();
	}

}
