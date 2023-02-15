 package vtigerGenericUtilitu;

import java.util.Date;
import java.util.Random;
/**
 * This class contains all the generic methods related to java
 * @author RUTHUPARNA
 *
 */
public class JavaUtility {

	/**
	 * This method will generate a random integer number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int rn = r.nextInt(1000);
		return rn;
	}
	
	/**
	 * This method will provide date and time in specific format 
	 * @return
	 */
	public String getDate()
	{
		Date d = new Date();
		String s = d.toString();
		return s;
	}
	/**
	 * This method will provide date and time in ordered  format 
	 * @return
	 */
	public String getDateInFormat()
	{
		Date d = new Date();
		String[] s = d.toString().split(" ");
		String date = s[2];
		String month = s[1];
		String year = s[5];
		String time = s[3].replaceAll(":", "-");
		String currentDate = date+" "+month+" "+" "+year+" "+time;
		return currentDate;
	}
}
