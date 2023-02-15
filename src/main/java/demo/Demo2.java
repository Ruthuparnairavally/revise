package demo;

import java.util.Arrays;

public class Demo2 {
	
	public static void sendmail(String eid) {
		System.out.println("Email sent to "+eid);
	}

	public static void main(String[] args) {
		
		String[] email = {"ghi@hotmail.com", "def@yahoo.com", "ghi@gmail.com", "abc@channelier.com", "abc@hotmail.com", "def@hotmail.com", "abc@gmail.com", "abc@yahoo.com", "def@channelier.com", "jkl@hotmail.com", "ghi@yahoo.com", "def@gmail.com"};
		
		Arrays.sort(email);   
		
		//prints array using the for loop  
		for (int i = 0; i < 4; i++)   
		{       
			String eid = email[i];
			sendmail(eid);
			
		}   
		
	}
}