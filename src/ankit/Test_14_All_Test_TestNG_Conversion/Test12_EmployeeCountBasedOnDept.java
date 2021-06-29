package ankit.Test_14_All_Test_TestNG_Conversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test12_EmployeeCountBasedOnDept {

	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	@Test
	public void getEmployeeCoutAsPerDept() {
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

}

