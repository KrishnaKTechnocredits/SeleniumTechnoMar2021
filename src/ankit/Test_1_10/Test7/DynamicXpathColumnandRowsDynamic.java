package ankit.Test_1_10.Test7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicXpathColumnandRowsDynamic {

	private static int getIndexOfColumn(WebDriver driver, String colName) {
		ArrayList<String> headerArrayList = new ArrayList<String>();
		List<WebElement> headerList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		for(WebElement headerListWE :headerList) {
			headerArrayList.add(headerListWE.getText());
		}
		return headerArrayList.indexOf(colName);
	}
	
	public static String getRequiredColumnValue(WebDriver driver , String key, String fName, String columnNeeded) {
		int colIndex = getIndexOfColumn(driver, columnNeeded)+1;
		int keyIndex = getIndexOfColumn(driver, key)+1;
		String value = driver.findElement(By.xpath("//table[@id='table1']//tr/td["+keyIndex+"][text()='"+fName+"']//ancestor::tr/td["+colIndex+"]")).getText();
		return value;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the coulun which you want to use as Key :");
		String key = sc.nextLine();
		System.out.println("Enter Name for which you want value: ");
		String fName = sc.nextLine();
		System.out.println("Enter Column Heading for which you need data ex:[#, First Name, Last Name, Username]: ");
		String columnNeeded = sc.nextLine();
		
	System.out.println("For column "+key+" with value as "+fName+" Column "+columnNeeded+" value is "+getRequiredColumnValue
			(driver, key, fName, columnNeeded));
		
		driver.close();
	}

}
