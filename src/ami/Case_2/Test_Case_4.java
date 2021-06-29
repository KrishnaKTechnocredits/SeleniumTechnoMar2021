package ami.Case_2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url ="http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("Click on basic Element ");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
			String okClickText = "You pressed OK!";
			String cancelClickText = "You pressed Cancel!";
			WebElement element = driver.findElement(By.id("javascriptConfirmBox"));
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			element.click();
			
			Alert alert3 = driver.switchTo().alert();
			alert3.accept();
			WebElement okText = driver.findElement(By.id("pgraphdemo"));
			String okActualText = okText.getText();
			if(okActualText.equals(okActualText)) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}
			driver.findElement(By.id("javascriptConfirmBox")).click();
			Alert alert4 = driver.switchTo().alert();
			alert4.dismiss();
			WebElement cancelText = driver.findElement(By.id("pgraphdemo"));
			String cancelActualText = cancelText.getText();
			if(cancelActualText.equals(cancelClickText)) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}
		}

}
