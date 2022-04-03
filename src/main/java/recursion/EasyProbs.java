package recursion;

public class EasyProbs {

	public static void main(String[] args) {
		//System.out.println(sumOfDigits(10));
		Integer a = new Integer(1);
		test(a);
		System.out.println(a);
	}
	
	public static void test(Integer a) {
		a = a + 1;
	}
	
	public static int sumOfDigits(int n) {
		if(n == 0) {
			return 0;
		}
		return sumOfDigits(n / 10) + n % 10;
	}
	
	public static int countDigits(int n)
    {
        if( n == 0){
            return 0;
        }
        return countDigits(n / 10) + 1;
    }
	
	public static int maxRodCuts(int n, int a ,int b, int c) {
		if( n == 0) {
			return 0;
		}
		if( n < 0) {
			return -1;
		}
		
		int res = Math.max(Math.max(maxRodCuts(n -a, a, b, c), maxRodCuts(n - b, a, b, c)), maxRodCuts(n - c, a, b, c));
		if ( res == -1) {
			return - 1;
		}
		return res + 1;
	}
		
	public static void reverseArray(int arr[], int start, int end) {
		if( start >= end) {
			return;
		}
		
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
		
		reverseArray(arr, start + 1, end - 1);
	}

	public int anotherSequence(int A) {
		if(A == 0 || A == 1){
			return 1;
		}
		if(A == 2){
			return 2;
		}
		return anotherSequence(A - 1) + anotherSequence(A - 2) + anotherSequence(A - 3) + A;
	}
}
