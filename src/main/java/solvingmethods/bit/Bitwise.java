package solvingmethods.bit;

import java.util.Arrays;

public class Bitwise {
	
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,1,5,3};
	//	System.out.println(singleNumberII(arr));
		long a = 3;
		int b = 3;
		System.out.println(reverse(b));
		System.out.println(reverse1(a));
	}

	public static boolean isKthSet(int n, int k) {
		if ((n & (1 << k - 1)) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static int setKthBit(int n, int k) {
		return (n | (1 << k - 1));

	}

	public static int clearKthBit(int n, int k) {
		return (n & ~(1 << k - 1));
	}

	public static int toggleKthBit(int n, int k) {
		return (n ^ (1 << k - 1));
	}

	public static int clearRighmostSetBit(int n) {
		return (n & (n - 1));
	}

	public static boolean isPowerofTwo1(int n) {
		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}

	public static boolean isPowerOfTwo2(int n) {
		if (n == 0) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}

	public static int sumHammington(int[] A) {
		int n = A.length;
		int mod = (int) Math.pow(10, 9) + 7;
		long ans = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if ((A[j] & (1 << i)) > 0) {
					count++;
				}
			}
			ans = ans + (2L * count * (A.length - count));
			ans = ans % mod;
		}
		return (int) (ans);
	}

	public static int singleNumberII(final int[] A) {
		int n = A.length;
		int ans = 0;
		for(int i = 0; i < 32; i++) {
			int countOne = 0;
			for(int j = 0; j < n; j++) {
				if((A[j] & (1 << i)) > 0) {
					countOne++;
				}
			}
			if(countOne % 3 == 1) {
				ans = ans + (1 << i);
			}
		}
		
		return ans;
	}
	
	public static int[] singleNumberIII(final int[] A) {
		int n = A.length;
        int oddSumPos = -1;
        for(int i = 0 ; i < 32; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if((A[j] & 1 << i) > 0){
                    count++;
                }
            }
            if(count % 2 != 0){
                oddSumPos = i;
                break;
            }
        }
        int xor1 = 0;
        int xor2 = 0;
        for(int j = 0; j < n; j++){
            if((A[j] & 1 << oddSumPos) > 0){
                xor1 = xor1 ^ A[j];
            }
            else{
                xor2 = xor2 ^ A[j];
            }
        }
    int[] ans = {xor1, xor2};
    Arrays.sort(ans);
    
    return ans;
	}
	
	public static long reverse(long a) {
		int n = Long.SIZE;
		long reverseVal = 0;
		for(int i = 0; i < n; i++) {
			if( (a & ((long)1 << i)) > 0 ) {
				reverseVal = reverseVal | ((long)1 << (n - 1 - i));
			}
		}
		
		System.out.println(Long.toBinaryString(reverseVal));
		return reverseVal;
	}
	
	public static int reverse(int a) {
		int n = Integer.SIZE;
		int reverseVal = 0;
		for(int i = 0; i < n; i++) {
			if( (a & (1 << i)) > 0 ) {
				reverseVal = reverseVal | (1 << (n - 1 - i));
			}
		}
		
		System.out.println(Integer.toBinaryString(reverseVal));
		return reverseVal;
	}
	
	public static long reverse1(long a) {
		int n = 32;
		long reverseVal = 0;
		for(int i = 0; i < n; i++) {
			if( (a & (1L << i)) > 0 ) {
				reverseVal = reverseVal | (1L << (n - 1 - i));
			}
		}
		
		System.out.println(Long.toBinaryString(reverseVal));
		return reverseVal;
	}

}
