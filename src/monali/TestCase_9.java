package monali;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_9 {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		verifyUserName(driver);
		
	}
	
	static void verifyUserName(WebDriver driver) {
		
		ArrayList<String> fName = new ArrayList<String>();
		ArrayList<String> lName = new ArrayList<String>();

		List<WebElement> fNameList = driver.findElements(By.xpath("//table[@id = 'table1']//tbody/tr/td[2]"));
		for(WebElement list :fNameList ) {
			fName.add(list.getText());
		}
		List<WebElement> lNameList = driver.findElements(By.xpath("//table[@id = 'table1']//tr/td[3]"));
		for(WebElement list : lNameList ) {
			lName.add(list.getText());
		}

		List<WebElement> uNameList = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr/td[4]"));
		ArrayList<String> actualUserName = new ArrayList<String>();
		for( WebElement list: uNameList) {
			actualUserName.add(list.getText());
		}
		ArrayList<String> expectedUName = new ArrayList<String>();
		for(int index = 0; index<fName.size();index++) {
			expectedUName.add(creatUserName(fName.get(index).toLowerCase(),lName.get(index)));
		}
		
		for(int index = 0;index<actualUserName.size();index++) {
			if(expectedUName.equals(actualUserName))
				System.out.println(expectedUName.get(index) +" is equal to " +actualUserName.get(index));
			else
				System.out.println(expectedUName.get(index) +" is not equal to "+actualUserName.get(index));
}
		
	}
	
	static String creatUserName(String fName,String lName) {
		String uName = " ";
		uName = fName.charAt(0)+lName.toLowerCase();
		return uName;
	}

}
