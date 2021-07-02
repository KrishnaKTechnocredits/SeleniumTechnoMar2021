package monali.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertyFile {

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
	
}
