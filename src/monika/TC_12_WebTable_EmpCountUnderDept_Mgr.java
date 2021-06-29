/*Test case - 12: 16th Jun'2021
program 1: employee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.

program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2*/
		 
package monika;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.PredefinedActions;

public class TC_12_WebTable_EmpCountUnderDept_Mgr {
	private static WebDriver driver;
	private static WebDriverWait wait;

	public static void startAndWaitOnDemoTable() {
		driver = PredefinedActions.start();
		System.out.println("STEP: Click on the demo table");
		wait = new WebDriverWait(driver, 2);
		WebElement demotableElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='demotable']")));
		demotableElement.click();
	}

	public static void EmpCountOfDepts() {
		startAndWaitOnDemoTable();
		System.out.println("STEP: Identify the element");
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr//td[5]"));
		HashMap<String,Integer> listOfDepts = new HashMap<String,Integer>();
		for (WebElement e : elements) {
			String deptNameKey = e.getText();
			if(listOfDepts.containsKey(deptNameKey)) {
				listOfDepts.put(deptNameKey, listOfDepts.get(deptNameKey)+1);
			}else
				listOfDepts.put(deptNameKey, 1);
		}
		System.out.println("Size of depts : "+listOfDepts.size());
		System.out.println("Dept name and count of emps : "+listOfDepts);
		tearDown();
	}
	public static void EmpCountUnderManagers() {
		startAndWaitOnDemoTable();
		System.out.println("STEP: Identify the element");
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr//td[4]"));
		HashMap<Integer,Integer> listOfMgrID = new HashMap<Integer,Integer>();
		for (WebElement e : elements) {
			Integer mgrIDKey = Integer.parseInt(e.getText());
			if(listOfMgrID.containsKey(mgrIDKey)) {
				listOfMgrID.put(mgrIDKey, listOfMgrID.get(mgrIDKey)+1);
			}else
				listOfMgrID.put(mgrIDKey, 1);
		}
		System.out.println("Total managerID's : "+listOfMgrID.size());
		System.out.println("Manager ID with emps count : "+listOfMgrID);
		tearDown();
	}
	public static void tearDown() {
		driver.close();
	}
	
	public static void main(String[] args) {
		EmpCountOfDepts();
		EmpCountUnderManagers();
	}

}
