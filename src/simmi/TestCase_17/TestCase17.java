package simmi.TestCase_17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Test Case 17: 
Today's assignment (25/6/2021)
www.flipcart.com
1. Hover on Fashion icon
2. Hover on the first  item>> count the number of elements display on hovering.
*/

public class TestCase17 {

	@Test
	static ArrayList<String> getElement(WebDriver driver) {
		WebElement target = driver.findElement(By.xpath("//img[@alt='Fashion']"));

		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();

		List<WebElement> e = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		int count = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a")).size();
		Assert.assertEquals(count, 11);
		System.out.println("Total numbers of Elements after 1st hover on Fashion is " + count);

		Assert.assertEquals(driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a")).size(), 11);
		ArrayList<String> output = new ArrayList<String>();

		for (WebElement elementList : e) {
			if (e.size() <= 11) {
				output.add(elementList.getText());
			}
		}

		return output;
	}

	@Test
	static ArrayList<String> getMensSectionElement(WebDriver driver) {
		WebElement target = driver.findElement(By.xpath("//img[@alt='Fashion']"));

		WebElement target1 = driver.findElement(
				By.xpath("//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E']//div/a[@class='_6WOcW9 _2-k99T']"));
		Actions action = new Actions(driver);
		action.moveToElement(target).moveToElement(target1).build().perform();

		List<WebElement> e = driver
				.findElements(By.xpath("//span[@class='xtXmba']/following-sibling::a"));
		int count = driver
				.findElements(By.xpath("//span[@class='xtXmba']/following-sibling::a")).size();
		Assert.assertEquals(count, 11);
		System.out.println("Total numbers of Elements after 2nd hover on Men's Fashion is " + count);
		ArrayList<String> output = new ArrayList<String>();

		for (WebElement elementList : e) {
			if (e.size() <= 11) {
				output.add(elementList.getText());
			}
		}
		return output;
	}

	@Test
	public void operation() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		ArrayList<String> output = getElement(driver);
		System.out.println("Total Element after first hover in Fashion is " + output);

		ArrayList<String> output1 = getMensSectionElement(driver);
		System.out.println("Total Element after Second hover inside Fashion is " + output1);

		driver.close();
	}
}
