package demo;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args){
    	
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter array size");
    	int n = s.nextInt();
    	
    	int[] arr = new int[n];
    	
    	System.out.println("Enter array elements");
    	for(int i=0; i<n ; i++)
    	{
    		arr[i] = s.nextInt();  
    	}
    	

    	float min = arr[0];
    	float max= arr[0];
    	float minc=0;
    	float maxc=0;
    	
    	  for (int i = 0; i < arr.length ; i++) {
              if (arr[i] <= min) {
                  min = arr[i];
                  minc++; 
              }
              
          }

    	  for (int i = 0; i < arr.length ; i++) {
              if (arr[i] > max) {
                  max = arr[i];
                  maxc++;
              }
              
          }
    	  
    	  double output = (max+min)/2;
    	  
    	 System.out.println("Output is: "+output);
    }
}
