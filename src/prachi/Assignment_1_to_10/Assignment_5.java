package prachi.Assignment_1_to_10;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment_5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//select[@class='form-control']")));

		WebElement multipleSelectDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectDropDown = new Select(multipleSelectDropDown);
		System.out.println("1st - Count of Options");
		System.out.println("Count of Options :"+selectDropDown.getOptions().size());
		
		System.out.println("------------------------------------------------");
		System.out.println("2nd &3rd - Select option 2 & 3 & 4 and find selected count and display them");
		selectDropDown.selectByVisibleText("2");
		selectDropDown.selectByVisibleText("3");
		selectDropDown.selectByVisibleText("4");

		List<WebElement> selectedWEList = selectDropDown.getAllSelectedOptions();
		System.out.println("------------------------------------------------");
		System.out.println("Total Selected Options : "+selectedWEList.size());
		for(WebElement we : selectedWEList) 
			System.out.println("Selected Options Value : "+we.getText());
		
		System.out.println("------------------------------------------------");
		System.out.println("4th - Deselect option  3");
		selectDropDown.deselectByVisibleText("3");
		if(!driver.findElement(By.xpath("//select[@class='form-control']//option[3]")).isSelected()) 
			System.out.println("Option 3 deselected Succesfully");
		else
			System.out.println("Option 3 is still selected");
		System.out.println("5th - Get First selected Option");
		System.out.println("First Selected Option : "+selectDropDown.getAllSelectedOptions().get(0).getText());

		String lastSelected = "";
		for(WebElement we : selectedWEList) {
			lastSelected = we.getText();
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("Last Selected Option :"+lastSelected);
		System.out.println("6th - Select All divisible by 2");
		List<WebElement> listAllOptions = selectDropDown.getOptions();
		selectDropDown.deselectAll();
		for(WebElement weListItem : listAllOptions) {

			if(Integer.valueOf(weListItem.getText()) % 2 == 0) {
				selectDropDown.selectByVisibleText(weListItem.getText());
			}
			System.out.println(weListItem.getText() +" Selected Status :"+weListItem.isSelected());	
		}

		System.out.println("------------------------------------------------");
		System.out.println("7th - Get all selected unselected and unselecetd Selected");
		List<WebElement> allSelectedList = selectDropDown.getAllSelectedOptions();
		listAllOptions.removeAll(allSelectedList);
		selectDropDown.deselectAll();
		for(WebElement we : listAllOptions) {
			selectDropDown.selectByVisibleText(we.getText());
			//System.out.println(we.getText() +" Selected Status :"+we.isSelected());	
		}
		List<WebElement> finalList = selectDropDown.getOptions();
		for(WebElement fWE : finalList) {
			System.out.println(fWE.getText() +" Selected Status :"+fWE.isSelected());	
		}

		System.out.println("------------------------------------------------");
		System.out.println("8th - Select Second Last");
		selectDropDown.selectByIndex(finalList.size()-2);
		System.out.println(finalList.get(finalList.size()-2).getText()+ " Selected status : " +finalList.get(finalList.size()-2).isSelected());
		Thread.sleep(2000);
		driver.close();
	}
}
