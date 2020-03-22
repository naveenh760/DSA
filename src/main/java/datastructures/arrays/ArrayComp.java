package datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<Integer> leadersOfArrayNaive(int arr[]){
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			boolean flag = true;
			for(int j = i + 1; j < n; j++) {
				if(arr[j] > arr[i]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				leaders.add(arr[i]);
			}
		}
		return leaders;
	}
	
	public static ArrayList<Integer> leadersOfArray(int arr[]){
		int n = arr.length;
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		int curLeader = arr[n - 1];
		leaders.add(curLeader);
		
		for(int i = n - 2; i >= 0; i --) {
			if(arr[i] > curLeader) {
				curLeader = arr[i];
				leaders.add(curLeader);
			}
		}
		Collections.reverse(leaders);
		return leaders;
	}
	
	public static int maxDiffNaive(int arr[]) {
		int n = arr.length;
		int maxDiff = arr[1] - arr[0];
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				int diff = arr[j] - arr[i];
				maxDiff = Math.max(diff, maxDiff);
			}
		}
		return maxDiff;
	}
	
	public static int maxDiff(int arr[]) {
		int n = arr.length;
		int maxDiff = arr[1] - arr[0];
		int minVal = arr[0];
		
		for(int j = 1; j < n; j++) {
			maxDiff = Math.max(maxDiff, arr[j] - minVal);
			minVal = Math.min(minVal, arr[j]);
		}
		
		return maxDiff;
	}
	
	public static int maxProfit(int price[], int start, int end) {
		if( start >= end) {
			return 0;
		}
		
		int maxProfit = 0;
		for(int i = start; i < end; i++) {
			for(int j = i + 1; j <= end; j++) {
				if(price[j] > price[i]) {
					int curProfit = price[j] - price[i] + maxProfit(price, start, i - 1) 
					 + maxProfit(price, j + 1, end);
					
					maxProfit = Math.max(maxProfit, curProfit);
				}
			}
		}
		return maxProfit;
	}
	
	public static int maxProfit(int price[]) {
		return maxProfit(price, 0, price.length - 1);
	}
	
	
	public static int maxProfit1(int price[]) {
		int n = price.length;
		int profit = 0;
		for(int i = 1; i < n; i++) {
			if(price[i] > price[i - 1]) {
				profit += (price[i] - price[i - 1]);
			}
		}
		return profit;
	}

}
