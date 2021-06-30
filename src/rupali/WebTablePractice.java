package rupali;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class WebTablePractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		
		//1.How many entries are there in table?
		String text=driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] textarr=text.split("of");
		System.out.println("Total entries in table are"+textarr[1].replace(" entries",""));
		
		//2.On dynamic table check age of employee  'caeser vance' --write dynamic x-path print age
		String empname="Caesar Vance";
		WebElement element=driver.findElement(By.xpath("//table[@id='example']//tbody/tr/td[text()='"+empname+"']//following-sibling::td[3]"));
		String str=element.getText();
		System.out.println(str);
		
		//3. Print Employee First Name of all employees working from London Office.
		List<WebElement> empNameLondonList = driver.findElements(By.xpath("//table[@id='example']//tr//td[text()='London']//ancestor::tr//td[1]")); 
		for(WebElement empLondon :empNameLondonList ) {
			System.out.println(empLondon.getText()+" Lives in London");
		}
		
		//4. Find all Employees who hold Position as Software Engineer.
		List<WebElement> empSoftwareEnggList = driver.findElements(By.xpath("//table[@id='example']//tr//td[text()='Software Engineer']//ancestor::tr//td[1]")); 
		for(WebElement empSE :empSoftwareEnggList ) {
			System.out.println(empSE.getText()+"is a Software Engineer");
		}
		
		//5. Count number of Employee with age More than 25, on first page.
		List<WebElement> empaboveage25=driver.findElements(By.xpath("//table[@id='example']/tbody/tr//td[4][text()>25]"));
		System.out.println(empaboveage25.size());
		
		//6. Print Employee Start date whose age is 66.
		WebElement empstartdate = driver.findElement(By.xpath("//table[@id='example']//tr//td[4][text()=66]//following-sibling::td[1]")); 
		String str1=empstartdate.getText();
		System.out.println(str1);
		
		//7. Print employee Age whose salary is minimum. 
		/*List<WebElement> ageList= driver.findElements(By.xpath("//table[@id='example']//tr/td[4]"));
		ageList.sort(new Age_Comparator());
		ageList.get(0).getText();
		System.out.println("Salary Whose Age is Min :"+driver.findElement(By.xpath("//table[@id='example']//tr/td[text()='"+ageList.get(0).getText()+"']//following-sibling::td[2]")).getText());
		*/
		
		//8. How many rows in Table on first page.
		System.out.println("No of records in table :"+driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());
		
		//9. Print all text in table. - on automation by Krishna 
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(2000);
		List<WebElement> element3=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr//following::tr"));
		for(WebElement el:element3) {
		System.out.println(el.getText());
		}
	}
}
