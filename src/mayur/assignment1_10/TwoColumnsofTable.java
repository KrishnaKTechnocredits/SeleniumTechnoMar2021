package mayur.assignment1_10;

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

public class TwoColumnsofTable {

	private static int getIndexOfColumn(WebDriver driver, String colName) {
		ArrayList<String> headerArrayList = new ArrayList<String>();
		List<WebElement> headerList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));

		for (WebElement headerListWE : headerList) {
			headerArrayList.add(headerListWE.getText());
		}
		return headerArrayList.indexOf(colName);
	}

	public static HashMap<String, String> getHashMapOfSelectedColumns(WebDriver driver, String col1, String col2) {
		HashMap<String, String> tableHM = new HashMap<String, String>();
		int col1Index = getIndexOfColumn(driver, col1) + 1;
		int col2Index = getIndexOfColumn(driver, col2) + 1;
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		System.out.println(totalRows);
		for (int index = 1; index <= totalRows; index++) {
			String key = driver
					.findElement(By.xpath(
							"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[" + col1Index + "]"))
					.getText();
			String value = driver
					.findElement(By.xpath(
							"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[" + col2Index + "]"))
					.getText();
			tableHM.put(key, value);
		}
		return tableHM;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println(
				"Enter two columns you need in HashMap (ex: #,Employee Id,Employee Name,Employee ManagerID,Employee Department):");
		Scanner sc = new Scanner(System.in);
		String col1 = sc.nextLine();
		System.out.println("and column 2");
		String col2 = sc.nextLine();
		System.out.println(getHashMapOfSelectedColumns(driver, col1, col2));

		driver.close();
		sc.close();
	}

}