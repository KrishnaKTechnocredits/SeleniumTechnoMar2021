package ankit.Test_14_All_Test_TestNG_Conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;



public class Test10_FirstNameAndLastName {
	WebDriver driver ;
	
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}

	@Test
	public void verifyFirstNameAndLastName() {

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		String[] name = {"Abhishek","Maulik","Krishna","Dhara","Abhishek","Priya"};
		ArrayList<String> userDetail = new ArrayList<String>();
		LinkedHashMap<String, String> userDetailHM = new LinkedHashMap<String, String>();
		int dataCount = name.length;
		
		for(int index = 1; index <=dataCount ; index ++) {
			String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+name[index-1]+"']//ancestor::tr/td[3]")).getText();
			String uName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+name[index-1]+"']//ancestor::tr/td[4]")).getText();
			userDetail.add(lName);
			userDetail.add(uName);
			userDetailHM.put(lName,uName);
		}
		System.out.println("ArrayList :"+userDetail);
		System.out.println("HashMap :"+userDetailHM);
	}

}
