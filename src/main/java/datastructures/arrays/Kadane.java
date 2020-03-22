package datastructures.arrays;

public class Kadane {
	
	
	public static int maxSubArraySum(int arr[]) {
		int n = arr.length;
		int res = arr[0];
		for(int i = 0; i < n; i++) {
			int curr = 0;
			for(int j = i; j < n; j++) {
				curr = curr + arr[j];
				res = Math.max(curr, res);
			}
		}
		return res;
	}
	
	
	public static int maxSubArraySumK(int arr[]) {
		int n = arr.length;
		int res = arr[0];
		int maxEnding = arr[0];
		for(int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}
	
	
	public static int maxEvenOdd(int arr[]) {
		int n = arr.length;
		int res = 1;
		for(int i = 0; i< n; i++) {
			int curr = 1;
			for(int j = i+1; j < n; j++) {
				if((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) || (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0 )  ) {
					curr++;
				}
				else {
					break;
				}
			}
			res = Math.max(res, curr);
		}
		return res;
	}
	
	public static int maxEvenOddK(int arr[]) {
		int n = arr.length;
		int res = 1; int curr = 1;
		for(int i = 1; i < n;i++) {
			if((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0 )  ) {
				curr++;
				res = Math.max(res, curr);
			}
			else {
				curr = 1;
			}
		}
		return res;
	}
	
	
	public static int maxCircularSum(int arr[]) {
		int n = arr.length;
		int maxSum = arr[0];
		for(int i = 0; i < n; i++) {
			int currSum = arr[i];
			for(int j = 1; j < n; j++) {
				int index = ( i  + j) % n;
				currSum = currSum + arr[index];
				maxSum = Math.max(currSum, maxSum);
			}
		}
		return maxSum;
	}
	
	
	public static int maxCircularSumK(int arr[]) {
		int n = arr.length;
		int maxNormalSum = maxSubArraySumK(arr);
		if(maxNormalSum < 0) {
			return maxNormalSum;
		}
		
		int arrSum = 0;
		for(int i = 0; i < n; i++) {
			arrSum+= arr[i];
			arr[i] = -arr[i];
		}
		
		int maxCircular = arrSum + maxSubArraySumK(arr);
		return Math.max(maxNormalSum, maxCircular);
	}

}
