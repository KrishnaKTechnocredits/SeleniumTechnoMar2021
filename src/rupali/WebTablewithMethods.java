package rupali;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Notes & Assignment : 15th Jun'2021


	Test case : 7
	rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".


 */
public class WebTablewithMethods {
	
	static ArrayList<String> getColList(WebDriver driver){
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		for(WebElement element : headElementList){
			headerList.add(element.getText());
		}
		return headerList;
	} 

	static String getEmpDataByName(WebDriver driver,String name, int index){
		return driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td[index]")).getText();
	}

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		ArrayList<String> headerList = getColList(driver);
		int index = headerList.indexOf("Last Name") + 1;
		getEmpDataByName(driver,"Abhishek",index);
	}


}
