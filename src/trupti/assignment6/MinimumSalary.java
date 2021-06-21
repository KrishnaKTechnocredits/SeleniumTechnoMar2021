package trupti.assignment6;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinimumSalary {

	static int getNumber(String str) {
		int output = 0;
		String tempStr = "";
		
		for(int index = 0; index < str.length(); index ++) {
			char ch = str.charAt(index);
			int ascii = ch;
			if(ascii>=48 && ascii<=57) {
				tempStr = tempStr + String.valueOf(ch);
			}
		}
		output = Integer.parseInt(tempStr);
		return output;
	}
	
	static int findMinimumIndex(ArrayList<Integer> salaryList) {
		int output = 0;
		int min = salaryList.get(0);
		for(int index = 1; index < salaryList.size(); index++) {
			if(min > salaryList.get(index)) {
				min = salaryList.get(index);
				output = index;
			}
		}
		return output;	
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
		WebElement element=driver.findElement(By.xpath("//table[@id='example']//tfoot/tr/th[1]"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		List<WebElement> elements=driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[6]"));
		ArrayList<Integer> salaryList = new ArrayList<Integer>();
		for(WebElement e : elements) {
			salaryList.add(getNumber(e.getText()));
		}
		
		int index = findMinimumIndex(salaryList);
		String minSalary = elements.get(index).getText();
		WebElement minSalaryElement = driver.findElement(By.xpath("//table[@id='example']//td[text()='"+minSalary+"']//parent::tr/td[4]" ));
		System.out.println(minSalaryElement.getText());
		driver.close();

	}

}
