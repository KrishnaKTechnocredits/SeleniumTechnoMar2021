package priyanka_Panat.TestCase_13;

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

public class TC_13 {
	static void WaitForElement(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	static HashMap<String, Integer> getEmployeeCountMap(WebDriver driver){
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String,Integer> mapOfMng=new HashMap<String,Integer>();
		for(int index=1;index<=totalRows;index++) {
			String empName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(mapOfMng.containsKey(empName))
				mapOfMng.put(empName,mapOfMng.get(empName)+1);
			else 
				mapOfMng.put(empName, 1);
			
		}
		return mapOfMng;
	}
	static void verifyEmpData(HashMap<String, Integer> mapOfMng) throws IOException {
		File file=new File(".//src/priyanka_Panat/TestCase_13/empInfo.properties");
		FileInputStream inputStream=new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		Set<String> keysOfEmp=mapOfMng.keySet();

		Iterator<String> itr=keysOfEmp.iterator();
		while(itr.hasNext()) {
			String currentKey=itr.next();
			int deptCountExpected=Integer.parseInt(prop.getProperty(currentKey));
			int deptCountActual=mapOfMng.get(currentKey);
			if(deptCountExpected==deptCountActual)
				System.out.println("Test Passed for Dept : " +currentKey);
			else
				System.out.println("Test Failed for Dept : "+currentKey);
		}

	}
	public static void main(String[] args) throws IOException {
		WebDriver driver=PredefinedActions.start();
		driver.findElement(By.partialLinkText("Tables")).click();;
		WaitForElement(driver,"//a[contains(text(),'Tables')]");
		HashMap<String,Integer> output=getEmployeeCountMap(driver);
		System.out.println(output);
		verifyEmpData(output);
		driver.close();
	}
}
