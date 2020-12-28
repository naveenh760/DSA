package recursion.backtrack;

public class ArrayPerm {

	public static void main(String[] args) {
		int[] arr = { 2,2,7,1,1};
		int[] arr1 = {36229, 1020, 69, 127, 162, 127 };
	//	System.out.println(allPerm(arr, 0, arr.length -1));
		System.out.println(countSquareful(arr1, 0, arr1.length -1));
	}

	static int allPerm(int[] arr, int l, int r) {
		int count = 0;
		if (l == r) {
			System.out.println(arrayToString(arr));
			return 1;
		}
		for (int i = l; i <= r; i++) {
			if (shouldSwap(arr, l, i)) {
				swap(arr, l, i);	
				count += allPerm(arr, l + 1, r);
				swap(arr, l, i);
			}
		}
		return count;
	}
	
	static boolean shouldSwap(int[] arr, int l, int curr) {
		for(int i = l; i < curr; i++) {
			if(arr[i] == arr[curr]) {
				return false;
			}
		}
		return true;
	}
	
	static int countSquareful(int[] arr, int l, int r) {
		int count = 0;
		if (l == r && isSquareful(arr,0, arr.length -1)) {
			System.out.println(arrayToString(arr));
			return 1;
		}
		for (int i = l; i <= r; i++) {
			if(shouldSwap(arr, l, i)) {
				if(l == 0 || l == 1 || isSquareful(arr, l-2, l-1))
				{
					swap(arr, l, i);
					count += countSquareful(arr, l + 1, r);
					swap(arr, l, i);
				}
				
			}
		}
		return count;
	}
	

	private static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;

	}

	private static String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(num);
			sb.append(" ");
		}
		return sb.toString();
	}

	private static boolean isSquareful(int[] arr, int left, int right) {
		int n = arr.length;
		if(n == 1){
		    return false;
		}
		for (int i = left; i < right; i++) {
			int sum = arr[i] + arr[i + 1];
			if (!isPerfectSquare(sum)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPerfectSquare(int num) {
		double sqrt = Math.sqrt(num);
		if (sqrt - Math.floor(sqrt) == 0) {
			return true;
		}
		return false;
	}

}
