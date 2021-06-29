package shilpa.Assignment_1_10;

//TC6_6.Print Employee Start date whose age is 66.
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC6_6_PrintStartDate {
	void getStartDate(int age) {
		WebDriver driver = new LaunchBrowser().start("https://datatables.net/");
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']//td[4]"));
		System.out.println("STEP - Print Employee Start date whose age is 66");
		int index = 0;
		for (WebElement w : list) {
			index++;
			if (Integer.parseInt(w.getText()) == age) {
				System.out.println(driver
						.findElement(By.xpath("//table[@id='example']//tbody//tr[" + index + "]//td[5]")).getText());
			}
		}
		System.out.println("STEP - close browser");
		driver.close();
	}

	public static void main(String[] args) {
		new TC6_6_PrintStartDate().getStartDate(66);
	}
}
