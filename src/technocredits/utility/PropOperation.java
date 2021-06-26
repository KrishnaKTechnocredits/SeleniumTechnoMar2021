package technocredits.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOperation {
	private Properties prop;
	
	public PropOperation(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		prop = new Properties();
		prop.load(inputStream);
	}
	
	
	public String getValue(String key) throws IOException {
		String value = prop.getProperty(key);
		return value;
	}
}
