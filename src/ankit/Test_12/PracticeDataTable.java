package ankit.Test_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeDataTable {

	private static WebDriver driver;
	static WebDriverWait wait;

	public static void setUp(String URL) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']")));
	}
	private static int getPaginationCount(WebDriver driver){
		return driver.findElements(By.xpath("//a[contains(@class,'paginate_button ')][@tabindex='0']")).size();
	}

	private static int getAllRowCounts(WebDriver driver) {
		int countOfPages = getPaginationCount(driver);
		int totalRecordCount = 0;
		for(int pageIndex = 1 ; pageIndex < countOfPages ; pageIndex++) {
			driver.findElement(By.xpath("//a[contains(@class,'paginate_button ')][@tabindex='0'][text()='"+pageIndex+"']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']")));
			int currentPageCount = driver.findElements(By.xpath("//table[@id='example']//tbody/tr")).size();
			totalRecordCount = totalRecordCount + currentPageCount;
		}
		return totalRecordCount;
	}
	public static void tearDown(WebDriver driver) {
		driver.close();
	}

	public static HashSet<String> getNumberOfOfficeLocation(WebDriver driver){
		HashSet<String> officeLocHS = new HashSet<String>();
		int countOfPages = getPaginationCount(driver);
		for(int pageIndex = 1 ; pageIndex < countOfPages ; pageIndex++) {
			driver.findElement(By.xpath("//a[contains(@class,'paginate_button ')][@tabindex='0'][text()='"+pageIndex+"']")).click();
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for(int rowIndex = 1; rowIndex <= rowCount ; rowIndex++) {
				String city = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rowIndex+"]/td[3]")).getText();
				officeLocHS.add(city);
			}				
		}	
		return officeLocHS;
	}

	public static void validateSorting(WebDriver driver) throws InterruptedException {
		int countOfPages = getPaginationCount(driver);
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[text()='Name']")).click();
		//TreeSet <String> defaultOrderListAllTS = new TreeSet<String>();
		LinkedHashSet <String> defaultOrderListAllTS = new LinkedHashSet<String>();// pass treeSet to array list
		
		for(int pageIndex = 1 ; pageIndex < countOfPages ; pageIndex++) {
			driver.findElement(By.xpath("//a[contains(@class,'paginate_button ')][@tabindex='0'][text()='"+pageIndex+"']")).click();
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for(int rowIndex = 1; rowIndex <= rowCount ; rowIndex++) {
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rowIndex+"]/td[2]")).getText();
				defaultOrderListAllTS.add(position);
			}
		}
		List<String> defaultOrderListAllTSAL = new ArrayList<String>(defaultOrderListAllTS);
		//defaultOrderListAllTSAL.addAll();
		System.out.println(defaultOrderListAllTSAL);
		
		driver.navigate().refresh();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[text()='Position']")).click();
		Thread.sleep(3000);
		LinkedHashSet <String> sortedOrderListALL = new LinkedHashSet<String>();
		
		for(int pageIndex = 1 ; pageIndex < countOfPages ; pageIndex++) {
			driver.findElement(By.xpath("//a[contains(@class,'paginate_button ')][@tabindex='0'][text()='"+pageIndex+"']")).click();
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for(int rowIndex = 1; rowIndex <= rowCount ; rowIndex++) {
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rowIndex+"]/td[2]")).getText();
				sortedOrderListALL.add(position);
			}
		}
		List<String> sortedOrderListALLAL = new ArrayList<String>(sortedOrderListALL);
		//sortedOrderListALLAL.addAll(sortedOrderListALL);
		System.out.println(sortedOrderListALLAL);
		
		//comparision logic - comparing different collections
		//System.out.println(defaultOrderListAllTS.equals(sortedOrderListALL));
		Iterator<String> itr = defaultOrderListAllTS.iterator();
		for(String item: sortedOrderListALL) {
			String nextItem = itr.next();
			if(item.equals(nextItem)) {
				System.out.println(item+ " : "+nextItem +" PASS");	
			}
			else {
				System.out.println(item+ " : "+nextItem +" FAIL");
			}	
		}
		
		//comparision when TS and LHS ---> Array List 
		System.out.println("Match Result :"+sortedOrderListALLAL.equals(defaultOrderListAllTSAL));
	}
	
	public static void main(String[] args) throws InterruptedException {
		setUp("https://datatables.net/");
		System.out.println("Total rows in Table : "+getAllRowCounts(driver));
		System.out.println("Total Office Locations :"+getNumberOfOfficeLocation(driver));
		validateSorting(driver);
		tearDown(driver);
	}
}
