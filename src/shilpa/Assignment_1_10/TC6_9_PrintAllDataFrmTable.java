package shilpa.Assignment_1_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*TC-6
Problem Statements :
9. Print all text in table
Reference URL
https://datatables.net/*/

public class TC6_9_PrintAllDataFrmTable {
	void totalEntriesinTbl() {
		WebDriver driver = new LaunchBrowser().start("https://datatables.net/");
		int size = driver.findElements(By.xpath("//span//a[@aria-controls='example']")).size();
		for (int index = 1; index <= size; index++) {
			driver.findElement(By.xpath("//span//a[@aria-controls='example'][" + index + "]")).click();
			System.out.println(driver.findElement(By.xpath("//table[@id='example']")).getText());
		}

		driver.close();
	}

	public static void main(String[] args) {
		new TC6_9_PrintAllDataFrmTable().totalEntriesinTbl();

	}

}
