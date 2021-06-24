package ankit.Test13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ankit.AM_util.PropertyFileReader_util;

public class ValidateEmployeeCountBasedOnDeptFromPropertyFile {

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

	private static HashMap<String, Integer> getEmployeeCoutAsPerDept(WebDriver driver) {
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
		return deptEmpHM;
	}
	
	private static String getDataFromPropertyAsPerKey(String filePath , String targetKey) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		return prop.getProperty(targetKey) ;
	}
	
	public static void verifyDepartmentEmployeeCount(HashMap<String, Integer> deptEmpHM) throws IOException {
		Set<String> HMDeptID = deptEmpHM.keySet();
		for(String deptName : HMDeptID) {
			//String countDepEmpPropst = getDataFromPropertyAsPerKey("F:\\New Beginning\\Eclipse Workspace\\SeleniumTechnoMar2021\\src\\ankit\\AM_config\\DeptEmpCount.properties", deptName);
			PropertyFileReader_util propertyFileReader_util = new PropertyFileReader_util("./src/ankit/AM_config/DeptEmpCount.properties");
			String countDepEmpPropst = propertyFileReader_util.getValueFromKey(deptName);
			int countDepEmpProp = Integer.valueOf(countDepEmpPropst);
			int countDepEmpHM = deptEmpHM.get(deptName);
			if (countDepEmpProp == countDepEmpHM)
				System.out.println(deptName+" : "+countDepEmpProp+" : "+countDepEmpHM+" - PASS");
			else
				System.out.println(deptName+" : "+countDepEmpProp+" : "+countDepEmpHM+" - FAIL");
		}
	}

	public static void tearDown(WebDriver driver) {
		driver.close();
	}

	public static void main(String[] args) throws IOException {
		setUp("http://automationbykrishna.com");
		HashMap<String, Integer> deptEmpHM = getEmployeeCoutAsPerDept(driver);
		verifyDepartmentEmployeeCount(deptEmpHM);
		tearDown(driver);
	}	
}
