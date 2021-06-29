package pallavi.assignment_8;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test case : 8
Return a map of empId and empName*/
public class TestCase8 {

	static HashMap<String,String> empDataMap(WebDriver driver){

		int size=driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		HashMap<String,String> hm=new HashMap<String,String>();
		for(int index=1;index<=size;index++){
			String empId=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr [" +index +"]/td[2]")).getText();
			String empName=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+index+"]/td[3]")).getText();
			hm.put(empId, empName);
		}
		return hm;
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("demotable")).click();;
	
			
		HashMap<String,String> listOfemployee=empDataMap(driver);
		System.out.println(listOfemployee);
		driver.close();
		
	}

}
