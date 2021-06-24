package ankit.Test_14_All_Test_TestNG_Conversion;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test11_WebTableCountsByGrouping {
	WebDriver driver ;

	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	@Test
	private void getUniqueDepartmentCount() {
		List<WebElement> listOfAllDept = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> deptIDHS = new HashSet<String>();
		for(WebElement weListOfDept:listOfAllDept) {
			deptIDHS.add(weListOfDept.getText());
		}
		System.out.println(deptIDHS +"Count :"+deptIDHS.size());
	}
	@Test
	private  void getUniqueManagerCount() {
		List<WebElement> listOfAllManager = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashSet<String> ManagerIDHS = new HashSet<String>();
		for(WebElement weListOfAllManager:listOfAllManager) {
			ManagerIDHS.add(weListOfAllManager.getText());
		}
		System.out.println(ManagerIDHS +"Count :"+ManagerIDHS.size());	
	}
	@Test
	public void getUniqueEmployeeCounts() {
		List<WebElement> listOfAllEmp = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
		HashSet<String> EmpIDHS = new HashSet<String>();
		for(WebElement weListOfAllEmp:listOfAllEmp) {
			EmpIDHS.add(weListOfAllEmp.getText());
		}
		System.out.println(EmpIDHS +"Count :"+EmpIDHS.size());	
	}

}
