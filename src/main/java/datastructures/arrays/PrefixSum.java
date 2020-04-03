package datastructures.arrays;

import java.util.Arrays;

public class PrefixSum {
	
	static int MAX = 1000;
	
	public static void main(String[] args) {
		int arr[] = {3,4,8, -9, 20,6};
		int output = getEquilibriumPoint2(arr);
//		System.out.println(output);
		
		int[] L = { 1, 4, 9, 13, 21 }; 
		int[] R = { 15, 8, 12, 20, 30 }; 
		System.out.println(maxOccuredElement(L, R)); 
	}
	
	public static int[] fillPrefixSum(int arr[]) {
		int n = arr.length;
		int[] prefixSums = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			prefixSums[i] = sum;
		}
		return prefixSums;
	}
	
	
	public static int getSum(int arr[], int prefixSums[],int l, int r) {
		if(l == 0) {
			return prefixSums[r];
		}
		else {
			return prefixSums[r] - prefixSums[l - 1];
		}
	}
	
	public static int getEquilibriumPointNaive(int arr[]) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			int lSum = 0;
			for(int j = 0; j < i ; j++) {
				lSum += arr[j];
			}
			int rSum = 0;
			for(int k = i + 1; k < n; k++) {
				rSum += arr[k];
			}
			
			if(lSum == rSum) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getEqulibriumPoint1(int arr[]) {
		int n = arr.length;
		int[] preFixSums = fillPrefixSum(arr);
		int lSum = 0;
		int rSum = 0;
		for(int i = 0; i < n; i++) {
			if( i != 0) {
				lSum = preFixSums[i - 1];
			}
			rSum = preFixSums[n - 1] - preFixSums[i];
			if(lSum == rSum) {
				return  i;
			}
			
		}
		return -1;
	}
	
	public static int getEquilibriumPoint2(int arr[]) {
		int n = arr.length;
		int lSum = 0;
		int rSum = 0;
		int totalSum = 0;
		for(int element: arr) {
			totalSum += element;
		}
		for(int i = 0; i < n; i++) {
			rSum = totalSum - arr[i] - lSum;
			if(lSum == rSum) {
				return i;
			}
			lSum += arr[i];
		}
		return -1;
	}
	
	public static int maxOccuredElement(int L[], int R[]) {
		int n = L.length;
		int arr[] = new int[MAX];
		Arrays.fill(arr, 0);
		int maxI = -1;
		
		for(int i = 0; i < n; i++) {
			arr[L[i]]++;
			arr[R[i] + 1] --;
			maxI = Math.max(R[i], maxI);
		}
		
		int maxSum = arr[0];
		int maxSumInd = 0;
		for(int i= 1; i <= maxI; i++) {
			arr[i] += arr[i - 1];
			if(arr[i] > maxSum) {
				maxSum = arr[i];
				maxSumInd = i;
			}
		}
		return maxSumInd;
	}
	
	public static int maxElement(int n,int L[], int R[], int numberToAdd) {
		int arr[] = new int[n];
		Arrays.fill(arr, 0);
		
		int m = L.length;
		for(int i = 1; i <= m; i++) {
			arr[L[i]] += numberToAdd;
			if(R[i] < n - 1) {
				arr[R[i] + 1] -= numberToAdd;
			}
		}
		
		int prefixSum[] = fillPrefixSum(arr);
		int max = 0;
		for(int element: prefixSum) {
			max = Math.max(element, max);
		}
		return max;
	}

}
