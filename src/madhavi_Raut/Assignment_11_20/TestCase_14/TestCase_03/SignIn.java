package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Test - 3
TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.*/
public class SignIn {
	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	@Test
	void signIn() {
		driver.findElement(By.id("registration2")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='unameSignin']"))));
		
		driver.findElement(By.id("fullName")).sendKeys("Madhavi Raut");
		driver.findElement(By.id("address")).sendKeys("Florence Street");
		driver.findElement(By.id("useremail")).sendKeys("test@test.com");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.id("organization")).sendKeys("Google");
		driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("madhaviraut");
		driver.findElement(By.id("passwordReg")).sendKeys("Password@1");
		driver.findElement(By.id("repasswordReg")).sendKeys("Password@1");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();
		System.out.println("STEP - Verifying Alert");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Success", "Registration Failed");
		alert.accept();
	}
}
