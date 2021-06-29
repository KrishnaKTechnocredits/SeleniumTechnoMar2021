package surabhi.facebookSignup;
/*
 * Facebook new account create and input each details
 * 
 * */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {
	WebDriver driver;
	
	static void selectDatePicker(WebElement element, String str) {
		Select select=new Select(element);
		select.selectByValue(str);
		
	}
	
	@Test
	void runScriptForSignUpFacebook() {

		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement element=driver.findElement(By.linkText("English (UK)"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		//click on create account : 
		element.click();
		driver.findElement(By.linkText("Create New Account")).click();
		
		//input user name/email/password details
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Surabhi");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Atal");
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("rathisurabhi45@gmail.com");
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']"))).sendKeys("rathisurabhi45@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("sur@123");
		
		System.out.println("Select BirthDate from date picker");
		//select birthdate from selenium		
		String date="9", day="4", year="1993";
		
		selectDatePicker(driver.findElement(By.xpath("//select[@id='day'][@title='Day']")), date);
		
		selectDatePicker(driver.findElement(By.xpath("//select[@id='month'][@title='Month']")), day);
		
		selectDatePicker(driver.findElement(By.xpath("//select[@id='year'][@title='Year']")), year);
		
		//click on gender
		driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		
	}
	
	@BeforeMethod
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Step: launching browser");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
