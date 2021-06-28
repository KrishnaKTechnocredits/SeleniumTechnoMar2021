package shilpa.Assignment_1_10;

/*TC-6_4 - Find all Employees who hold Position as Software Engineer.*/
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC6_4_EmpAsSWEngineer {
	void getEmpAsSWEngineer() {
		WebDriver driver = new LaunchBrowser().start("https://datatables.net/");
		int size = driver.findElements(By.xpath("//span//a[@aria-controls='example']")).size();
		System.out.println("STEP - Find all Employees who hold Position as Software Engineer \n ");
		for (int index = 1; index <= size; index++) {
			driver.findElement(By.xpath("//span//a[@aria-controls='example'][" + index + "]")).click();
			List<WebElement> list = driver
					.findElements(By.xpath("//td[text()='Software Engineer']//parent::tr[1]//td"));
			for (WebElement e : list) {
				System.out.println(e.getText());
			}
		}
		System.out.println("STEP - Close the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new TC6_4_EmpAsSWEngineer().getEmpAsSWEngineer();
	}
}
