package pallavi.assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(300);
		WebElement element = driver.findElement(By.id("exampleInputEmail2"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		Alert alert = driver.switchTo().alert();
		String name = "Pallavi";
		alert.sendKeys(name);
		alert.accept();

		String actualOkMsz = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(actualOkMsz);
		if (actualOkMsz.contains(name)) {
			System.out.println("Test Case passed");
		} else {
			System.out.println("failed!!!!!!1");
		}

	}

}
