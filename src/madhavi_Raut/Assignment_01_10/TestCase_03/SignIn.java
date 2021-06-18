package madhavi_Raut.Assignment_01_10.TestCase_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test - 3
TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.*/
public class SignIn {

	void signIn() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(3000);
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
		if (alert.getText().equals("Success")) {
			System.out.println("Registration successful");
		} else
			System.out.println("Registration Failed");
		alert.accept();
		System.out.println("STEP - Closing browser");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new SignIn().signIn();
	}
}
