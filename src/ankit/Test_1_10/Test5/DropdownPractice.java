package ankit.Test_1_10.Test5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//select[@class='form-control']")));

		WebElement multipleSelectDD = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectDD = new Select(multipleSelectDD);
		System.out.println("FIRST PS - COunt of Options*****");
		System.out.println("Count of Options :"+selectDD.getOptions().size());

		System.out.println("SECOND and THIRD PS - Select option 2 & 3 & 4 and find selected count and display them *****");
		selectDD.selectByVisibleText("2");
		selectDD.selectByVisibleText("3");
		selectDD.selectByVisibleText("4");

		List<WebElement> selectedWEList = selectDD.getAllSelectedOptions();
		System.out.println("Total Selected Options : "+selectedWEList.size());
		for(WebElement we : selectedWEList) 
			System.out.println("Selected Options Value : "+we.getText());

		System.out.println("FORTH PS - Deselect option  3 *****");
		selectDD.deselectByVisibleText("3");
		if(!driver.findElement(By.xpath("//select[@class='form-control']//option[3]")).isSelected()) 
			System.out.println("Option 3 deselected Succesfully");
		else
			System.out.println("Option 3 is still selected");
		System.out.println("FIFTH PS - Get First selected Option****");
		System.out.println("First Selected Option : "+selectDD.getAllSelectedOptions().get(0).getText());

		String lastSelected = "";
		for(WebElement we : selectedWEList) {
			lastSelected = we.getText();
		}

		System.out.println("Last Selected Option :"+lastSelected);

		System.out.println("SIXTH PS - Select All divisible by 2 ******");
		List<WebElement> listAllOptions = selectDD.getOptions();
		selectDD.deselectAll();
		for(WebElement weListItem : listAllOptions) {

			if(Integer.valueOf(weListItem.getText()) % 2 == 0) {
				selectDD.selectByVisibleText(weListItem.getText());

			}
			System.out.println(weListItem.getText() +" Selected Status :"+weListItem.isSelected());	
		}

		System.out.println("SEVENTH PS - Get all selected unselected and unselecetd Selected******");
		List<WebElement> allSelectedList = selectDD.getAllSelectedOptions();
		listAllOptions.removeAll(allSelectedList);
		selectDD.deselectAll();
		for(WebElement we : listAllOptions) {
			selectDD.selectByVisibleText(we.getText());
			//System.out.println(we.getText() +" Selected Status :"+we.isSelected());	
		}
		List<WebElement> finalList = selectDD.getOptions();
		for(WebElement fWE : finalList) {
			System.out.println(fWE.getText() +" Selected Status :"+fWE.isSelected());	
		}

		System.out.println("EIGHTH PS - Select Second Last******");
		selectDD.selectByIndex(finalList.size()-2);
		System.out.println(finalList.get(finalList.size()-2).getText()+ " Selected status : " +finalList.get(finalList.size()-2).isSelected());
		Thread.sleep(2000);
		driver.close();
	}
}
