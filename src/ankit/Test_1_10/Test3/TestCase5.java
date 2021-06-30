package ankit.Test_1_10.Test3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP - Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		System.out.println("STEP - Send Text from Alert");
		Alert alert = driver.switchTo().alert();
		String sentToAlert = "Ankit";
		alert.sendKeys(sentToAlert);
		
		System.out.println("STEP - Close or Accept Alert");
		alert.accept();
	
		System.out.println("VERIFY - Label text");
		if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().contains(sentToAlert))
			System.out.println("Label Text is correct - PASS");
		else 
			System.out.println("Label Text is Incorrect - FAIL");
		
		System.out.println("STEP - Close Browser ");
		driver.close();
	}
}
