package demo;

import java.util.Scanner;

public class Demo1 {
	
	public static void main(String[] args) {	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter array size");
	int n=sc.nextInt();
	
	int[] arr=new int[n];
	
	int count=n;
	
	int sum =0;
	int res = 0;
	int num = 0;
	
	for(int i=0;i<count; i++) {
		System.out.println("Enter "+i+" element of array");
		arr[i]=sc.nextInt();
	}
	
	for(int i=0;i<count; i++){
		sum=sum+arr[i];
	}
	System.out.println("Sum of array is: "+sum);
	
	int average=sum/count;
	System.out.println("Average is "+average);
	
	boolean flag=false;
	
	for(int i=0;i<count; i++){
		if(average==arr[i]) {
			num=arr[i];
			res++;
			flag= true;
		}
	}
	
	if(flag) {
		System.out.println("it contains "+num+" element "+res+" times");	
	}
	else
	{
		
	}
		
}

}
