package prachi.Assignment_1_to_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Test case : 10

Name -> "Maulik", print lastName and UserName

for(int index=1;index<=totalRows;index++){
	String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();

	if(firstName.equals("Maulik")){
	`	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
	
		String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
	}
}

or 

ArrayList<String>getEmpInfo(String empName){
	
	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]")).getText();

	String userName = driver.findELement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]")).getText();
	
	ArrayList<String>empDetailsList = new ArrayList<String>();
	empDetailsList.add(lName);
	empDetailList.add(userName);
	return empDetailList;
}

or

HashMap<String>getEmpInfo(String empName){
	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]")).getText();

	String userName = driver.findELement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]")).getText();
	
	HashMap<String,String>empDetailsMap = new HashMap<String,String>();
	empDetailsMap.put("LastName",lName);
	empDetailMap.put("UserName",userName);
	return empDetailMap;
}

or

String[] getEmpInfo(String empName){
	
	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]")).getText();

	String userName = driver.findELement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]")).getText();
	
	String[] empDetailsList = new String[2];
	empDetailsList[0] = lName;
	empDetailList[1] = userName;
	return empDetailList;
}*/


public class Assignment_10 {
	
	static ArrayList<String> getEmpInfoByArrayList(WebDriver driver) {
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();
		ArrayList<String> empDetailsList = new ArrayList<String>();
		empDetailsList.add(lName);
		empDetailsList.add(userName);
		return empDetailsList;
	}

	static HashMap<String, String> getEmpInfo(WebDriver driver) {
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();
		HashMap<String, String> empDetailsMap = new HashMap<String, String>();
		empDetailsMap.put("LastName", lName);
		empDetailsMap.put("UserName", userName);
		return empDetailsMap;
	}

	static String[] usingArray(WebDriver driver) {
		String lName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();

		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();

		String[] empDetailsList = new String[2];
		empDetailsList[0] = lName;
		empDetailsList[1] = userName;
		return empDetailsList;
	}

	public static void main(String[] args) {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com");
		//WebDriver driver = Assignment_10.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> employeeDetailsByList = getEmpInfoByArrayList(driver);
		System.out.println("Using Array List: " + employeeDetailsByList);
		HashMap<String, String> employeeDetails = getEmpInfo(driver);
		System.out.println("Using HashMap: " + employeeDetails);
		String[] employeeDetailsByArray = usingArray(driver);
		System.out.println("Using array: " + Arrays.toString(employeeDetailsByArray));
		driver.close();
	}

}
