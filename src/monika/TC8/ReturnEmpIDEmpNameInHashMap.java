package monika.TC8;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class ReturnEmpIDEmpNameInHashMap {
	WebDriver driver;
	
	@Test
	public void returnEmpIDName() {
		driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		HashMap<String,String> hm = new HashMap<String,String>();
		List<WebElement> rowsElement = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int index=1;index<=rowsElement.size();index++) {
			String empID = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[2]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[3]")).getText();
			hm.put(empID, empName);
		}
		System.out.println(hm);
	}

}
