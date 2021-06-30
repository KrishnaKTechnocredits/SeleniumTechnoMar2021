package technocredits.tricky;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.PredefinedActions;
import technocredits.basics.TestBase;

public class PojoExample1 extends TestBase {

	ArrayList<Employee> getAllEmpDetails(WebDriver driver) {
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		ArrayList<Employee> listOfEmp = new ArrayList<Employee>();
		for(int index=1;index<=totalRows;index++) {
			String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			String empManagerId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText(); 
			String empdeptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText(); 
			
			Employee emp = new Employee();
			emp.setEmpId(Integer.parseInt(empId));
			emp.setEmpName(empName);
			emp.setEmpManagerId(Integer.parseInt(empManagerId));
			emp.setEmpDept(empdeptName);
			listOfEmp.add(emp);
		}
		return listOfEmp;
	}
	
	@Test
	public void empDataTest() {
		WebDriver driver = PredefinedActions.start();
		gotoDemoTable(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("table table-striped")));
		ArrayList<Employee> listOfEmp= getAllEmpDetails(driver);
		Assert.assertEquals(9, listOfEmp.size());
	}
	
	@Test
	public void empDataFirstRowTest() {
		WebDriver driver = PredefinedActions.start();
		gotoDemoTable(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		ArrayList<Employee> listOfEmp= getAllEmpDetails(driver);
		Employee e1 = listOfEmp.get(0);
		/*Assert.assertEquals(76993, e1.getEmpId());
		Assert.assertEquals("Abhijit Mane", e1.getEmpName());
		Assert.assertEquals(20209, e1.getEmpManagerId());*/
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(77993, e1.getEmpId());
		softAssert.assertEquals("Abhijit Mane", e1.getEmpName());
		softAssert.assertEquals(20209, e1.getEmpManagerId());
		softAssert.assertAll();
	}
}
