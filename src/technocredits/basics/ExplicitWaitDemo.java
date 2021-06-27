package technocredits.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class ExplicitWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("Registration")).click();
		
		//WebElement unameElement = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		WebDriverWait wait = new WebDriverWait(driver,-15);
		WebElement unameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin1']")));
		unameElement.sendKeys("mkanani");
		
		System.out.println(unameElement.getAttribute("value"));
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("mkanani123");
	}
}
