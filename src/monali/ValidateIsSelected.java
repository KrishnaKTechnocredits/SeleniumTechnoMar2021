package monali;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateIsSelected {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		boolean status =driver.findElement(By.className("label_radio col-lg-6 col-sm-6")).isSelected();
		System.out.println(status);
	}

}
