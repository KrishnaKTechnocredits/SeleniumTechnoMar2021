package ankit.Test_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeCountBasedOnDept {

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

	private static void getEmployeeCoutAsPerDept(WebDriver driver) {
		HashMap<String, Integer> deptEmpHM = new HashMap<String, Integer>();
		List<WebElement> listOFDept = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		ArrayList<String> listOfUniqueDept = new ArrayList<String>();

		for(WebElement weListOfDept :listOFDept) {
			if(!listOfUniqueDept.contains(weListOfDept.getText())) {
				listOfUniqueDept.add(weListOfDept.getText());	
			}	
		}
		for(int index= 0 ; index < listOfUniqueDept.size(); index++) {
			String key =  listOfUniqueDept.get(index);
			int value = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='"+key+"']")).size();
			deptEmpHM.put(key, value);
		}
		System.out.println(deptEmpHM);
	}

	public static void tearDown(WebDriver driver) {
		driver.close();
	}

	public static void main(String[] args) {
		setUp("http://automationbykrishna.com");

		getEmployeeCoutAsPerDept(driver);

		tearDown(driver);

		// TODO Auto-generated method stub

	}
}
