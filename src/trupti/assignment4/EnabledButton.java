package trupti.assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledButton {

	public static void main(String[] args) {
		System.out.println("Step 1-Launch a chrome");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Step 2-Requirement.html");
		driver.get("file:///C:/Users/anima/Downloads/Krishna%20Requirement.html");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Enable button functionality");
		boolean status=driver.findElement(By.xpath("//button[@id='enableAndDisable']")).isEnabled();
		if (status) {
			System.out.println("Button is enable");
		}
		else {
			System.out.println("Button is disable");
		}
		
		driver.close();

	}

}
