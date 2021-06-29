package trupti.assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isSelectedRadioBtn {

	public static void main(String[] args) {
		System.out.println("Step 1-Launch a chrome");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step 2-Open Google.com");
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Step 4-Navigate to automationbykrishna.com ");
		driver.navigate().to("http://automationbykrishna.com/");
		System.out.println("Click on Registration Link");
		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement element= driver.findElement(By.xpath("//input[@id='radio-01']"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		boolean status=element.isSelected();
		if(status) {
			driver.findElement(By.xpath("//input[@id='radio-02']")).click();
			System.out.println("Female selected");
		}
		driver.close();

	}

}
