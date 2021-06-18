package madhavi_Raut.Assignment_01_10.TestCase_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"*/
public class LogIn {

	void logIn() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// Explicit Wait
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='unameSignin']"))))
				.sendKeys("madhaviraut");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Password@1");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("STEP - Verifying Alert");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Success!"))
			System.out.println("Login Successful");
		else
			System.out.println("Login Failed");
		alert.accept();
		System.out.println("STEP - Closing browser");
		driver.close();
	}

	public static void main(String[] args) {
		new LogIn().logIn();
	}
}
