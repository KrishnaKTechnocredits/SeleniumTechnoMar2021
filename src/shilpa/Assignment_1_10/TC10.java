//TC10-Name -> "Maulik", print lastName and UserName

package shilpa.Assignment_1_10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Name -> "Maulik", print lastName and UserName*/
public class TC10 {
	void getLnameAndUnameForLoop(String name) {
		WebDriver driver = new LaunchBrowser().start("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		int size = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		System.out.println("STEP - Get last name and user name for given first name");
		for (int index = 1; index < size; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();

			if (firstName.equals(name)) {
				String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
						.getText();

				String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
						.getText();
				System.out.println("Last Name:- " + lName + "  " + "UserName:- " + userName);
			}
		}
		System.out.println("STEP - Close Browser");
		driver.close();
	}

	public static void main(String[] args) {
		new TC10().getLnameAndUnameForLoop("Maulik");
	}

}
