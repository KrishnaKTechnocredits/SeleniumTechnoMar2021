package trupti.assignment7;
//Get the last name of employee whose first name is "Abhishek".
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpAgeAbhishek {
	static ArrayList <String> getColList(WebDriver driver){
		ArrayList<String>headerList=new ArrayList<String>();
		List<WebElement>headElementList=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for(WebElement element:headElementList) {
			headerList.add(element.getText());
		}
		return headerList;
	}
	
	static String getEmpDataByName(WebDriver driver,String name,int index) {
		return driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
		
	}

public static void main(String[] args) {
	System.out.println("Step 1 - Launch a chrome");
	System.setProperty("webdriver.chrome.driver", "..\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	System.out.println("Step 2 - AutomationByKrishna.com ");
	driver.navigate().to("http://automationbykrishna.com/");
	System.out.println("Step 3 : Click on demotables");
	driver.findElement(By.id("demotable")).click();
	WebDriverWait wait=new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
	/*WebElement element=driver.findElement(By.xpath("//td[text()='Caesar Vance']//following-sibling::td[3]"));
	JavascriptExecutor je=(JavascriptExecutor)driver;
	je.executeScript("arguments[0].scrollIntoView(true)",element);*/
	ArrayList<String> headerList = getColList(driver);
	int index = headerList.indexOf("Last Name") + 1;
	String name="Abhishek";
	String output=getEmpDataByName(driver,"Abhishek",index);
	System.out.println("Last name of "+name+" is " +output);
	driver.close();

}

}

