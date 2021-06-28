package shilpa.Assignment_1_10;

/*TC-3_5 - Count number of Employee with age More than 25, on first page.*/
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC6_5_AgeMoreThan25 {
	void getEmpWithSepcifiedAge(int age) {
		WebDriver driver = new LaunchBrowser().start("https://datatables.net/");
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']//td[4]"));
		int count = 0;
		System.out.println("STEP - get employee with age more than 25");
		for (WebElement w : list) {
			if (Integer.parseInt(w.getText()) > age) {
				count++;
			}

		}
		System.out.println("Number of Employees with age more than 25 are:- " + count);
		System.out.println("STEP - close browser");
		driver.close();
	}

	public static void main(String[] args) {
		new TC6_5_AgeMoreThan25().getEmpWithSepcifiedAge(25);
	}
}
