package solvingmethods.bit;

public class Bitwise {

	public static boolean isKthSet(int n, int k) {
		if( (n & (1 << k -1)) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int setKthBit(int n, int k) {
		return ( n | (1 << k -1));

	}
	
	public static int clearKthBit(int n, int k) {
		return ( n & ~(1 << k - 1));
	}
	
	public static int toggleKthBit(int n, int k) {
		return (n ^ (1 << k-1));
	}
	
	public static int clearRighmostSetBit(int n) {
		return (n & (n -1));
	}
	
	public static boolean isPowerofTwo1(int n) {
		while( n != 1) {
			if( n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}
	
	public static boolean isPowerOfTwo2(int n) {
		if( n == 0) {
			return false;
		}
		return  (n & (n - 1)) == 0;
	}
	
	
	
	
}
