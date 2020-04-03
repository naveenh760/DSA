package math.basic;

import java.util.Arrays;

public class Stats {
	
	public static void main(String[] args) {
		int arr[] = {1,2,19,28,5};
		System.out.println(median(arr, 5));
	}
	
	public static int median(int A[],int N)
    {
      
       Arrays.sort(A);
       if( N % 2 != 0) {
    	   return A[((N + 1) / 2) -1];
       }
       else {
    	   int mid1 = A[( N/ 2) - 1];
    	   int mid2 = A[(N/2)];
    	   return (mid1 + mid2) / 2;
       }
       
       //Your code here
       //If median is fraction then conver it to integer and return
    }
    
    public int mean(int A[],int N)
    {
       int sum = 0;
       for(int num:A) {
    	   sum += num;
       }
       return sum / N;
    }


}
