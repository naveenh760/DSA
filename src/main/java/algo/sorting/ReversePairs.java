package algo.sorting;

public class ReversePairs {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 3, 1 };
		System.out.println(getReversePairs(arr, 0, 4));

	}

	static int getReversePairs(int arr[], int start, int end) {
		int c = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			c = c + getReversePairs(arr, start, mid);
			c = c + getReversePairs(arr, mid + 1, end);
			c = c + merge(arr, start, mid, end);
		}
		return c;
	}

	private static int merge(int[] arr, int start, int mid, int end) {
		int c = 0;
		int temp[] = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			} else {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}

		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while (j <= end) {
			temp[k] = arr[j];
			k++;
			j++;
		}

		i = start;
		j = mid + 1;
		while (i <= mid && j <= end) {
			if (arr[i] > 2 * arr[j]) {
				c = c + (mid + 1 - i);
				j++;
			} else {
				i++;
			}
		}

		for (i = start; i <= end; i++) {
			arr[i] = temp[i - start];
		}
		return c;
	}

	public static void sort(int arr[]) {
		getReversePairs(arr, 0, arr.length - 1);
	}

}
