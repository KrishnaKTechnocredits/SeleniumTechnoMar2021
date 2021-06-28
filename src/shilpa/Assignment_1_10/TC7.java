package shilpa.Assignment_1_10;
/*Test case : 7
rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC7 {
	void getLNameOfEmp(String name) {
		WebDriver driver=new LaunchBrowser().start("http://automationbykrishna.com/");
		
		
		driver.findElement(By.id("demotable")).click();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		ArrayList<String> headerList = new ArrayList<String>();
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']//th"));
		for(WebElement element : list) {
			headerList.add(element.getText());
		}
		int index1=headerList.indexOf("Last Name")+1;
		System.out.println("Last Name - "+driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr//td["+index1+"]")).getText());
		driver.close();
}
	
	public static void main(String[] args) {
		new TC7().getLNameOfEmp("Abhishek");
	}
		
}
