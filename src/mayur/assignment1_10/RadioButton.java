package mayur.assignment1_10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	private static void clickOnRadioButtonAndSelect(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		if (driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected()) {
			driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		}
		if (driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected())
			System.out.println("Female Selected : PASS ");
		else
			System.out.println("Female not selected : FAIL");
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();
		clickOnRadioButtonAndSelect(driver);
	}
}
