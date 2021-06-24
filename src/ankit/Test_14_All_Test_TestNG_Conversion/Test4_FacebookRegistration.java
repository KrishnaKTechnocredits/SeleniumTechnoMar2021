package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test4_FacebookRegistration {
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("https://www.facebook.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	
		@Test
	public void verifyFacebookRegRadioButtonClick() throws InterruptedException {
		
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
	}

}
