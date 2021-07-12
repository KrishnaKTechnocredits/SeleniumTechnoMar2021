package krati_Jain.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOperations {

	public void propReading(String filePath) throws IOException {
		
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
	}
}
