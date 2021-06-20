////Return a map of empId and empName

package krati_Shukla.Selenium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		getEmpName(driver);
	}
	
	static void getEmpName(WebDriver driver) throws InterruptedException {
		//Return a map of empId and empName
		HashMap<String,String> list = new HashMap<String,String>();
		//List<WebElement> empId = new LinkedList<WebElement>();
		//List<WebElement> empName = new LinkedList<WebElement>();
		LinkedList<String> newEmpId = new LinkedList<String>();
		LinkedList<String> newEmpName = new LinkedList<String>();
		
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size = ele.size();
		//System.out.println(size);
		for(int index=1; index <= size; index++) { // Adding all emp Id & Name to LIST
			String empId = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[2]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]//td[3]")).getText();
			list.put(empId, empName);
		}
		System.out.println(list);
		

	}

}
