/*Test Case - 13 [18-06-2021]
Program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
 */

package sourabh.testCase13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase13Prop {
	static HashMap<String, Integer> getEmployeeCountEachManagerMap(WebDriver driver){
		int countRows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, Integer> employeeCountEachManager= new HashMap<String, Integer>();
		for(int index=1; index<=countRows; index++) {
			String managerID= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(employeeCountEachManager.containsKey(managerID))
				employeeCountEachManager.put(managerID, employeeCountEachManager.get(managerID)+1);
			else
				employeeCountEachManager.put(managerID, 1);
		}
		return employeeCountEachManager;
	}
	//-------------------------------------------------------------------------
	static void verifyManagerID(HashMap<String, Integer> employeeCountEachManager) throws IOException{
		File file= new File(".//resources/managerID.properties");
		FileInputStream	inputStream	= new FileInputStream(file);	
		Properties prop= new Properties();
		prop.load(inputStream);
		
		Set<String> keys= employeeCountEachManager.keySet();
		for(String currentKey: keys) {
			int managerIdExpected= Integer.parseInt(prop.getProperty(currentKey));
			int managerIdActual= employeeCountEachManager.get(currentKey);
			if(managerIdExpected==managerIdActual)
				System.out.println("Test Pass for manager ID : "+currentKey );
			else
				System.out.println("Test Fail for manager ID : "+currentKey );			
		}

	}
	
	//-------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		System.out.println("STEP1 : Launch chrome browser"); 
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP2 : Open URL ");
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		// ----------------------------------------------------------------------------------
		System.out.println("STEP3 : Wait for Demo Tables page to load  ");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		
		//-----------------------------verifyManagerID-----------------------
		HashMap<String, Integer> outputManagerID= getEmployeeCountEachManagerMap(driver);
		System.out.println("Emplyee count in each Employee count under a Manager : " +outputManagerID);
		
		try {
			verifyManagerID(outputManagerID);
		} catch (IOException e) {
			System.out.println("Couldn't load the managerID file into memory.");
			e.printStackTrace();
		}

		driver.close();
	}

}
