package radha.Assigmnent_1_12_withoutTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class FindLastNameAndUserName_TestCase10 {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String empName = "Krishna";
		String actualLastName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='"+empName+"']//following-sibling::td[1]")).getText();
		String actualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='"+empName+"']//following-sibling::td[2]")).getText();
		String expLName = "Kanani";
		String expUserName = "kkanani";
		if(expLName.equals(actualLastName) && expUserName.equals(actualUserName))
			System.out.println("Last name and User name are as expected");
		else
			System.out.println("last name and userName are not expected. Should be "+expLName+" and "+expUserName);
		System.out.println("EmpName-"+empName+" has "+"Last name - "+ actualLastName+" & username - "+actualUserName);
		System.out.println("Close browser");
		driver.close();
	}
}
