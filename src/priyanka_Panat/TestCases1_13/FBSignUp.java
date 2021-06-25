package priyanka_Panat.TestCases1_13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {
	static WebDriver driver;

	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		return driver;
	}

	static void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	public static void main(String[] args) {
		start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Step 1: Click on Sign up button");
		driver.findElement(By.xpath("//a[@role='button'] [@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"))
				.click();
		System.out.println("Strp 2: Enter Firstname");
		driver.findElement(By.xpath("//input [@name='firstname']")).sendKeys("Priyanka");

		System.out.println("Strp 3: Enter Lastname");
		driver.findElement(By.xpath("//input [@name='lastname']")).sendKeys("Panat");

		System.out.println("Strp 4: Enetr email ID or Mobile no");
		driver.findElement(By.xpath("//input [@name='reg_email__']")).sendKeys("priyankapanat30@gmail.com");

		System.out.println("Strp 5: Write Password");
		driver.findElement(By.xpath("//input [@name='reg_passwd__']")).sendKeys("priya123");

		System.out.println("Strp 6: Select birth date");
		WebElement element = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birthDateDropdown = new Select(element);
		birthDateDropdown.selectByValue("30");

		System.out.println("Strp 7: Select birth month");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select birthMonthDropdown = new Select(birthMonth);
		birthMonthDropdown.selectByValue("6");

		System.out.println("Strp 8: Select birth year");
		WebElement birthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select birthYearDropdown = new Select(birthYear);
		birthYearDropdown.selectByValue("1996");

		System.out.println("Strp 9: Select Gender");
		driver.findElement(By.xpath("//input[@value='1']")).click();

		System.out.println("Strp 12: Close browser");
		tearDown();
	}
}
