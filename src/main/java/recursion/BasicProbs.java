package recursion;

public class BasicProbs {

	public static void main(String[] args) {
		int n = 3;
	//	printNum1(n);
	//	printNto1(n);
	//	print1toN(n);
	//	print1toNTailRec(n, 1);
	//	System.out.println(factorial(0));
	//	System.out.println(factTailRec(n, 1));
	//	System.out.println(isPalindrome("abba"));
	//	int arr[] = new int[] {1,4,3,2};
   //		System.out.println(search(arr, 5));
		binaryRec(128);
	}
	
	public static void printNum1(int n) {
		if( n < 1) {
			return;
		}
		else {
			System.out.print(n + " ");
			printNum1(n - 1);
			System.out.print(n + " ");
		}
		
	}
	
	
	public static void printNto1(int n) {
		if( n < 1) {
			return;
		}
		System.out.print(n + " ");
		printNto1(n - 1);
	}
	
	public static void print1toN(int n) {
		if( n < 1) {
			return;
		}
		print1toN(n - 1);
		System.out.print(n + " ");
	}
	
	public static void print1toNTailRec(int n, int k) {
		if( n < 1) {
			return;
		}
		System.out.print(k + " ");
		print1toNTailRec(n - 1, k + 1);
	}
	
	public static int factorial(int n) {
		if( n == 0) {
			return 1;
		}
		return n* factorial( n - 1);
		
	}

	public static int factTailRec(int n, int val) {
		if( n == 0) {
			return val;
		}
		return factTailRec( n - 1, n*val);
		
	}
	
	public static boolean isPalindrome(String s, int beg, int end) {
		if(beg >= end) {
			return true;
		}
		if(s.charAt(beg) != s.charAt(end)) {
			return false;
		}
		return isPalindrome(s, beg + 1, end - 1);
	}
	
	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}
	
	public static boolean recursiveSearch(int arr[], int l, int r, int x) {
		if(r < l) {
			return false;
		}
		
		if(arr[l] == x) {
			return true;
		}
		if(arr[r] == x) {
			return true;
		}
		return recursiveSearch(arr, l + 1, r - 1, x);
	}
	
	public static boolean search(int arr[], int x) {
		return recursiveSearch(arr, 0, arr.length - 1, x);
	}
	
	public static void binaryRec(int n) {
		if(n == 0) {
			return;
		}
		binaryRec( n / 2);
		System.out.print(n % 2);
	}
}
