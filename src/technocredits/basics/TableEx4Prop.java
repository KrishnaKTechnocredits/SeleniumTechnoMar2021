package technocredits.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class TableEx4Prop {

	static void waitForElement(WebDriver driver,String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	static HashMap<String,Integer> getDeptCountMap(WebDriver driver){
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String,Integer> mapOfDepts = new HashMap<String,Integer>();
		for(int index=1;index<=totalRows;index++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(mapOfDepts.containsKey(deptName)) {
				int count = mapOfDepts.get(deptName);
				mapOfDepts.put(deptName, count+1);
			}else 
				mapOfDepts.put(deptName, 1);
		}	
		return mapOfDepts;
	}
	
	static void verifyDeptData(HashMap<String,Integer> mapOfDepts) throws IOException {
		File file = new File(".//resources/deptInfo.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		
		Set<String> keys = mapOfDepts.keySet();
		/*for(String currentKey : keys) {
			int deptCountExpected = Integer.parseInt(prop.getProperty(currentKey));
			int deptCountActual = mapOfDepts.get(currentKey);
			if(deptCountExpected == deptCountActual)
				System.out.println("Test Pass for dept " + currentKey);
			else
				System.out.println("Test Fail for dept " + currentKey);
		}*/
		
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()) {
			String currentKey = itr.next();
			int deptCountExpected = Integer.parseInt(prop.getProperty(currentKey));
			int deptCountActual = mapOfDepts.get(currentKey);
			if(deptCountExpected == deptCountActual)
				System.out.println("Test Pass for dept " + currentKey);
			else
				System.out.println("Test Fail for dept " + currentKey);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("STEP - Launch browser & hit AutomationBykrishna.com");
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP - Navigate to Demo Tables");
		driver.findElement(By.partialLinkText("Tables")).click();
		System.out.println("Wait for DemoTable page to load");
		waitForElement(driver,"//a[contains(text(),'Tables')]");
		System.out.println("Get UniqueDept count");
		HashMap<String,Integer> output = getDeptCountMap(driver);
		System.out.println(output);
		try {
			verifyDeptData(output);
		} catch (IOException e) {
			System.out.println("Couldn't load deptInfo file into memory");
			e.printStackTrace();
		}
		PredefinedActions.tearDown();
	}
}
