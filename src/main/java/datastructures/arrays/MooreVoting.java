package datastructures.arrays;

public class MooreVoting {

	public static int findMajority(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] == arr[i]) {
					count++;
				}
			}
			if (count > n / 2) {
				return i;
			}
		}
		return -1;
	}

	public static int findMajority1(int arr[]) {
		int n = arr.length;
		int count = 0;
		int majorInd = findCandidate(arr);
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[majorInd]) {
				count++;
			}
		}
		if( count > n / 2) {
			return majorInd;
		}
		else {
			return -1;
		}
	}

	public static int findCandidate(int arr[]) {
		int n = arr.length;
		int majorInd = 0;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[majorInd]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majorInd = i;
				count = 1;
			}
		}
		return majorInd;
	}

}
