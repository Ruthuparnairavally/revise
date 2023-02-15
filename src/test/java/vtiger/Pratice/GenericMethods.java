package vtiger.Pratice;

import java.io.IOException;

import vtigerGenericUtilitu.ExcelFileUtility;
import vtigerGenericUtilitu.JavaUtility;
import vtigerGenericUtilitu.ProppertyFileUtility;

public class GenericMethods {
	
	public static void main(String[] args) throws IOException {
		JavaUtility ju = new JavaUtility();
		int num = ju.getRandomNumber();
		System.out.println(num);
		
		String date = ju.getDate();
		System.out.println(date);
		
		String dateFormat = ju.getDateInFormat();
		System.out.println(dateFormat);
		
		ProppertyFileUtility pf = new ProppertyFileUtility();
		String browser = pf.readDataFromPropertyFile("browser");
		System.out.println(browser);
		
		ExcelFileUtility ef = new ExcelFileUtility();
		String value = ef.readDataFromExcel("Organization", 4, 2);
		System.out.println(value);
		
		ef.writeDataFromExcel("Organization", 4, 6, "Ruthuparna");
		System.out.println("Data Written");
	}
}
