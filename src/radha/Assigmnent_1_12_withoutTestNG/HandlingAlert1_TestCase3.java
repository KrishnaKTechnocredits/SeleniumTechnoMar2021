package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class HandlingAlert1_TestCase3 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch browser");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		WebElement element = driver.findElement(By.id("basicelements"));
		element.click();
		Thread.sleep(2000);
		WebElement fName = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		fName.sendKeys("Radha");
		String firstName = fName.getAttribute("value");
		WebElement lName = driver.findElement(By.xpath("//input[@id='UserLastName']"));
		lName.sendKeys("Saoji");
		String lastName = lName.getAttribute("value");
		WebElement comp = driver.findElement(By.xpath("//input[@id='UserCompanyName']"));
		comp.sendKeys("Atos-Syntel");
		String company = comp.getAttribute("value");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Alert alertPopup = driver.switchTo().alert();
		String alertMsg = alertPopup.getText();
		System.out.println("Alert message displayed is: "+alertMsg);
		String expectedAlert = firstName+" and "+lastName+" and "+company;
		if(expectedAlert.equals(alertMsg))
			System.out.println("Alert msg is as expected");
		else
			System.out.println("Alert text is incorrect. Correct text should be "+expectedAlert);
		alertPopup.accept();
		driver.close();
	}
}
