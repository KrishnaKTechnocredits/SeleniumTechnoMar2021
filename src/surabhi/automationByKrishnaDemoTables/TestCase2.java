package surabhi.automationByKrishnaDemoTables;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//Return a map of empId and empName 
public class TestCase2 extends BaseClass {
	
	int getSize(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 2);
		List<WebElement> item=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']//tbody/tr")));
		return item.size();
	}
	
	@Test
	void getElementsMap()  {
		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		int size=getSize(driver);
		
		for(int index=0;index<size;index++) {
			Integer id=Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+(index+1)+"]/td[2]")).getText());
			String name=driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+(index+1)+"]/td[3]")).getText();
			hm.put(id, name);
		}
		System.out.println(hm);
	}

}
