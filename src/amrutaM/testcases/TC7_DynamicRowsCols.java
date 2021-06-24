package amrutaM.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import amrutaM.base.PredefinedActions;

/*rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/

public class TC7_DynamicRowsCols {
	
	ArrayList<String> getHeaderList(WebDriver driver){
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		
		for(WebElement element : headElementList){
			headerList.add(element.getText());
		}
		return headerList;
	} 

	String getEmpDataByName(WebDriver driver,String name, int index){
		return driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
	}
	
	public static void main(String[] args) {
		TC7_DynamicRowsCols tc7 = new TC7_DynamicRowsCols();
		WebDriver driver = PredefinedActions.setUp();
		System.out.println("Navigating user to the Demo Tables page");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		ArrayList<String> headerList = tc7.getHeaderList(driver);	
		int index = headerList.indexOf("Last Name") + 1;
		String lastName = tc7.getEmpDataByName(driver,"Abhishek",index);
		System.out.println("Last Name of employee with first name as Abhishek is --> "+lastName);		
		PredefinedActions.tearDown();
	}
}
