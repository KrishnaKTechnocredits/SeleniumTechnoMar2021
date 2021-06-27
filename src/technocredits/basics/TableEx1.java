package technocredits.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class TableEx1 {

	static ArrayList<String> getColList(WebDriver driver){
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for(WebElement element : headElementList){
			headerList.add(element.getText());
		}
		return headerList;
	} 
	
	static String getEmpDataByName(WebDriver driver,String name, int index){
		return driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		
		ArrayList<String> headerList = getColList(driver);
		System.out.println(headerList);
		int index = headerList.indexOf("Last Name") + 1;
		getEmpDataByName(driver,"Abhishek",index);
	}
}
