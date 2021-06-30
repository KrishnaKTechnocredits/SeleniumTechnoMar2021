package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlert_TestCase3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertButton);
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		String expectedAlert = "You must be TechnoCredits student!!";
		String actualAlert = alert.getText();
		System.out.println("Actual alert displayed is : "+actualAlert);
		if(expectedAlert.equals(actualAlert))
			System.out.println("Alert msg is as expected.");
		else
			System.out.println("Incorrect alert displayed. Correct alert text is "+expectedAlert);
		alert.accept();
		System.out.println("Close browser...!!!");
		driver.close();	
	}

}
