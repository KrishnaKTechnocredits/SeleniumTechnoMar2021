package shashank.javascriptexecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.id("UserFirstName")).sendKeys("Shashank");
		driver.findElement(By.id("UserLastName")).sendKeys("Dharmadhikari");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Netcracker");
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][@onclick='myFunctionPopUp()']")).click();
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		String str1 = "Shashank and Dharmadhikari and Netcracker";
		boolean isPass = str.equals(str1);
		if (isPass)
			System.out.println("Passed");
		else
			System.out.println("Failed");
		alert.accept();
		driver.close();

	}

}
