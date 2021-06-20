//verify username from table "EMPLOYEE BASIC INFORMATION"

package krati_Shukla.Selenium;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		LinkedList<String> userName = getUserName(driver);
		isCorrectUserName(userName);
	}

	static LinkedList<String> getUserName(WebDriver driver) throws InterruptedException {

		int index = 1;
		LinkedList<String> firstName = new LinkedList<String>();
		LinkedList<String> lastName = new LinkedList<String>();
		LinkedList<String> tempName = new LinkedList<String>();
		LinkedList<String> userName = new LinkedList<String>();

		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);

		List<WebElement> header = driver.findElements(By.xpath("//table[@id='table1']//thead"));

		for (WebElement temp : header) {
			if (temp.getText() == "FirstName") {
				index++;
				break;
			} else
				index++;
			System.out.println(index);// Printing the index of 'FirstName' column
		}

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = totalRows.size(); // identifying Total Rows from Table
		// System.out.println(rowCount);
		List<WebElement> first = driver.findElements(By.xpath("//table[@id='table1']//td[" + index + "]"));
		List<WebElement> last = driver.findElements(By.xpath("//table[@id='table1']//td[" + (index + 1) + "]"));

		for (WebElement firstTemp : first)
			firstName.add(firstTemp.getText());

		for (WebElement lastTemp : last)
			lastName.add(lastTemp.getText());

		System.out.println(firstName); // Printing Firstname
		System.out.println(lastName); // Printing lastname

		for (String userTemp : firstName) { // storing 1st letter from firstname in a temporary List
			char firstLetter = userTemp.charAt(0);
			tempName.add(firstLetter + "");
		}

		for (int i = 0; i < rowCount; i++) { // creating username by concatenating First & Last name

			userName.add(tempName.get(i) + lastName.get(i));
			System.out.println(userName);
		}
		return userName;
	}
	
	static void isCorrectUserName(LinkedList<String> userName) {
		String expectedUsername = "mkanani";
		
		for(String temp : userName) {
			
			if(expectedUsername.equals(temp.toLowerCase())) {
				System.out.println("Username :"+temp.toLowerCase()+" is present");
				break;
			}
		}
	}

}
