package monali;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateEnableButtonFunctionality {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.cgrome.driver", "chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/hp/Downloads/Krishna%20Requirement.html");
		driver.findElement(By.id("enableAndDisable")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//button[@id='enableAndDisable']")).isEnabled();
		System.out.println(status);
	}
}
