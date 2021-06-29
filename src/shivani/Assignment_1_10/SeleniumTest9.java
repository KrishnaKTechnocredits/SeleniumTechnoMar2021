package shivani.Assignment_1_10;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest9 {
	static HashMap<String,String> empMap(){
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("http://automationbykrishna.com/");
		 driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String,String> empDataMap = new HashMap<String,String>();
		List<WebElement> sizeinString = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size = sizeinString.size();
		for(int index=1;index<=size;index++){
			String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			empDataMap.put(empId, empName);
		}
		return empDataMap;
	}

		public static void main(String[] args) {
			HashMap<String,String> employeeData = empMap();
			System.out.println(employeeData);
		}


}
