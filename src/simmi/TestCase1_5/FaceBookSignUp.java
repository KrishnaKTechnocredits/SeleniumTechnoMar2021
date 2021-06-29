package simmi.TestCase1_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookSignUp {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://en-gb.facebook.com/";

		driver.get(url);
		driver.manage().window().maximize();

		Thread.sleep(2000);
		System.out.println("");
		System.out.println("STEP 1 - Open Signup page");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		Thread.sleep(2000);
		System.out.println("");
		System.out.println("STEP 2- Enter first name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Simmi");

		System.out.println("");
		System.out.println("STEP 3- Enter last name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Singh");

		System.out.println("");
		System.out.println("STEP 4- Enter email ID");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("217simmisingh@gmail.com");

		System.out.println("");
		System.out.println("STEP 4- Enter the password");
		String password = "Simmi217";
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(password);

		System.out.println("");
		System.out.println("STEP 4- Enter the birthdate");

		WebElement birthdate = driver.findElement(By.xpath("//select[@id='day']"));
		Select birthdateElement = new Select(birthdate);
		birthdateElement.selectByValue("27");

		System.out.println("");
		System.out.println("STEP 5- Enter the birthmonth");

		Thread.sleep(2000);
		WebElement birthmonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select birthmonthElement = new Select(birthmonth);
		birthmonthElement.selectByValue("7");

		System.out.println("");
		System.out.println("STEP 5- Enter the birthyear");

		WebElement birthyear = driver.findElement(By.xpath("//select[@id='year']"));
		Select birthyearElement = new Select(birthyear);
		birthyearElement.selectByValue("1995");

		driver.close();

	}
}
