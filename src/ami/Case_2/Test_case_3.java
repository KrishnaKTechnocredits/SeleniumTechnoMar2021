/*
 Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"
 */

package ami.Case_2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Argument;

public class Test_case_3 {
	
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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		System.out.println("click Alert button");
		//driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		WebElement element = driver.findElement(By.id("javascriptAlert"));
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		element.click();
		
		System.out.println("verify Message");
		String expectResult = "You must be TechnoCredits student!!";
		String actualResult = driver.switchTo().alert().getText();
		if(expectResult.equals(actualResult)) {
				System.out.println("Test pass");
				driver.switchTo().alert().accept();
				driver.close();
		}else {
			System.out.println("Test Fail");
		}
		
		
		
	}

}
