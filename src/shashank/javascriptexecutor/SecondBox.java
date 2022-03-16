package shashank.javascriptexecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		WebElement element=driver.findElement(By.id("submitb2"));
		JavascriptExecutor je =(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("sdshashank152@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("shank");
		je.executeScript("document.getElementById('submitb2').click()");
		Alert alert = driver.switchTo().alert();
		String str="You successfully clicked on it";
		String str1=alert.getText();
		if (str.equals(str1)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		alert.accept();
		driver.close();
		
	}

}
