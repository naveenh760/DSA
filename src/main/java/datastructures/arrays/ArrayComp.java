package datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ArrayComp {

	public static void main(String[] args) {
		int[] arr = { 1,2,5,-7,2,3};
		int[] arr1 = {10,-1,2,3,-4,100 };
		int[] arr2 = { 1967513926, 1540383426, -1303455736, -521595368};
//		stockBuySell(arr);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(1);
		arrList.add(2);
	//	System.out.println(plusOne1(arrList));
		int[] ans = maxNonNegSubArray(arr2);
		for(int num:ans) {
			System.out.print(num + " ");
		}
	}

	public static ArrayList<Integer> leadersOfArrayNaive(int arr[]) {
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				leaders.add(arr[i]);
			}
		}
		return leaders;
	}

	public static ArrayList<Integer> leadersOfArray(int arr[]) {
		int n = arr.length;
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		int curLeader = arr[n - 1];
		leaders.add(curLeader);

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > curLeader) {
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
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
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

		for (int j = 1; j < n; j++) {
			maxDiff = Math.max(maxDiff, arr[j] - minVal);
			minVal = Math.min(minVal, arr[j]);
		}

		return maxDiff;
	}

	public static int maxProfit(int price[], int start, int end) {
		if (start >= end) {
			return 0;
		}

		int maxProfit = 0;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (price[j] > price[i]) {
					int curProfit = price[j] - price[i] + maxProfit(price, start, i - 1) + maxProfit(price, j + 1, end);

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
		for (int i = 1; i < n; i++) {
			if (price[i] > price[i - 1]) {
				profit += (price[i] - price[i - 1]);
			}
		}
		return profit;
	}

	public static void stockBuySell(int arr[]) {
		int n = arr.length;
		boolean buy = true;
		boolean sell = false;
		ArrayList<Integer> buyDays = new ArrayList<Integer>();
		ArrayList<Integer> sellDays = new ArrayList<Integer>();

		for (int i = 1; i < n; i++) {
			if (buy == true && sell == false) {
				// Price increased, so buy on previous day
				if (arr[i] > arr[i - 1]) {
					buyDays.add(i - 1);
					buy = false;
					sell = true;
				}
			}

			if (buy == false && sell == true) {
				// Already bought and price decreased so sell on previous day
				if (arr[i] < arr[i - 1]) {
					sellDays.add(i - 1);
					buy = true;
					sell = false;
				}
				// Already bought and last day , so sell on last day
				else if (i == n - 1) {
					sellDays.add(i);
				}
			}

		}

		StringBuilder output = new StringBuilder();
		if (buyDays.size() == 0) {
			output.append("No Profit");
		} else {
			int i;
			for (i = 0; i < buyDays.size() - 1; i++) {
				output.append("(" + buyDays.get(i) + " " + sellDays.get(i) + ")");
				output.append(" ");
			}

			output.append("(" + buyDays.get(i) + " " + sellDays.get(i) + ")");
		}
		System.out.print(output.toString());
	}

	public int maxAbsDifference(int[] A) {
		int n = A.length;
		int maxSum = Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		int maxDiff = Integer.MIN_VALUE;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = A[i] + i;
			int diff = A[i] - i;
			maxSum = Math.max(sum, maxSum);
			minSum = Math.min(sum, minSum);
			maxDiff = Math.max(diff, maxDiff);
			minDiff = Math.min(diff, minDiff);

		}

		return Math.max(maxSum - minSum, maxDiff - minDiff);
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int size = A.size();
		int currentPos = size - 1;
		long number = 0;
		for (int digit : A) {
			number += (digit * Math.pow(10, currentPos));
			currentPos--;
		}

		long resNumber = number + 1;
		while (resNumber > 0) {
			result.add((int) (resNumber % 10));
			resNumber = resNumber / 10;
		}
		Collections.reverse(result);
		return result;
	}

	public static ArrayList<Integer> plusOne1(ArrayList<Integer> A) {
		if (A.size() > 1) {
			while (A.get(0) == 0) {
				A.remove(0);
			}
		}
		Collections.reverse(A);
		int carry = 1;
		for (int i = 0; i < A.size(); i++) {
			int currentSum = A.get(i) + carry;
			if (currentSum < 10) {
				A.set(i, currentSum);
				carry = 0;
				break;
			} else if (currentSum == 10) {
				carry = 1;
				A.set(i, 0);
			}
		}
		if (carry == 1) {
			A.add(carry);
		}
		Collections.reverse(A);
		return A;
	}

	public static int[] maxNonNegSubArray(int[] A) {
		int n = A.length;
		
		long currSum = 0;
		int currStart = 0;
		
		long maxSum = Integer.MIN_VALUE;
		int maxStart = 0;
		int maxEnd = 0;
		int maxSubArrLen = 0;
		
		for(int i = 0; i < n; i++) {
			if(A[i] >= 0) {
				currSum = currSum + A[i];
			}
			else {
				if(i > 0 && A[i -1] >= 0 ) {
					int curEnd = i - 1;
					int curLen = curEnd - currStart + 1;
					if(currSum > maxSum  || (currSum == maxSum && curLen > maxSubArrLen) ){
						maxSum = currSum;
						maxStart = currStart;
						maxEnd = curEnd;
						maxSubArrLen = curLen;
					}
				}
				currStart = i + 1;
				currSum = 0;
			}
		}
		
		if(currSum > maxSum  || (currSum == maxSum && (n - 1 - currStart + 1) > maxSubArrLen) ){
			maxSum = currSum;
			maxStart = currStart;
			maxEnd = n - 1;
			maxSubArrLen = n - 1 - currStart + 1;
		}
		

		int maxRes[] = new int[maxSubArrLen];
		for(int i = maxStart; i <= maxEnd; i++) {
			maxRes[i - maxStart] = A[i];
		}
		return maxRes;
	}
	
	
	public static int[] maxNonNegSubArray1(int[] arr) {
		int n = arr.length;
		int start = -1, end = -2, maxSumStart = -1, maxSumEnd = -1;
		long maxSum = Integer.MIN_VALUE;
		long sum = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] >= 0) {
				if(start == -1) {
					start = i;
				}
				end = i;
				sum = sum + arr[i];
			}
			else {
				if(sum > maxSum || (sum == maxSum && (end - start + 1) > (maxSumEnd - maxSumStart + 1))) {
					maxSum = sum;
					maxSumStart = start;
					maxSumEnd = end;
				}
				sum = 0;
				start = -1;
			}
		}
		
		if(sum > maxSum || (sum == maxSum && (end - start + 1) > (maxSumEnd - maxSumStart + 1))) {
			maxSum = sum;
			maxSumStart = start;
			maxSumEnd = end;
		}
		
		int len = maxSumEnd - maxSumStart + 1;
		int[] res = new int[len];
		for(int i = 0; i < len; i++) {
			res[i] = arr[maxSumStart + i];
		}
		return res;
	}
	
	
	public int[] repeatedNumber(final int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
		 int[] ans = new int[2];
	     for(int num: A) {
	    	 if(set.contains(num)) {
	    		 ans[0] = num;
	    	 }
	    	 set.add(num);
	     }
	     for(int i = 1; i <= A.length; i++) {
	    	 if(!set.contains(i)) {
	    		 ans[1] = i;
	    		 break;
	    	 }
	     }
	     return ans;  
        
    }
	
	
	public int[] repeatedNumber1(final int[] arr) {
		 int[] ans = new int[2];
		 double sumArray = 0;
		 double sumArraySquared = 0;
		 int n = arr.length;
		 for(int num: arr) {
			 sumArray += num;
			 sumArraySquared += Math.pow(num, 2);
		 }
		 double sumSeries = (n * (n + 1)) / 2;
		 double sumSeriesSquared = Math.ceil(Math.pow(n, 3) / 3 +  Math.pow(n, 2) / 2 + n / 6.0);
		 
		 double diffAB = 	sumArray - sumSeries;
		 double sumAB = (sumArraySquared - sumSeriesSquared) / diffAB;
		 
		 double A = (diffAB + sumAB) / 2;
		 double B = sumAB - A;
		 
		 ans[0] = (int)Math.ceil(A);
		 ans[1] = (int) Math.ceil(B);
		 
        return ans;
    }
	
	
	public int[] repeatedNumber2(final int[] arr) {
		 int[] ans = new int[2];
		 long aMinusB = 0;
		 long diffOfSumOfSquares = 0;
		 int n = arr.length;
		 for(int i = 0; i < n; i++ ) {
			 long num = arr[i];
			 long nextI = i + 1;
			 aMinusB += arr[i];
			 aMinusB -= (i + 1);
			 diffOfSumOfSquares += (num * num);
			 diffOfSumOfSquares -= (nextI * nextI);
		 }
		 
		 long aPlusB = diffOfSumOfSquares / aMinusB;
		 
		 long A =  (aMinusB + aPlusB) / 2;
		 long B = aPlusB - A;
		 
		 ans[0] = (int) A;
		 ans[1] = (int) B;
		 
       return ans;
   }

}
