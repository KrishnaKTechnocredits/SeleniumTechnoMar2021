/*
Test case : 8
Return a map of empId and empName

HashMap<String,String> empDataMap = new HashMap<String,String>();
size = //table[@class='table table-striped']/tbody/tr;

for(int index=1;index<=size;index++){
	String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]
		")).getText();
	
	String empName = driver.findElement(By.xpath("//table[@class='table 			  	   table-striped']/tbody/tr["+index+"]/td[3]"));
	
	empDataMap.put(empId,empName);
}
return empDataMap;
 */
package sourabh.testCase8;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test8 {
	static HashMap<String, String> getMapOfEmpIdAndEmpName(WebDriver driver) {
		HashMap<String, String> mapOfEmpIdAndEmpName= new HashMap<String, String>();
		List<WebElement> listofTR= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size= listofTR.size();
		for(int index=1; index<=size; index++) {
			String empID= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			String empName= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			mapOfEmpIdAndEmpName.put(empID, empName);
		}
		return mapOfEmpIdAndEmpName;
	}
	
	public static void main(String[] args) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		System.out.println("Open Url");
		String url= "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		//----------------------------------------------------------------------------------
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		
		HashMap<String, String> outputMap= getMapOfEmpIdAndEmpName(driver);
		System.out.println(outputMap);
	}
}

