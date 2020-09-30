package datastructures.arrays;

public class Descriptive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxConsecutiveLandNaive(int arr[], int k) {
		int n = arr.length;
		int maxCount = 0;
		for (int i = 0; i < n; i++) {
			int treesAllowedToCut = k;
			int count = 0;
			for (int j = i; j < n; j++) {
				if (arr[j] == 0) {
					count++;
				} else if (treesAllowedToCut > 0) {
					count++;
					treesAllowedToCut--;
				} else if (treesAllowedToCut == 0) {
					break;
				}
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	int maxConsecutiveLand(int arr[], int k) {
		int ans = 0;
		int start = 0;
		int end = 0;
		int trees = 0;
		int n = arr.length;
		while (end < n) {
			if (arr[end] == 1) {
				trees++;
			}
			if (trees > k) {
				if (arr[start] == 1) {
					trees--;
				}
				start++;
			}
			ans = Math.max(ans, end - start + 1);
			end++;
		}
		return ans;
	}

}
