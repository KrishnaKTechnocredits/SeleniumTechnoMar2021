package radha.Assigmnent_1_12_withoutTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class FindingTotalEntries_TestCase6 {
	
	int getTotalEntriesInTable(WebDriver driver){
		int sumOfEntries=0;
		List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		sumOfEntries+=rows1.size();
		driver.findElement(By.xpath("//a[text()='2']")).click();
		List<WebElement> rows2 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		sumOfEntries+=rows2.size();
		driver.findElement(By.xpath("//a[text()='3']")).click();
		List<WebElement> rows3 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		sumOfEntries+=rows3.size();
		driver.findElement(By.xpath("//a[text()='4']")).click();
		List<WebElement> rows4 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		sumOfEntries+=rows4.size();
		driver.findElement(By.xpath("//a[text()='5']")).click();
		List<WebElement> rows5 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		sumOfEntries+=rows5.size();
		driver.findElement(By.xpath("//a[text()='6']")).click();
		List<WebElement> rows6 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		sumOfEntries+=rows6.size();
		return sumOfEntries;
	}
	
	int getEntriesUsingLabelText(WebDriver driver) {
		String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arrText = text.split("of ");
		int sum = Integer.parseInt(arrText[1].replace(" entries", ""));
		return sum;
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		FindingTotalEntries_TestCase6 table = new FindingTotalEntries_TestCase6();
		int totalEntries = table.getTotalEntriesInTable(driver);
		System.out.println("Total entries in the web table using pagination are :"+totalEntries);
		int totalTableEntires = table.getEntriesUsingLabelText(driver);
		System.out.println("Total Entries in the web table using label Text are :"+totalTableEntires);
		System.out.println("Closing browser...");
		driver.close();
	}

}
