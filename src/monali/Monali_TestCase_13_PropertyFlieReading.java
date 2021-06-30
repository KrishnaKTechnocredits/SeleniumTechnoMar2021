package monali;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Monali_TestCase_13_PropertyFlieReading {

static HashMap<String,Integer> countOfEmpUnderEachManager(WebDriver driver){ 
		
		HashMap<String,Integer> empCountMap = new HashMap<String,Integer>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index = 1; index<=totalRows; index++) {
			String nameOfEmp = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(empCountMap.containsKey(nameOfEmp))
				empCountMap.put(nameOfEmp, empCountMap.get(nameOfEmp)+1);
			else
				empCountMap.put(nameOfEmp, 1);
		}
		return empCountMap;
}

	static void verifyEmpCount(HashMap<String,Integer> empCountMap) throws IOException  {
		File file = new File(".//resources/deptInfo.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		
		Set<String> keys = empCountMap.keySet();
		for(String currentkey : keys ) {
			int empCountExpected = Integer.parseInt(prop.getProperty(currentkey));
			int empCountActual = empCountMap.get(currentkey);
			if(empCountExpected == empCountActual)
				System.out.println("test pass for emp "+currentkey);
			else
				System.out.println("test fail for emp "+currentkey);
		}
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String,Integer> output = countOfEmpUnderEachManager(driver);
		System.out.println(output);
		try {
			verifyEmpCount(output);
		} catch (IOException e) {
			System.out.println("could'n load emp info file into memory ");
			e.printStackTrace();
		}
	}
	}


