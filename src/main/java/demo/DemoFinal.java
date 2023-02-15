package demo;

public class DemoFinal {
	
	public static void main(String[] args) {
		
		String s = "MALAYALAM";
		
		String rev = "";
		
		for(int i=0;i<s.length();i++)
		{
			 char c = s.charAt(i);
			 
			 rev = c + rev;
		}
		
		System.out.println(s);
		System.out.println(rev);
		
		if(s.equals(rev))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
	}
	
	

}
