package datastructures.arrays;

public class ArrayProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getWater(int arr[]) {
		int n = arr.length;
		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			int lMax = arr[i];
			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, arr[i]);
			}

			int rMax = arr[i];
			for (int j = i + 1; j < n; j++) {
				rMax = Math.max(rMax, arr[i]);
			}

			res += (Math.min(lMax, rMax) - arr[i]);
		}
		return res;
	}

	public static int getWater1(int arr[]) {
		int n = arr.length;
		int res = 0;
		int lMax[] = new int[n];
		int rMax[] = new int[n];

		lMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			lMax[i] = Math.max(arr[i], lMax[i - 1]);
		}

		rMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = Math.max(arr[i], rMax[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			res += (Math.min(lMax[i], rMax[i]) - arr[i]);
		}
		return res;
	}

	public static int maxConsecOnes(int[] arr) {
		int n = arr.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = i; j < n; j++) {
				if (arr[j] == 1) {
					curr++;
				} else {
					break;
				}
			}
			res = Math.max(res, curr);
		}
		return res;
	}

	public static int maxConsecutiveOnes1(int[] arr) {
		int n = arr.length;
		int res = 0;
		int curr = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				curr = 0;
			} else {
				curr++;
				res = Math.max(res, curr);
			}
		}
		return res;
	}

	public static int minAdjDiff(int arr[]) {
		int n = arr.length;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int adj = (i + 1) % n;
			int absDiff = Math.abs(arr[i] - arr[adj]);
			minDiff = Math.min(minDiff, absDiff);
		}
		return minDiff;
	}

	public static void convertToWave(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i += 2) {
			if (i + 1 < n) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

	}
	
	 public static void frequencycount(int arr[])
	    {
		 	int n = arr.length;
	        for(int i = 0; i < n; i++){
	            arr[i] = arr[i] - 1;
	        }
	        for(int i = 0; i < n; i++){
	            arr[arr[i] % n] += n;
	        }
	        for(int i = 0; i < n;i++){
	            arr[i] = arr[i] / n;
	        }
	    }

}
