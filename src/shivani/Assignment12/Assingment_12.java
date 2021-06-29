package shivani.Assignment12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
		 10101 -> 2*/
public class Assingment_12 {
	
	static HashMap<String,Integer> getNumberOfEmpUnderEachManager(WebDriver driver) {
		HashMap<String,Integer> NoOfEmp = new HashMap<String,Integer>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index = 1; index<=totalRows; index++) {
			String Managerlist = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(NoOfEmp.containsKey(Managerlist))
				NoOfEmp.put(Managerlist, NoOfEmp.get(Managerlist)+1);
			else
				NoOfEmp.put(Managerlist, 1);
		}
		return NoOfEmp;
}
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String,Integer> output = getNumberOfEmpUnderEachManager(driver);
		System.out.println(output);
	}
}
