package datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindow {

	public static void main(String[] args) {
		int[] arr = {1,4,20,3,10,9};
	//	subArraySum(arr, 100);
		int arr1[] = nBonacci(3, 7);
		for(int element: arr1) {
			System.out.print(element + " ");
		}
		
	}

	public static int maxSumOfK(int arr[], int k) {
		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n - k + 1; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += arr[j];
			}
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

	public static int maxSumOfKSW(int arr[], int k) {
		int n = arr.length;
		int currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += arr[i];
		}
		int maxSum = currSum;

		for (int j = k; j < n; j++) {
			currSum += (arr[j] - arr[j - k]);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 */
	public static ArrayList<Integer> subArraySum(ArrayList<Integer> A, int B) {
		int n = A.size();
		int i = 0, j = 0;
		long currSum = A.get(0);
		while(j < n){
			if(currSum == B){
				break;
			}
			else if(currSum > B){
				currSum -= A.get(i);
				i++;
			}
			else{
				j++;
				if(j < n){
					currSum += A.get(j);
				}
			}
		}
		if(j == n){
			return new ArrayList<Integer>(Arrays.asList(-1));
		}
		return new ArrayList<Integer>(A.subList(i, j+1));
	}
	
	
	public static int[] nBonacci(int n, int m) {
		//Assuming m > n
		int arr[] = new int[m];
		Arrays.fill(arr, 0);
		arr[n- 1] = 1;
		int currSum = 1;
		arr[n] = currSum;
		
		for(int i=n; i < m -1; i++) {
			currSum = currSum + arr[i] - arr[i - n];
			arr[i + 1] = currSum;
		}
		return arr;
	}

}
