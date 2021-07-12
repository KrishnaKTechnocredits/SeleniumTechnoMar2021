package monika.TC17_Hover;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Autocomplee {
	private WebDriver driver ;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("web.chrome.driver", ".//Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		//driver.findElement(By.xpath("//input[@title = 'Search']"))
		driver.manage().window().maximize();
	}
	
	@Test
	public void autoComplete() throws InterruptedException {
		
		driver.findElement(By.cssSelector("input#gosuggest_inputSrc")).sendKeys("Jamm");
		Thread.sleep(5000);
		List<WebElement> element = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']/li/div//div[2]/div[@class='mainTxt clearfix']/span[1]"));
		System.out.println(element.size());
		String exp = "Jammu";
		Thread.sleep(5000);
		for(WebElement e :element) {
			if(e.getText().contains(exp)) {
			System.out.println(e.getText());
				e.click();
			break;
			}
		}
		String expText = "Jammu (IXJ)";
		String actualText = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).getAttribute("value");
		Assert.assertEquals(actualText, expText);
		System.out.println("Pass");
		driver.close();
	}

}
