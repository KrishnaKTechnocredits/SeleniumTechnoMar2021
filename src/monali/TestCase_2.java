package monali;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url1 = "https://www.google.com/";
		driver.get(url1);
		String ActualpageTitle = driver.getTitle();
		
		driver.navigate().to("http://automationbykrishna.com");
		String ActualAkTitle = driver.getTitle();
		if(ActualpageTitle.equals(ActualAkTitle)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
		driver.navigate().back();
		driver.getTitle();
		System.out.println(ActualpageTitle);
		
		driver.navigate().forward();
		driver.getTitle();
		System.out.println(ActualAkTitle);
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.getTitle();
		System.out.println(ActualAkTitle);
		
		driver.close();
	}
}
