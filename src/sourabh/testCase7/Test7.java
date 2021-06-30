/*
Test case : 7
rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".
 */
package sourabh.testCase7;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test7 {
	
	static ArrayList<String> getColList(WebDriver driver){
		ArrayList<String> tableHeaderList= new ArrayList<String>();
		List<WebElement> headerList= driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for(WebElement header: headerList) {
			tableHeaderList.add(header.getText());
		}
		return tableHeaderList;
	}
	static String getEmpDataByName(WebDriver driver, String name, int index) {
		String lastName= driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td["+index+"]")).getText();
		return lastName;
	}
	
	public static void main(String[] args) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		System.out.println("Open Url");
		String url= "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		//-----------------------------------------------------------
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		ArrayList<String> tableHeaderList =getColList(driver);
		System.out.println(tableHeaderList);
		int index= tableHeaderList.indexOf("Last Name")+1;
		String lastname= getEmpDataByName(driver, "Abhishek", index);	
		System.out.println(lastname);
	}
}


