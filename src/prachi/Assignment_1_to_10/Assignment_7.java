package prachi.Assignment_1_to_10;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test case : 7
rows and cols are dynamic, get the lastname of the emp whoesfirstname is "Abhishek".


ArrayList<String>getColList(WebDriver driver){
	ArrayList<String>headerList = new ArrayList<String>();
	List<WebElement>headElementList = driver.findElements(By.xpath(""));
	for(WebElement element : headElementList){
		headerList.add(element.getText());
	}
	return headerList;
} 

String getEmpDataByName(WebDriver driver,String name, int index){
	return driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td[index]")).getText();
}

main(){
	ArrayList<String>headerList = getColList(driver);
	int index = headerList.indexOf("Last Name") + 1;
	getEmpDataByName(driver,"Abhishek",index);
}
 */

public class Assignment_7 {

	void getLastName(String name) {
		WebDriver driver;
		driver = base.PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> listHeader = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement colHeading : listHeader) {
			headerList.add(colHeading.getText());
		}
		int index = 0;
		System.out.println("STEP-Getting column num of Last Name");
		for (String header : headerList) {
			if (header.equals("Last Name")) {
				index = headerList.indexOf(header);
				index++;
				break;
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		System.out.println("STEP - Getting Last Name of "+name);
		String lastName = driver
				.findElement(By.xpath(
						"//table[@id='table1']/tbody/tr/td[text()='" + name + "']//parent::tr/td[" + index + "]"))
				.getText();
		System.out.println("Last Name of " + name + " is " + lastName);
		driver.close();
	}

	public static void main(String[] args) {
		Assignment_7 ass7=new Assignment_7();
		ass7.getLastName("Abhishek");
	}
}
