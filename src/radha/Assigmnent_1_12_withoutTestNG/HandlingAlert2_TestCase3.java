package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert2_TestCase3 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.xpath("//input[@id='exampleInputEmail1']"));
		email.sendKeys("rSaoji@gmail.com");
		String emailID = email.getAttribute("value");
		WebElement pswrd = driver.findElement(By.xpath("//input[@id='pwd']"));
		pswrd.sendKeys("radhaS123");
		String password = pswrd.getAttribute("value");
		driver.findElement(By.xpath("//*[@id='submitb2']")).click();
		Alert al = driver.switchTo().alert();
		String alertActual = al.getText();
		System.out.println("Alert popup displays Text: " + alertActual);
		String expectedAlert = "You successfully clicked on it";
		if(expectedAlert.equals(alertActual))
				System.out.println("Alert msg is expected.");
		else
			System.out.println("Incorrect alert displayed. Correct alert text should be " + expectedAlert);
		al.accept();
		System.out.println("close browser");
		driver.close();
	}
}
