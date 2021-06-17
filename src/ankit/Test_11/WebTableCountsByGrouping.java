package ankit.Test_11;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableCountsByGrouping {
	private static WebDriver driver;

	public static void setUp(String URL) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
	}

	private static void getUniqueDepartmentCount(WebDriver driver) {
		List<WebElement> listOfAllDept = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> deptIDHS = new HashSet<String>();
		for(WebElement weListOfDept:listOfAllDept) {
			deptIDHS.add(weListOfDept.getText());
		}
		System.out.println(deptIDHS +"Count :"+deptIDHS.size());
	}

	private static void getUniqueManagerCount(WebDriver driver) {
		List<WebElement> listOfAllManager = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashSet<String> ManagerIDHS = new HashSet<String>();
		for(WebElement weListOfAllManager:listOfAllManager) {
			ManagerIDHS.add(weListOfAllManager.getText());
		}
		System.out.println(ManagerIDHS +"Count :"+ManagerIDHS.size());	
	}

	private static void getUniqueEmployeeCounts(WebDriver driver) {
		List<WebElement> listOfAllEmp = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
		HashSet<String> EmpIDHS = new HashSet<String>();
		for(WebElement weListOfAllEmp:listOfAllEmp) {
			EmpIDHS.add(weListOfAllEmp.getText());
		}
		System.out.println(EmpIDHS +"Count :"+EmpIDHS.size());	
	}
	public static void tearDown(WebDriver driver) {
		driver.close();
	}

	public static void main (String[] args) {
		setUp("http://automationbykrishna.com");
		//			program 1: How many Depts we have.
		getUniqueDepartmentCount(driver);

		//	program 2 : how many managers we have.
		getUniqueManagerCount(driver);

		//	program 3: how many employees we have.
		getUniqueEmployeeCounts(driver);
		tearDown(driver);
	}
}
