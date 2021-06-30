package surabhi.demoTableSite;

//column count of all link's table

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


//1. How many total entries are there in table?
public class TestCase2 extends BaseClass{
	
	@Test
	public void runTestCase() {
		List<WebElement>element=driver.findElements(By.xpath("//table[@id='example']/tbody//td[1]"));
		
		//element.size() total column of table in webUI
		
		List<WebElement> pagecounter=driver.findElements(By.xpath("//div[@id='example_paginate']//span/a"));
		
		//total pages where table resides are 6
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(WebElement el1:pagecounter) {
			arr.add(Integer.parseInt(el1.getText()));
		}
		
		//total count of columns in each table of pages(a tags) except last page as it may have less number of columns
		int count=(arr.size()-1)*(element.size());
		System.out.println(count);
		
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='example_paginate']//a[text()='6']"))).click();
		
		List<WebElement> lastPageTableCount=driver.findElements(By.xpath("//table[@id='example']/tbody//td[1]"));
		
		System.out.println(lastPageTableCount.size());
		System.out.println(count+lastPageTableCount.size());	
	}

}
