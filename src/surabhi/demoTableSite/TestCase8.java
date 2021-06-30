package surabhi.demoTableSite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
 * Print employee Age whose salary is minimum.
*/

public class TestCase8 extends BaseClass{
	
	@Test
	public void runTestCase() {
		
		List<WebElement> salaryText=driver.findElements(By.xpath("//table[@id='example']//tr/td[6]"));
		
		//hashMap for salary as key, age as value pairing
		HashMap<String, String> hm=new HashMap<String, String>();
		
		String keySalary="";  
		
		int arr[]=new int[salaryText.size()];
		
		//find age of correspondent salary
		for(WebElement element:salaryText) {	
			keySalary=element.getText();
			String value=driver.findElement(By.xpath("//table[@id='example']//tr/td[6][text() ='"+keySalary+"']/preceding-sibling::td[2]")).getText();
			hm.put(keySalary, value);
		}
		
		//ieterate HashMap to convert string into in for sorting
		Set<String> key=hm.keySet();
		
		int index=0;
		for(String sal:key) {
			if(index<arr.length) {
				
				//store int value 
				int temp=Integer.parseInt(sal.substring(1).replace(",", ""));
				arr[index]=temp;
				index++;
			}
		}
		
		//sort to get minimum salary
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		//format salary to string as $ and commas to find in hashMap
		String targetSalary=String.format("%,d", arr[0]);
		System.out.println(hm.get("$"+targetSalary));
	}
}

