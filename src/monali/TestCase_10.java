package monali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_10 {
	static void getLnameAndUname(WebDriver driver) {
		int totalRows = driver.findElements(By.xpath("//table[@class='table']//thead/tr[1]//following::tr[1]")).size();

	for(int index=1;index<=totalRows;index++){
		String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();

		if(firstName.equals("Maulik")){
			String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			System.out.println(lName);
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			System.out.println(userName);
		}
	}
}
public static void main(String[] args) {
	WebDriver driver = PredefinedActions.start();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	driver.findElement(By.xpath("//a[@id='demotable']")).click();
	getLnameAndUname(driver);
}



}
