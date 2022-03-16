package shashank.javascriptexecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSPrompt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("javascriptPromp"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert alert = driver.switchTo().alert();
		String str = "Shashank";
		alert.sendKeys(str);
		alert.accept();
		String str1 = "Hello " + str + "! How are you today?";
		String str2 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (str1.equals(str2)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		driver.close();
	}

}
