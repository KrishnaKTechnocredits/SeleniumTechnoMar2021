/*Test case : 10
Name -> "Maulik", print lastName and UserName */

/*for(int index=1;index<=totalRows;index++){
	String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();

	if(firstName.equals("Maulik")){
	`	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
	
		String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
	}
}

or 

ArrayList<String> getEmpInfo(String empName){
	
	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]")).getText();

	String userName = driver.findELement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]")).getText();
	
	ArrayList<String> empDetailsList = new ArrayList<String>();
	empDetailsList.add(lName);
	empDetailList.add(userName);
	return empDetailList;
}

or

HashMap<String> getEmpInfo(String empName){
	String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]")).getText();

	String userName = driver.findELement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]")).getText();
	
	HashMap<String,String> empDetailsMap = new HashMap<String,String>();
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
}
 */

package sourabh.testCase10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test10 {
	static void getLastNameAndUserName(WebDriver driver, String targetName) {
		List<WebElement> listTR= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int size= listTR.size(); 
		String firstName=null, lastName = null, userName = null;
		for(int index=1; index<=size; index++) {
			
			firstName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			if(targetName.equals(firstName)) {
				
			lastName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			userName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			}
			
		}
		System.out.println("FirstName : "+targetName+" LastName : "+lastName+" UserName : "+userName);
	}
	
	public static void main(String[] args) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		System.out.println("Open Url");
		String url= "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		//----------------------------------------------------------------------------------
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		getLastNameAndUserName(driver, "Maulik");
	}

}

