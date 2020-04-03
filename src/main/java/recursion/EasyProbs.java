package recursion;

import java.util.ArrayList;

public class EasyProbs {

	public static void main(String[] args) {
		//System.out.println(sumOfDigits(10));
		powerSet("ABC");

	}
	
	public static int sumOfDigits(int n) {
		if(n == 0) {
			return 0;
		}
		return sumOfDigits(n / 10) + n % 10;
	}
	
	public static int countDigits(int n)
    {
        if( n == 0){
            return 0;
        }
        return countDigits(n / 10) + 1;
    }
	
	public static int maxRodCuts(int n, int a ,int b, int c) {
		if( n == 0) {
			return 0;
		}
		if( n < 0) {
			return -1;
		}
		
		int res = Math.max(Math.max(maxRodCuts(n -a, a, b, c), maxRodCuts(n - b, a, b, c)), maxRodCuts(n - c, a, b, c));
		if ( res == -1) {
			return - 1;
		}
		return res + 1;
	}
	
	
	public static void powerSet(String input, int index, String current) {
		if(index == input.length()) {
			System.out.print(current + " ");
			return;
		}
		
		powerSet(input, index + 1, current + input.charAt(index));
		powerSet(input, index + 1, current);
	}

	public static void powerSet(String input) {
		powerSet(input, 0, "");
	}
	
	
	public static void reverseArray(int arr[], int start, int end) {
		if( start >= end) {
			return;
		}
		
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
		
		reverseArray(arr, start + 1, end - 1);
	}
}
