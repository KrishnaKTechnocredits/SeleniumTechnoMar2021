package shivani.Assignment_1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Test case : 7
//rows and cols are dynamic, get the lastname of the emp whoesfirstname is "Abhishek".
public class SeleniumTest8 {
	

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
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("http://automationbykrishna.com/");
		 driver.manage().window().fullscreen();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> headerList = getColList(driver);
		int index = headerList.indexOf("Last Name") + 1;
		String lName = getEmpDataByName(driver,"Abhishek",index);
		System.out.println("Last name of employee whose first name is Abhishek is: "+lName);
		driver.close();
	}
}