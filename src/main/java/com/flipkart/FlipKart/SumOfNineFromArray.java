package com.flipkart.FlipKart;

public class SumOfNineFromArray {
	public static void main(String[] args) {
		int[] arr= {1,3,6,8,5};
		int size=arr.length;
	
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==9)
				{
					System.out.println("("+arr[i]+","+arr[j]+")");
				}
			}
		}
		
	
	}

}
