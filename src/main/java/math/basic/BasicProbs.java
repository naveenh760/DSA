package math.basic;

public class BasicProbs {

	public static int factorial(int n) {
		if(n < 0) {
			return -1;
		}
		else if(n == 0) {
			return 1;
		}
		else {
			return n* factorial(n-1);
		}
		
	}
	
	public static int nthFibo(int n) {
		if(n <= 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return nthFibo(n - 1) + nthFibo(n - 2);
		}
		
	}
	
	public static boolean isArmStrong(int n) {
		int sum = 0;
		int temp = n;
		while( temp > 0 ) {
			int digit = temp % 10;
			sum += Math.pow(digit,3);
			temp = temp / 10;
		}
		if(sum == n) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int mod(int a,int b) {
		int dividend = a / b;
		int reminder = a - (b * dividend);
		return reminder;
	}
	
	public static int divide(int a ,int b) {
		int count = 0;
		int sum = b;
		while(sum <= a) {
			count++;
			sum += b;
		}
		return count;
	}
}
