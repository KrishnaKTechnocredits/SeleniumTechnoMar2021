package ankit.Test_1_10.Test10;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstNameAndLastName {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		String[] name = {"Abhishek","Maulik","Krishna","Dhara","Abhishek","Priya"};
		//String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+name+"']//ancestor::tr/td[3]")).getText();
		//String uName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+name+"']//ancestor::tr/td[4]")).getText();
		//System.out.println("LastName :"+lName);
		//System.out.println("User Name :"+uName);
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
		driver.close();
	}

}
