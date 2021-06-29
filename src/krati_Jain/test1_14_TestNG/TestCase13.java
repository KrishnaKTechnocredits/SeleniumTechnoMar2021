// count number of employee under each manager, verify count against properties file.

package krati_Jain.test1_14_TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase13 {

	WebDriver driver;
	HashMap<String, Integer> empMngr = new HashMap<String, Integer>();

	@BeforeClass
	public void setDriver() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void getEmpManagers() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size = table.size();
		Thread.sleep(3000);		
		for (int index = 1; index <= size; index++) {
			
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]/td[3]")).getText();
			String manager = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]/td[4]")).getText();	
			if(!empMngr.containsKey(manager))
			empMngr.put(manager, 1);
			else
				empMngr.put(manager, empMngr.get(manager)+1);
			
		}		
	}
	
	@Test
	public void validateEmpManager() throws IOException {
		File file = new File("C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\SeleniumProjects\\SeleniumProject\\resources\\deptInfo.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		//ArrayList<String> keysFromMap =outputMap.keySet();
		for(String eachKey : empMngr.keySet()) {
			int actualEmpcount = empMngr.get(eachKey);
			int expectedEmpcount = Integer.parseInt(prop.getProperty(eachKey));
			Assert.assertEquals(actualEmpcount, expectedEmpcount, "Count for 2029 is not correct");
			
		}
		
	}
	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}
	
}
