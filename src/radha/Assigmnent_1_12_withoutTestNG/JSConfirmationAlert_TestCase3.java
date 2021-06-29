package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSConfirmationAlert_TestCase3 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert al = driver.switchTo().alert();
		al.dismiss();
		String actualMsg = driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		String expected  = "You pressed OK!";
		if(expected.equals(actualMsg))
			System.out.println("Alert msg is as expected.");
		else
			System.out.println("Alert msg is incorrect. Should be "+expected);
		System.out.println("Close Browser");
		driver.close();
	}
}
