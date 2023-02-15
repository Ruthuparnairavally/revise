package vtiger.Pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyile {

	public static void main(String[] args) throws IOException {
	
		//Step1:Load the file location into fileinput stream
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		//Step2: Create object for properties
		Properties p = new Properties();
		
		//Step3: load  data into properties
		p.load(fis);
		 
		//Step4:Use key and read value
		String BROWSER = p.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = p.getProperty("url");
		System.out.println(URL);
		
		
	}
}
