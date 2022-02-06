package math.basic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stats {
	
	public static void main(String[] args) {
		int arr[] = {1,2,19,28,5};
		System.out.println(median(arr, 5));
	}
	
	public static int median(int A[],int N)
    {
       //If N is odd median = (N + 1)/2 th value
        // If N is even median = Avg(N/2th, (N/2 + 1)th)
        //Subtract 1 for 0-based index
       Arrays.sort(A);
       if( N % 2 != 0) {
    	   return A[((N + 1) / 2) -1];
       }
       else {
    	   int mid1 = A[( N/ 2) - 1];
    	   int mid2 = A[(N/2)];
    	   return (mid1 + mid2) / 2;
       }

    }
    
    public double mean(int A[])
    {
       int n = A.length;
       double sum = 0;
       for(int num:A) {
    	   sum += num;
       }
       return sum / n;
    }

    public double meanLambda(int A[]){
	   return Arrays.stream(A).average().orElse(0);
    }


}
