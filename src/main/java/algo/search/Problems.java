package algo.search;

public class Problems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long floorSqrt(long x) {
		long low = 0;
		long high = x;
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	public int peakElement(int[] arr) {
		int peakPos = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if ((i == 0 || arr[i - 1] <= arr[i]) && (i == n - 1 || arr[i + 1] <= arr[i])) {
				peakPos = i;
				break;
			}
		}
		return peakPos;
	}
	
	public int peakElement1(int[] arr) {
		int peakPos = 0;
		int n = arr.length;
		int beg = 0;
		int end = n - 1;
		while( beg <= end) {
			int mid = beg + (end - beg) / 2;
			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
				peakPos = mid;
				break;
			}
			else if(mid > 0 && arr[mid] < arr[mid - 1]) {
				end = mid - 1;
			}
			else{
				beg = mid + 1;
			}
		}
		return peakPos;
	}

}
