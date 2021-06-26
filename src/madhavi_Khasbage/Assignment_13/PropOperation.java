package madhavi_Khasbage.Assignment_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOperation {
	Properties prop;
	PropOperation(String filepath) throws IOException{
		File file=new File(filepath);
		FileInputStream inputStream=new FileInputStream(file);		
	    prop =new Properties();		
		prop.load(inputStream);
	}
	
	public String getValue(String keys) {		
		String value=prop.getProperty(keys);
		return value;
	}

}
