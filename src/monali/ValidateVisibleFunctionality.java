package monali;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateVisibleFunctionality {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/hp/Downloads/Krishna%20Requirement.html");
		driver.findElement(By.id("visibleAndHidden")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).isDisplayed();
		System.out.println(status);
	}
}
