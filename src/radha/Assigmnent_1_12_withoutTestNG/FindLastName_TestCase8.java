package radha.Assigmnent_1_12_withoutTestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class FindLastName_TestCase8 {
	ArrayList<String> getColList(WebDriver driver) {
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']//th"));
		for (WebElement element : headElementList) {
			headerList.add(element.getText());
		}
		return headerList;
	}
	
	String findLastName(WebDriver driver, int index,String name) {
		String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
		return lastName;
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();;
		FindLastName_TestCase8 last = new FindLastName_TestCase8();
		ArrayList<String> header = last.getColList(driver);
		int index = header.indexOf("Last Name")+1;
		System.out.println(index);
		String lastName = last.findLastName(driver, index, "Abhishek");
		System.out.println("Last name of Abhishek in table having dynamic rows & columns : "+lastName);
		System.out.println("Closing browser...");
		driver.close();
	}
}
