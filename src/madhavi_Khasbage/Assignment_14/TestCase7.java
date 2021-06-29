package madhavi_Khasbage.Assignment_14;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

/*Test case 7 >> rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/

public class TestCase7 {
	
	WebDriver driver;
	
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		String expectedURL = "http://automationbykrishna.com/";
		driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step3: Close browser");
		driver.close();
	}
	
	@Test
	void getEmpDataByName(){	
		String name="Abhishek";		
		driver.findElement(By.id("demotable")).click();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		
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
		
		System.out.println("STEP3: Find Last Name of " + name);
		String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='" + name + "']//parent::tr/td[" + index + "]")).getText();
		System.out.println("Last Name of " + name + " is " + lastName);		
	}
}
