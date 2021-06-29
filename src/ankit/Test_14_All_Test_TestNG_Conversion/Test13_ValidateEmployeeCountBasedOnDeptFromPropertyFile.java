package ankit.Test_14_All_Test_TestNG_Conversion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;
import ankit.AM_util.PropertyFileReader_util;

public class Test13_ValidateEmployeeCountBasedOnDeptFromPropertyFile {

	WebDriver driver ;

	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}

	private HashMap<String, Integer> getEmployeeCoutAsPerDept(WebDriver driver) {
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

	private String getDataFromPropertyAsPerKey(String filePath , String targetKey) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		return prop.getProperty(targetKey) ;
	}

	public void verifyDepartmentEmployeeCount(HashMap<String, Integer> deptEmpHM) throws IOException {
		Set<String> HMDeptID = deptEmpHM.keySet();
		for(String deptName : HMDeptID) {
			
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

@Test
	public void VerifyEmployeeCOuntFromPropertyFile() throws IOException {
		HashMap<String, Integer> deptEmpHM = getEmployeeCoutAsPerDept(driver);
		verifyDepartmentEmployeeCount(deptEmpHM);
	}	
}
