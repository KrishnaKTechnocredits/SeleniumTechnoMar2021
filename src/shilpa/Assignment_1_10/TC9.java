package shilpa.Assignment_1_10;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/*Test case : 9
verify username from table "EMPLOYEE BASIC INFORMATION"

firstName
lastName
expectedUsername = "mkanani";
actualUserName = firstName.charAt(0) + lastName;
actualUserName = actualUserName.toLowerCase();*/
public class TC9 {
	void getUserName() {
		WebDriver driver=new LaunchBrowser().start("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		int size = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		String fname = "";
		String lname = "";
		String actualUserName = "";
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		String[] expectedUserNames = { "mkanani", "kkanani", "dboda", "asharma", "ppatro" };
		System.out.println("STEP - Compare expected and actual user name for all Employees");
		for (int index = 1; index < size; index++) {
			fname = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[2]")).getText();
			lname = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[3]")).getText();
			actualUserName = fname.charAt(0) + lname;
			actualUserName = actualUserName.toLowerCase();
			if (actualUserName.equals(expectedUserNames[index - 1])) {
				System.out.println(fname + "  " + lname + "  " + actualUserName);
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
				System.out.println(fname + "  " + lname + "  " + actualUserName);
			}

		}
		System.out.println("STEP - close browser");
		driver.close();
	}

	public static void main(String[] args) {
		new TC9().getUserName();
	}

}
