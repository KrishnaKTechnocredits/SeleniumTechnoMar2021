package monika.TC2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.PredefinedActions;
import monika.TestBase.TestBase;

/*Test - 2

1. Launch a chrome
2. Open Google.com
3. Get page title name and verify with expected title
4. navigate to automationbykrishna.com
5. Get page title name and verify with expected title
6. navigate back in history
7. Get page title name and verify with expected title [google]
8. navigate forward in the history
9. Get page title name and verify with expected title [automationbykrishna]
10. refresh the page and verify the expected title [automationbykrishna]
11. Close the browser.*/
public class TestCase2_NavigationCmds {
	
	private static SoftAssert softassert = new SoftAssert();
	private static WebDriver driver;
	@Test
	static void verifyTitles() {
		 driver = PredefinedActions.start();
		
		String url1 = "http://google.com";
		String url2 = "http://automationbykrishna.com";

		System.out.println("STEP : Hit the browser ");
		driver.get(url1);

		System.out.println("STEP: Verify the title of the 1st url");
		String googleTitleExp = "Google";
		String googleTitle = driver.getTitle();
		/*if (googleTitleExp.equals(googleTitle))
			System.out.println("Google title is same");
		else
			System.out.println("Google title is different");*/
		
		//Assert.assertEquals(googleTitle, googleTitleExp);
		softassert.assertEquals(googleTitle, googleTitleExp);
		

		System.out.println("STEP: Verify the title of the 2nd Url");
		String krishnaTitleExp = "Login Signup Demo";
		//Going to 2nd url
		driver.navigate().to(url2);
		String krishanTitle = driver.getTitle();
		/*if (krishnaTitleExp.equals(krishanTitle))
			System.out.println("TechnoCredits title is same");
		else
			System.out.println("TechnoCredits title is different");*/
		
		//Assert.assertEquals(krishanTitle, krishnaTitleExp);
		softassert.assertEquals(krishanTitle, krishnaTitleExp);

		//Moving back in history
		System.out.println("STEP: Moving back in history");
		driver.navigate().back();
		String googleTitleBack = driver.getTitle();
		if (googleTitleExp.equals(googleTitleBack))
			System.out.println("Google title is same");
		else
			System.out.println("Google title is different");
		
		//Assert.assertEquals(googleTitleBack, googleTitleExp);
		
		softassert.assertEquals(googleTitleBack, googleTitleExp);

		//Moving forward in history
		System.out.println("STEP: Moving forward  in history");
		driver.navigate().forward();
		String krishnaTitleForward = driver.getTitle();
		/*if (krishnaTitleExp.equals(krishnaTitleForward))
			System.out.println("TechnoCredits title is same");
		else
			System.out.println("TechnoCredits title is different");
*/

		//Assert.assertEquals(krishnaTitleExp, krishnaTitleForward);
		TestBase.softAssert().assertEquals(krishnaTitleForward, krishnaTitleExp);
		
		System.out.println("STEP: Refresh the page");
		driver.navigate().refresh();
		String krishnaTitleRefresh = driver.getTitle();

		//Assert.assertEquals(krishnaTitleExp, krishnaTitleRefresh);
		softassert.assertEquals(krishnaTitleRefresh, krishnaTitleExp);
		
		
		/*if (krishnaTitleExp.equals(krishnaTitleRefresh))
			System.out.println("TechnoCredits title is same");
		else
			System.out.println("TechnoCredits title is different");*/
		
		softassert.assertAll();
		driver.close();
	}

	/*public static void main(String[] args) {
		verifyTitles("http://google.com","http://automationbykrishna.com");
	}
*/
}
