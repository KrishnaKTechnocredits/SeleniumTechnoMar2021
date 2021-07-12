package madhavi_Khasbage.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import madhavi_Khasbage.base.PredefinedActions;

/*Test case 7 >> rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/

public class TestCase7 {
	void getEmpDataByName(String name) throws InterruptedException{		
		System.out.println("STEP1: Open url on browser");
		String expectedURL = "http://automationbykrishna.com/";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.findElement(By.id("demotable")).click();
		
		Thread.sleep(3000);
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/")));
		
		ArrayList<String> headerList = new ArrayList<String>();
		
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement columnHeading : headElementList) {
			headerList.add(columnHeading.getText());
		}
		System.out.println(headerList);
		int index = 0;
		System.out.println("STEP2: Get column number of Last Name");
		for (String header : headerList) {
			if (header.equals("Last Name")) {
				index = headerList.indexOf(header);
				index++;
				break;
			}
		}
		System.out.println(index);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		System.out.println("STEP3: Find Last Name of " + name);
		String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='" + name + "']//parent::tr/td[" + index + "]")).getText();
		System.out.println("Last Name of " + name + " is " + lastName);
		
		System.out.println("STEP3: Close browser");		
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException{
		TestCase7 lastName= new TestCase7();		
		lastName.getEmpDataByName("Abhishek");
	}
}
