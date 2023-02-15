package vtigerGenericUtilitu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This contains all the generic methods releted to property file
 * @author RUTHUPARNA
 *
 */
public class ProppertyFileUtility {

	/**
	 * This method will read data from property file and return value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
