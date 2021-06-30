package krati_Shukla.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import krati_Shukla.Selenium.base.SetURL;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SetURL.set("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		alertDemo(driver);
		Thread.sleep(3000);
		basicForm(driver);
		Thread.sleep(3000);
		driver.close();
	}

	static void alertDemo(WebDriver driver) throws InterruptedException {

		String fName = "Krati", lName = "Chaturvedi", company = "Deloitte";

		System.out.println("Clicking Basic Elements");
		System.out.println("-----------In Alert Demo Now--------------");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);

		System.out.println("Entering details");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Krati");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Chaturvedi");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Deloitte");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();

		String input = fName + " and " + lName + " and " + company;
		System.out.println("User entered " + input);

		if (input.equals(text))
			System.out.println("Alert text is same");
		else
			System.out.println("Alert text is different");
		alert.accept();

	}

	static void basicForm(WebDriver driver) throws InterruptedException {
		
		System.out.println("-----------In Basic Demo Now--------------");
		

		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("kratiC@gmail.com");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Deloitte");
		driver.findElement(By.xpath("//button[@id='submitb2'][@onclick='myFunction()']")).click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String input = "You successfully clicked on it";
		Thread.sleep(3000);

		if (input.equals(alertText))
			System.out.println("Alert text is same");
		else
			System.out.println("Alert text is different");
		alert.accept();
	}

}
