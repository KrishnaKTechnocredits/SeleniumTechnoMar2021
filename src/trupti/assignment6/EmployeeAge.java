package trupti.assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeAge {
	
		static ArrayList <String> getColList(WebDriver driver){
			ArrayList<String>headerList=new ArrayList<String>();
			List<WebElement>headElementList=driver.findElements(By.xpath("//table[@id='example']/thead/tr/th"));
			for(WebElement element:headElementList) {
				headerList.add(element.getText());
			}
			return headerList;
		}
		
		static String getEmpDataByName(WebDriver driver,String name,int index) {
			return driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
			
		}

	public static void main(String[] args) {
		System.out.println("Step 1 - Launch a chrome");
		System.setProperty("webdriver.chrome.driver", "..\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step 2 - Open Focus.html ");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']")));
		WebElement element=driver.findElement(By.xpath("//td[text()='Caesar Vance']//following-sibling::td[3]"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		ArrayList<String> headerList = getColList(driver);
		int index = headerList.indexOf("Age") + 1;
		String name = "Caesar Vance";
		String output=getEmpDataByName(driver,name,index);
		System.out.println("Age of "+name+" is " +output);
		driver.close();

	}

}
