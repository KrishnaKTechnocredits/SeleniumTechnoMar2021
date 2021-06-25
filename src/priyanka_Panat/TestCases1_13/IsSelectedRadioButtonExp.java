package priyanka_Panat.TestCases1_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsSelectedRadioButtonExp {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("unameSignin"))));
		if (driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected()) {
			if (!driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected())
				driver.findElement(By.xpath("//input[@id='radio-02']")).click();
			System.out.println("Female radio button is selected");
		} else
			System.out.println(" Male radio button is not selected");
		driver.close();
	}
}