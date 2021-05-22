package solvingmethods.dp.dp1;

public class MaxProdSubarray {

	public static void main(String[] args) {
		int arr[] = {1, 0, 0, -2, 2, -1, -2, -1, 0, 0, 2};
		System.out.println(maxProdSubArrayTab(arr));

	}

	public static int maxProdSubArray(int arr[]) {
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int curMax = maxMinProdAtRec(arr, i)[0];
			max = Math.max(max, curMax);
		}
		return max;
	}

	public static int[] maxMinProdAtRec(int arr[], int i) {
		int result[] = new int[2];
		if(i == 0) {
			result[0] = arr[i];
			result[1] = arr[i];
			return result;
		}
		int[] prev = maxMinProdAtRec(arr, i - 1);
		result[0] = Math.max(arr[i], Math.max(prev[0]* arr[i], prev[1]*arr[i]));
		result[1] = Math.min(arr[i], Math.min(prev[0]* arr[i], prev[1]*arr[i]));
		return result;
	}
	
	
	public static int maxProdSubArrayTab(int arr[]) {
		int n = arr.length;
		int maxPrev = arr[0];
		int minPrev = arr[0];
		int maxAns = maxPrev;
		for(int i = 1; i < n; i++) {
			int max = Math.max(arr[i], Math.max(maxPrev * arr[i], minPrev * arr[i]));
			int min  = Math.min(arr[i], Math.min(maxPrev * arr[i], minPrev * arr[i]));
			maxAns = Math.max(maxAns, max);	
			maxPrev = max;
			minPrev = min;
		}
		return maxAns;
	}

}
