package technocredits.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReading {

	public static void main(String[] args) throws IOException {
		File file = new File(".//resources/test.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		
		String username = prop.getProperty("username");
		System.out.println(username);
		
		String urlValue = prop.getProperty("fajkfalj");
		System.out.println(urlValue);
		
	}
}
