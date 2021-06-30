package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Navigate_TestCase2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch chrome.");
		System.out.println("Step2 - Open Google.com");
		WebDriver driver = PredefinedActions.start("https://www.google.com/");
		System.out.println("Step3 - Get page title name and verify with expected title");
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		System.out.println("Step3 - page title " + actualTitle);
		if(expectedTitle.equals(actualTitle))
			System.out.println("Title of the page "+expectedTitle+" is as expected.");
		else
			System.out.println("Title is incorrect. Should be "+expectedTitle);
		System.out.println("Step4 - navigate to automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");
		System.out.println("Step5 - Get page title name and verify with expected title");
		String expPageTitle = "Login Signup Demo";
		String actPageTitle = driver.getTitle();
		System.out.println("Step5 - " + actPageTitle);
		if(expPageTitle.equals(actPageTitle))
			System.out.println("Title of the page "+expPageTitle+" is as expected.");
		else
			System.out.println("Title is incorrect. Should be "+expPageTitle);
		System.out.println("Step6 - navigate back in history");
		driver.navigate().back();
		System.out.println("Step6 - " + driver.getTitle());
		System.out.println("Step7 - Get page title name and verify with expected title [google]");
		if(expectedTitle.equals(driver.getTitle()))
			System.out.println("Title of the page "+expectedTitle+" is as expected.");
		else
			System.out.println("Title is incorrect. Should be "+expectedTitle);
		System.out.println("Step8 - navigate forward in the history");
		driver.navigate().forward();
		System.out.println("Step9 - Get page title name and verify with expected title [automationbykrishna]");
		if(expPageTitle.equals(driver.getTitle()))
			System.out.println("Title of the page "+expPageTitle+" is as expected.");
		else
			System.out.println("Title is incorrect. Should be "+expPageTitle);
		System.out.println("Step10 - refresh the page and verify the expected title [automationbykrishna]");
		driver.navigate().refresh();
		if(expPageTitle.equals(driver.getTitle()))
			System.out.println("Title of the page "+expPageTitle+" is as expected.");
		else
			System.out.println("Title is incorrect. Should be "+expPageTitle);
		Thread.sleep(3000);
		System.out.println("Step11 - Close browser");
		driver.close();

	}

}
