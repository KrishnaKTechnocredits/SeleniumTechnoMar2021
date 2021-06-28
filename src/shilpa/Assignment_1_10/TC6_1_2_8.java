package shilpa.Assignment_1_10;

/*TC-6
Problem Statements :
1. How many total entries are there in table?
2. check age of Employee "Caesar Vance" - write Dynamic Xpath - Print Age
8. How many rows in Table on first page.*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TC6_1_2_8 {

	void GetALlEntriesFrmTbl() {
		WebDriver driver = new LaunchBrowser().start("https://datatables.net/");

		System.out.println("STEP - check age of Employee ' Caesar Vance' ");
		String age = driver
				.findElement(By.xpath("//table[@id='example']//td[text()='Caesar Vance']//following-sibling::td[3]"))
				.getText();
		System.out.println("Age of Caesar Vance is " + age);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div[@id='example_info']")));
		String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arr = text.split("of");
		String temp = arr[1].trim().replace(" entries", "");
		Integer.parseInt(temp);
		System.out.println("Total Entries in a Table:- " + temp);
		System.out.println("Rows in table on first page:- "
				+ driver.findElements(By.xpath("//table[@id='example']//tbody//tr")).size());
		driver.close();

	}

	public static void main(String[] args) {
		new TC6_1_2_8().GetALlEntriesFrmTbl();
	}
}
