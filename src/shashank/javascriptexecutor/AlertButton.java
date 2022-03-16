package shashank.javascriptexecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]"));
		// je.executeScript("arguments[0].scrollIntoView(true);","element");
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText().contentEquals("You must be TechnoCredits student!!"));

		alert.accept();
		driver.close();

	}

}
