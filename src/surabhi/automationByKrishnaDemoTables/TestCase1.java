package surabhi.automationByKrishnaDemoTables;

import org.testng.annotations.Parameters;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//rows and cols are dynamic, get the lastname of the emp whoesfirstname is "Abhishek"

public class TestCase1 extends BaseClass {
	
	static int getLastIndex(WebDriver driver) {
		String LastName="Last Name";
		ArrayList<String> header=new ArrayList<String>();
		
		//wait for 5 secs to get last name
		WebDriverWait webDriverWait=new WebDriverWait(driver, 2); 
		List<WebElement> al=webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']//th")));
		
		for(WebElement headerElement:al) {
			header.add(headerElement.getText());
		}
		
		//ArrayListIndex +1 to get tag td[2] for last name values in table UI
		return header.indexOf(LastName)+1;
	}
	
	@Parameters("name")
	@Test
	void getIndexOfLastName(String name) {
		System.out.println(name);
		String LastName="Last Name";
		ArrayList<String> header=new ArrayList<String>();
		
		//wait for 5 secs to get last name
		WebDriverWait webDriverWait=new WebDriverWait(driver, 2); 
		List<WebElement> al=webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='table1']//th")));
		
		for(WebElement headerElement:al) {
			header.add(headerElement.getText());
		}
		int indexOfLastName=header.indexOf(LastName)+1;
		//int indexOfLastName=getLastIndex(driver);
		//get column index where last name is resides using ArrayList index
		String lastName=driver.findElement(By.xpath("//table[@id='table1']//td[text()='"+name+"']/../td["+indexOfLastName+"]")).getText();
		System.out.println("last Name is "+lastName);
	}

}
