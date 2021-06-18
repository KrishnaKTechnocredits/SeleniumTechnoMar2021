/*
Test case : 8
Return a map of empId and empName

HashMap<String,String>empDataMap = new HashMap<String,String>();
size = //table[@class='table table-striped']/tbody/tr;

for(int index=1;index<=size;index++){
	String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]
		")).getText();
	String empName = driver.findElement(By.xpath("//table[@class='table-striped']/tbody/tr["+index+"]/td[3]"));
	empDataMap.put(empId,empName);
}
	return empDataMap;
 */
package paras.Test_Case_1_to_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase8 {

	private static int getIndexOfColumn(WebDriver driver, String colName) {
		ArrayList<String> arrayListHeader = new ArrayList<String>();
		List<WebElement> listofLeader = driver
				.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));

		for (WebElement headerList : listofLeader) {
			arrayListHeader.add(headerList.getText());
		}
		return arrayListHeader.indexOf(colName);
	}

	public static HashMap<String, String> columnsHashMap(WebDriver driver, String column1, String column2) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		int column1Index = getIndexOfColumn(driver, column1) + 1;
		int column2Index = getIndexOfColumn(driver, column2) + 1;
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= totalRows; index++) {
			String key = driver
					.findElement(By.xpath(
							"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[" + column1Index + "]"))
					.getText();
			String value = driver
					.findElement(By.xpath(
							"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[" + column2Index + "]"))
					.getText();
			hashMap.put(key, value);
		}
		return hashMap;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println(
				"Enter two columns you need in HashMap (Employee Id,Employee Name)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Column1");
		String column1 = sc.nextLine();
		System.out.println("Enter Column2");
		String column2 = sc.nextLine();
		
		System.out.println(columnsHashMap(driver, column1, column2));
		driver.close();
	}
}