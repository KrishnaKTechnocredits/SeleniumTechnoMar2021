/*Test case - 13 : 
program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
		 10101 -> 2
*/
package monika.TC13;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class TC13_VerifyEmpCountFrom_WebTable_To_PropFile {
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

	public static HashMap<Integer,Integer> EmpCountUnderManagers() {
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
		return listOfMgrID;
		//tearDown();
		
		
	}
	
	public static void verifyMgrInfoWithPropFile(HashMap<Integer,Integer> hm) throws IOException {
		
		File file = new File(".\\src\\monika\\MgrInfo.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties propfile = new Properties();
		propfile.load(inputStream);
		
		Set<Integer> mgrIDKey = hm.keySet();
		for(Integer mgrID : mgrIDKey) {
			int empCountActual = hm.get(mgrID);
			Integer empCountExpected = Integer.parseInt(propfile.getProperty(String.valueOf(mgrID)));
			if(empCountActual == empCountExpected)
				System.out.println("Emp Count matches for MgrID : "+mgrID);
			else
				System.out.println("Emp Count does not matches for MgrID : "+mgrID);
		}
		tearDown();
	}
	public static void tearDown() {
		driver.close();
	}
	
	public static void main(String[] args) {
		HashMap<Integer,Integer> hm = EmpCountUnderManagers();
		try {
			verifyMgrInfoWithPropFile(hm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
