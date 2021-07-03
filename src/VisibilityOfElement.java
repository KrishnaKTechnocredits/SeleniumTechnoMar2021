import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisibilityOfElement {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("unameSignin")).isDisplayed());
		driver.findElement(By.id("unameSignin")).sendKeys("Madhavi");
	}

}
